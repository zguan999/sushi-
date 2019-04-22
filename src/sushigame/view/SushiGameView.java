package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;

import comp401.sushi.Plate;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.SushiGameModel;

public class SushiGameView extends JPanel implements ActionListener, BeltObserver {

	private PlayerChefView player_chef_ui;
	private List<RotationRequestListener> rotation_request_listeners;
	private JLabel controller_messages;
	private JLabel jank; 
	private JButton button; 
	private ScoreboardWidget scoreboard;
	private JPanel east_panel;
	//private JPanel sub_panel;
	private JComboBox sushi_box;
	private JComboBox pos_box; 
	private int currentSush; 
	private JLabel typesushi;
	private String rolltype;
	private int sushipos;
	//private boolean thingchosen; 


	public SushiGameView(SushiGameModel game_model) {
		setLayout(new BorderLayout());

		
		
		//East Panel Junk
//		east_panel = new JPanel();

				
		//West Panel Stuff
		JPanel west_panel = new JPanel();
		west_panel.setPreferredSize(new Dimension(150,20));
		west_panel.setLayout(new BorderLayout());

		scoreboard = new ScoreboardWidget(game_model);
		west_panel.add(scoreboard, BorderLayout.NORTH);

		button = new JButton("Change ScoreBoard");
		//String Value that will help with belt view 
		button.setActionCommand("change");
		west_panel.add(button, BorderLayout.AFTER_LAST_LINE);

		button.addActionListener(scoreboard);

		player_chef_ui = new PlayerChefView(game_model.getBelt().getSize());
		add(player_chef_ui, BorderLayout.EAST);

		BeltView belt_view = new BeltView(game_model.getBelt());
		add(belt_view, BorderLayout.CENTER);

		JPanel bottom_panel = new JPanel();
		bottom_panel.setLayout(new BorderLayout());

		JButton rotate_button = new JButton("Rotate");
		rotate_button.setActionCommand("rotate");
		rotate_button.addActionListener(this);

		bottom_panel.add(rotate_button, BorderLayout.WEST);

		jank = new JLabel("click on plates for more janky info");
		bottom_panel.add(jank, BorderLayout.AFTER_LINE_ENDS);

		controller_messages = new JLabel("Controller messages.");
		bottom_panel.add(controller_messages, BorderLayout.CENTER);

		add(bottom_panel, BorderLayout.SOUTH);
		add(west_panel, BorderLayout.WEST);
		
		rotation_request_listeners = new ArrayList<RotationRequestListener>();

		game_model.getBelt().registerBeltObserver(this);
	}

	public void registerPlayerChefListener(ChefViewListener cl) {
		player_chef_ui.registerChefListener(cl);
	}

	public void registerRotationRequestListener(RotationRequestListener rrl) {
		rotation_request_listeners.add(rrl);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("rotate")) {
			for (RotationRequestListener rrl : rotation_request_listeners) {
				rrl.handleRotationRequest();
			}

		}
	}

	public void setControllerMessage(String message) {
		controller_messages.setText(message);
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE) {
			controller_messages.setText("");
		}
	}

	public void refreshScoreboard() {
		scoreboard.refresh();
	}
}
