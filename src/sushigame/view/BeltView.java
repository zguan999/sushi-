package sushigame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

public class BeltView extends JPanel implements BeltObserver {

	private Belt belt;
	private JLabel[] belt_labels;
	private JPanel[] belt_panels;
	PlateViewWidget plate_view;

	public BeltView(Belt b) {
		this.belt = b;
		belt.registerBeltObserver(this);
		setLayout(new GridLayout(belt.getSize(), 1));
		belt_labels = new JLabel[belt.getSize()];
		belt_panels = new JPanel[belt.getSize()];
		plate_view = new PlateViewWidget(belt, belt_panels);
		
		for (int i = 0; i < belt.getSize(); i++) {
			JLabel plabel = new JLabel("");
			// plabel.setMinimumSize(new Dimension(300, 20));
			// plabel.setPreferredSize(new Dimension(300, 20));
			// plabel.setOpaque(true);
			// plabel.setBackground(Color.GRAY);
			JPanel ppanel = new JPanel();
			ppanel.setMinimumSize(new Dimension(300, 20));
			ppanel.setPreferredSize(new Dimension(300, 20));
			// ppanel.setOpaque(true);
			ppanel.setBackground(Color.GRAY);
			ppanel.add(plabel);
			add(ppanel);
			ppanel.addMouseListener(plate_view);
			belt_labels[i] = plabel;
			belt_panels[i] = ppanel;
		}
		refresh();
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {	
		refresh();
	}

	private void refresh() {
		for (int i=0; i<belt.getSize(); i++) {
			Plate p = belt.getPlateAtPosition(i);
			
			JLabel plabel = belt_labels[i];
			JPanel ppanel = belt_panels[i];
			
			int pos = i; 

			if (p == null) {
				plabel.setText("empty belt");
				ppanel.setBackground(Color.GRAY);
			} else {
				plabel.setText(p.getChef().getName() + "'s" + " " + p.getColor() +" PLATE" + " @ Position" + " " +i );
				switch (p.getColor()) {
				case RED:
					// plabel.setBackground(Color.RED);
					ppanel.setBackground(Color.RED);
					break;
				case GREEN:
					// plabel.setBackground(Color.GREEN);
					ppanel.setBackground(Color.GREEN);
					break;
				case BLUE:
					// plabel.setBackground(Color.BLUE);
					ppanel.setBackground(Color.CYAN);
					break;
				case GOLD:
					// plabel.setBackground(Color.YELLOW);
					ppanel.setBackground(Color.YELLOW);
					break;
				}
			}
		}
	}
	
}
