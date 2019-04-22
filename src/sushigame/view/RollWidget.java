package sushigame.view;

import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class RollWidget extends JPanel{
	private JTextField rollname;
	
	public RollWidget(PlayerChefView sg) {
	
	JLabel roll_name = new JLabel("Name of Roll:");
	rollname = new JTextField(20);
	rollname.addActionListener(sg);
	rollname.setActionCommand("name");


	add(roll_name);
	add(rollname);
	JLabel ingreds= new JLabel("Watchu want in dis roll:");
	add(ingreds);


	JCheckBox salmon_ingredient = new JCheckBox("Salmon");
	salmon_ingredient.setMnemonic(KeyEvent.VK_C);
	salmon_ingredient.setSelected(true);
	salmon_ingredient.addActionListener(sg);
	//add action command

	add(salmon_ingredient);
	JLabel amount_s = new JLabel("Amount:");
	JTextField amount_salmon = new JTextField(20);
	amount_salmon.addActionListener( sg);
	add(amount_s);
	add(amount_salmon);

	JCheckBox seaweed_ingredient = new JCheckBox("Seaweed");
	salmon_ingredient.setMnemonic(KeyEvent.VK_C);
	salmon_ingredient.setSelected(true);
	salmon_ingredient.addActionListener( sg);
	//add action command
	add(seaweed_ingredient);

	JLabel amount_se = new JLabel("Amount:");
	JTextField amount_seaweed = new JTextField(20);
	amount_salmon.addActionListener( sg);
	 add(amount_se);
	 add(amount_seaweed);

	JCheckBox crab_ingredient = new JCheckBox("Crab");
	salmon_ingredient.setMnemonic(KeyEvent.VK_C);
	salmon_ingredient.setSelected(true);
	salmon_ingredient.addActionListener( sg);
	//add action command
	 add(crab_ingredient);

	JLabel amount_c = new JLabel("Amount:");
	JTextField amount_crab = new JTextField(20);
	amount_salmon.addActionListener( sg);
	 add(amount_c);
	 add(amount_crab);

	JCheckBox rice_ingredient = new JCheckBox("Rice");
	salmon_ingredient.setMnemonic(KeyEvent.VK_C);
	salmon_ingredient.setSelected(true);
	salmon_ingredient.addActionListener( sg);
	//add action command
	 add(rice_ingredient);

	JLabel amount_r= new JLabel("Amount:");
	JTextField amount_rice = new JTextField(20);
	amount_salmon.addActionListener( sg);
	 add(amount_r);
	 add(amount_rice);

	JCheckBox eel_ingredient = new JCheckBox("Eel");
	salmon_ingredient.setMnemonic(KeyEvent.VK_C);
	salmon_ingredient.setSelected(true);
	salmon_ingredient.addActionListener( sg);
	//add action command

	 add(eel_ingredient);
	JLabel amount_e = new JLabel("Amount:");
	JTextField amount_eel = new JTextField(20);
	amount_salmon.addActionListener( sg);
	 add(amount_e);
	 add(amount_eel);

	JCheckBox tuna_ingredient = new JCheckBox("Tuna");
	salmon_ingredient.setMnemonic(KeyEvent.VK_C);
	salmon_ingredient.setSelected(true);
	salmon_ingredient.addActionListener( sg);
	//add action command

	 add(tuna_ingredient);
	JLabel amount_t = new JLabel("Amount:");
	JTextField amount_tuna = new JTextField(20);
	amount_salmon.addActionListener( sg);
	 add(amount_t);
	 add(amount_tuna);

	JCheckBox shrimp_ingredient = new JCheckBox("Shrimp");
	salmon_ingredient.setMnemonic(KeyEvent.VK_C);
	salmon_ingredient.setSelected(true);
	salmon_ingredient.addActionListener( sg);
	//add action command

	 add(shrimp_ingredient);
	JLabel amount_sh = new JLabel("Amount:");
	JTextField amount_shrimp = new JTextField(20);
	amount_salmon.addActionListener( sg);
	 add(amount_sh);
	 add(amount_shrimp);

	JCheckBox avocado_ingredient = new JCheckBox("Avocado");
	salmon_ingredient.setMnemonic(KeyEvent.VK_C);
	salmon_ingredient.setSelected(true);
	salmon_ingredient.addActionListener( sg);
	//add action command

	 add(avocado_ingredient);
	JLabel amount_a = new JLabel("Amount:");
	JTextField amount_avo = new JTextField(20);
	amount_salmon.addActionListener( sg);
	 add(amount_a);
	 add(amount_avo);

	JLabel cost = new JLabel("Cost of Sushi");
	 add(cost);
	 
	 JSlider cost_slider = new JSlider(0,10,1);
		cost_slider.setPaintTicks(true);
		cost_slider.setSnapToTicks(true);
		cost_slider.setPaintLabels(true);
		cost_slider.setMajorTickSpacing(1);
		add(cost_slider);
	}
	
	public JPanel getWidget() {
		return this;
	}
}
