package sushigame.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sushigame.model.*;
public class PlateViewWidget extends JPanel implements MouseListener {
	private Belt belt; 
	private JPanel[] panels;
	
	public PlateViewWidget(Belt belt, JPanel[] panels) {
		this.belt = belt; 
		this.panels = panels;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < panels.length; i++) {
			try {
			if (e.getSource() == panels[i]) {
				
//				if (belt.getPlateAtPosition(i).getContents() == null) {
//					JOptionPane.showMessageDialog(null, "Nothing at this Position", "Position Error", JOptionPane.INFORMATION_MESSAGE);
//					throw new RuntimeException();
//				}
				
				String name = belt.getPlateAtPosition(i).getContents().getName();
				String ingredients = "";
				
				if(name.contains("Roll")) {
					for (int j = 0; j < belt.getPlateAtPosition(i).getContents().getIngredients().length; j++) {
						ingredients += "        " + belt.getPlateAtPosition(i).getContents().getIngredients()[j].getName() + ": " + 
					belt.getPlateAtPosition(i).getContents().getIngredients()[j].getAmount() + "\n";
					}
					JOptionPane.showMessageDialog(null, "Chef Name: " + belt.getPlateAtPosition(i).getChef().getName() +
							"\nSushi Type:" + " " + "Roll" + "\nRoll Name: " + " " + belt.getPlateAtPosition(i).getContents().getName() +
							"\nIngredients + Amount:\n" + ingredients
							+ "Age of Plate:" + " " + belt.getAgeOfPlateAtPosition(i) + " " + "\nPlate Color:" + " " + belt.getPlateAtPosition(i).getColor(), 
							"Plate Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					
					JOptionPane.showMessageDialog(null, "Chef Name: " + belt.getPlateAtPosition(i).getChef().getName() + "\nSushi Type: " +
							belt.getPlateAtPosition(i).getContents().getName() + "\nAge of Plate:" + " " + belt.getAgeOfPlateAtPosition(i)
							+ "\nPlate Color:" + " " + belt.getPlateAtPosition(i).getColor(), "Plate Infos", JOptionPane.INFORMATION_MESSAGE);
				}
			} 
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Nothing at this Position", "Position Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// Please read every comment
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// Are 
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
