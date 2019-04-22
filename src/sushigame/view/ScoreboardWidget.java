package sushigame.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.Chef;
import sushigame.model.ChefImpl;
import sushigame.model.SushiGameModel;

public class ScoreboardWidget extends JPanel implements BeltObserver,ActionListener {

	private SushiGameModel game_model;
	private JLabel display;
	private JButton button; 
	private int viewMode;
	
	public ScoreboardWidget(SushiGameModel gm) {
		game_model = gm;
		game_model.getBelt().registerBeltObserver(this);
		viewMode = 0;
		
		display = new JLabel();
		display.setVerticalAlignment(SwingConstants.TOP);
		setLayout(new BorderLayout());
		add(display, BorderLayout.CENTER);
		display.setText(makeScoreboardHTML());
	}

	private String makeScoreboardHTML() {
		String sb_html = "";
		if (viewMode == 0) {
			sb_html = "<html>";
			sb_html += "<h1>Scoreboard</h1>";
			sb_html += "<h3>MostMoney</h3>";
	
			// Create an array of all chefs and sort by balance.
			Chef[] opponent_chefs= game_model.getOpponentChefs();
			Chef[] chefs = new Chef[opponent_chefs.length+1];
			chefs[0] = game_model.getPlayerChef();
			for (int i=1; i<chefs.length; i++) {
				chefs[i] = opponent_chefs[i-1];
			}
			Arrays.sort(chefs, new HighToLowBalanceComparator());
			
			for (Chef c : chefs) {
				sb_html += c.getName() + " ($" + Math.round(c.getBalance()*100.0)/100.0 + ") <br>";
			}
		}
		else if (viewMode == 1) {
			sb_html = "<html><h1>Scoreboard</h1>";
			sb_html += "<h3>MostPlatesSpoiled</h3>";
			// Create an array of all chefs and sort by balance.
			Chef[] opponent_chefs= game_model.getOpponentChefs();
			Chef[] chefs = new Chef[opponent_chefs.length+1];
			chefs[0] = game_model.getPlayerChef();
			for (int i=1; i<chefs.length; i++) {
				chefs[i] = opponent_chefs[i-1];
			}
			Arrays.sort(chefs, Comparator.comparing(Chef::getAmountSpoiled));
				
			for (Chef c : chefs) {
				sb_html += c.getName() + " (" + c.getAmountSpoiled() + ") <br>";
			}
			sb_html += "</html>";
			
		} else {
			sb_html = "<html><h1>Scoreboard</h1>";
			sb_html += "<h3>MostPlatesConsumed</h3>";
			// Create an array of all chefs and sort by balance.
			Chef[] opponent_chefs= game_model.getOpponentChefs();
			Chef[] chefs = new Chef[opponent_chefs.length+1];
			chefs[0] = game_model.getPlayerChef();
			for (int i=1; i<chefs.length; i++) {
				chefs[i] = opponent_chefs[i-1];
			}
			Arrays.sort(chefs, Comparator.comparing(Chef::getAmountEaten).reversed());
				
			for (Chef c : chefs) {
				sb_html += c.getName() + " (" + c.getAmountEaten()+ ") <br>";
			}
			sb_html += "</html>";
		}
		return sb_html;
	}

	public void refresh() {
		display.setText(makeScoreboardHTML());		
	}
	
	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE) {
			refresh();
		}		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// if(e.getType() == BeltEvent.Event) {
		// 	
		// }
		viewMode++;
		viewMode %= 3;
		refresh();
	}
}
