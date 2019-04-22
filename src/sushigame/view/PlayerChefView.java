package sushigame.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import comp401.sushi.AvocadoPortion;
import comp401.sushi.CrabPortion;
import comp401.sushi.EelPortion;
import comp401.sushi.IngredientPortion;
import comp401.sushi.Nigiri;
import comp401.sushi.Plate;
import comp401.sushi.RedPlate;
import comp401.sushi.RicePortion;
import comp401.sushi.Roll;
import comp401.sushi.SalmonPortion;
import comp401.sushi.Sashimi;
import comp401.sushi.SeaweedPortion;
import comp401.sushi.ShrimpPortion;
import comp401.sushi.Sushi;
import comp401.sushi.TunaPortion;

public class PlayerChefView extends JPanel implements ActionListener {

	private List<ChefViewListener> listeners;
	private JLabel jank;
	private JButton button;
	private ScoreboardWidget scoreboard;
	private JComboBox sushi_box;
	private JComboBox pos_box;
	private int currentSush;
	private JLabel typesushi;
	private String rolltype;
	private int sushipos;
	private JTextField rollname;
	private int belt_size;
	private JLabel sushiPanel;

	private JComboBox toppings;
	private JComboBox position;
	private JComboBox platecolor;
	private JSlider costslider;
	private int slider_value;
	private JCheckBox[] ingredients = new JCheckBox[7];
	private JTextField[] ounces = new JTextField[7];
	private ArrayList<IngredientPortion> yummy_stuff = new ArrayList<IngredientPortion>();
	private String name;

	public PlayerChefView(int belt_size) {
		this.belt_size = belt_size;
		listeners = new ArrayList<ChefViewListener>();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		// sushiPanel.setLayout(new GridLayout(belt_size,1));
		// add(sushiPanel);
		typesushi = new JLabel("Choose Sushi to Start:");
		add(typesushi);

		String[] sushi_type = {"Nigiri", "Roll", "Sashimi" , "- none -" };
		sushi_box = new JComboBox(sushi_type);
		sushi_box.setSelectedIndex(3);
		sushi_box.setActionCommand("type selected");
		sushi_box.addActionListener(this);
		add(sushi_box);
		String chosenSushi = (String) sushi_box.getSelectedItem();

		JLabel boy = new JLabel(" ");
		add(boy);

		JLabel boy1 = new JLabel(" ");
		add(boy1);

		JLabel boy2 = new JLabel(" ");
		add(boy2);

		JLabel boy3 = new JLabel(" ");
		add(boy3);

		JLabel boy4 = new JLabel(" ");
		add(boy4);
		JLabel boy5 = new JLabel(" ");
		add(boy5);
		JLabel boy6 = new JLabel(" ");
		add(boy6);

		JLabel boy11 = new JLabel(" ");
		add(boy11);

		JLabel boy7 = new JLabel(" ");
		add(boy7);
		JLabel boy8 = new JLabel(" ");
		add(boy8);
		JLabel boy9 = new JLabel(" ");
		add(boy9);
		JLabel boy10 = new JLabel(" ");
		add(boy10);

	}

	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
	}

	private void makeRedPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleRedPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGreenPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleGreenPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeBluePlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleBluePlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGoldPlateRequest(Sushi plate_sushi, int plate_position, double price) {
		for (ChefViewListener l : listeners) {
			l.handleGoldPlateRequest(plate_sushi, plate_position, price);
		}
	}

	public void refreshPanel() {
		
		removeAll();
		add(typesushi);
		add(sushi_box);

		if (currentSush == 2) {
			

			JLabel roll_name = new JLabel("Name of Roll:");
			rollname = new JTextField(20);
			rollname.addActionListener(this);
			rollname.setActionCommand("name");

			add(roll_name);
			add(rollname);
			JLabel ingred = new JLabel("Watchu want in dis roll:");
			add(ingred);

			JCheckBox salmon_ingredient = new JCheckBox("Salmon");
			salmon_ingredient.setMnemonic(KeyEvent.VK_C);
			salmon_ingredient.setSelected(false);
			ingredients[0] = salmon_ingredient;

			add(salmon_ingredient);
			add(Box.createHorizontalGlue());
			JLabel amount_s = new JLabel("Salmon Amount (oz):");
			JTextField amount_salmon = new JTextField(20);
			ounces[0] = amount_salmon;
			add(amount_s);
			add(amount_salmon);

			JCheckBox seaweed_ingredient = new JCheckBox("Seaweed");
			seaweed_ingredient.setMnemonic(KeyEvent.VK_C);
			seaweed_ingredient.setSelected(false);
			// add action command
			add(seaweed_ingredient);

			JLabel amount_se = new JLabel("C-weed Amount (oz):");
			JTextField amount_seaweed = new JTextField(20);
			add(amount_se);
			add(amount_seaweed);

			JCheckBox crab_ingredient = new JCheckBox("Crab");
			crab_ingredient.setMnemonic(KeyEvent.VK_C);
			crab_ingredient.setSelected(false);
			ingredients[1] = crab_ingredient;
			add(crab_ingredient);

			JLabel amount_c = new JLabel("Crab Amount (oz):");
			JTextField amount_crab = new JTextField(20);
			ounces[1] = amount_crab;
			add(amount_c);
			add(amount_crab);

			JCheckBox rice_ingredient = new JCheckBox("Rice");
			rice_ingredient.setMnemonic(KeyEvent.VK_C);
			rice_ingredient.setSelected(false);
			ingredients[2] = rice_ingredient;
			add(rice_ingredient);

			JLabel amount_r = new JLabel("Rice Amount (oz):");
			JTextField amount_rice = new JTextField(20);
			ounces[2] = amount_rice;
			add(amount_r);
			add(amount_rice);

			JCheckBox eel_ingredient = new JCheckBox("Eel");
			eel_ingredient.setMnemonic(KeyEvent.VK_C);
			eel_ingredient.setSelected(false);
			ingredients[3] = eel_ingredient;

			add(eel_ingredient);
			JLabel amount_e = new JLabel("Eel Amount (oz):");
			JTextField amount_eel = new JTextField(20);
			ounces[3] = amount_eel;
			add(amount_e);
			add(amount_eel);

			JCheckBox tuna_ingredient = new JCheckBox("Tuna");
			tuna_ingredient.setMnemonic(KeyEvent.VK_C);
			tuna_ingredient.setSelected(false);
			ingredients[4] = tuna_ingredient;

			add(tuna_ingredient);
			JLabel amount_t = new JLabel("Tuna Amount (oz):");
			JTextField amount_tuna = new JTextField(20);
			ounces[4] = amount_tuna;
			add(amount_t);
			add(amount_tuna);

			JCheckBox shrimp_ingredient = new JCheckBox("Shrimp");
			shrimp_ingredient.setMnemonic(KeyEvent.VK_C);
			shrimp_ingredient.setSelected(false);
			ingredients[5] = shrimp_ingredient;

			add(shrimp_ingredient);
			JLabel amount_sh = new JLabel("Shrimp Amount (oz):");
			JTextField amount_shrimp = new JTextField(20);
			ounces[5] = amount_shrimp;
			add(amount_sh);
			add(amount_shrimp);

			JCheckBox avocado_ingredient = new JCheckBox("Avocado");
			avocado_ingredient.setMnemonic(KeyEvent.VK_C);
			avocado_ingredient.setSelected(false);
			ingredients[6] = avocado_ingredient;

			add(avocado_ingredient);
			JLabel amount_a = new JLabel(" Avocado Amount (oz):");
			JTextField avocado_amount = new JTextField(20);
			ounces[6] = avocado_amount;
			add(amount_a);
			add(avocado_amount);

			JLabel positiono = new JLabel("Position");
			add(positiono);
			String[] plate_pos_roll = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
					"15", "16", "17", "18", "19" };
			position = new JComboBox(plate_pos_roll);
			add(position);

			JLabel sashimi_color = new JLabel("What Color Plate?:");
			add(sashimi_color);
			platecolor = new JComboBox(Plate.Color.values());
			add(platecolor);

			JLabel cost = new JLabel("Gold Cost(only for gold)");
			add(cost);
			costslider = new JSlider(5, 10);
			costslider.setPaintTicks(true);
			costslider.setSnapToTicks(true);
			costslider.setPaintLabels(true);
			costslider.setMajorTickSpacing(1);
			add(costslider);
			
			costslider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent event) {
					slider_value = costslider.getValue();
				}
			});

			JButton add_sushi1 = new JButton("add roll");
			add_sushi1.addActionListener(this);
			add(add_sushi1);

		} else if (currentSush == 3) {


			JLabel plate_colors = new JLabel("Plate Color");
			add(plate_colors);

			platecolor = new JComboBox(Plate.Color.values());
			add(platecolor);

			JLabel sashimi_type1 = new JLabel("What Sashimi you Make?:");
			add(sashimi_type1);

			toppings = new JComboBox(comp401.sushi.Sashimi.SashimiType.values());
			add(toppings);

			JLabel position1 = new JLabel("What Position for Sashimi:");
			add(position1);

			String[] plate_pos_sashimi = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
					"14", "15", "16", "17", "18", "19" };
			position = new JComboBox(plate_pos_sashimi);
			add(position);

			JLabel money = new JLabel("Gold Cost(only for gold)");
			add(money);
			JSlider costslider = new JSlider(5, 10);
			costslider.setPaintTicks(true);
			costslider.setSnapToTicks(true);
			costslider.setPaintLabels(true);
			costslider.setMajorTickSpacing(1);
			add(costslider);

			costslider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent event) {
					slider_value = costslider.getValue();
				}
			});

			JButton add_sashimi = new JButton("add");
			add_sashimi.setActionCommand("add sashimi");
			add(add_sashimi);
			add_sashimi.addActionListener(this);

		} else if (currentSush == 1) {


			add(sushi_box);

			JLabel nigiri_type = new JLabel("What Nigiri you Make?:");
			add(nigiri_type);

			toppings = new JComboBox(comp401.sushi.Nigiri.NigiriType.values());
			sushi_box.setSelectedIndex(0);
			add(toppings);

			JLabel sashimi_color = new JLabel("What Color Plate?:");
			add(sashimi_color);
			platecolor = new JComboBox(Plate.Color.values());
			add(platecolor);

			JLabel positions = new JLabel("What Position you Make?:");
			add(positions);

			String[] plate_pos = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
					"16", "17", "18", "19" };
			position = new JComboBox(plate_pos);
			add(position);

			JLabel money = new JLabel("Gold Cost(only for gold)");
			add(money);
			JSlider costslider = new JSlider(5, 10, 5);
			slider_value = costslider.getValue(); //spook
			costslider.setPaintTicks(true);
			costslider.setSnapToTicks(true);
			costslider.setPaintLabels(true);
			costslider.setMajorTickSpacing(1);
			
			add(costslider);

			costslider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent event) {
					slider_value = costslider.getValue();
				}
			});

			JButton add_sushi = new JButton("add");
			add_sushi.setActionCommand("add nigiri");
			add(add_sushi);

			add_sushi.addActionListener(this);


		} else if (currentSush == 4) {
			JLabel boy = new JLabel(" ");
			add(boy);

			JLabel boy1 = new JLabel(" ");
			add(boy1);

			JLabel boy2 = new JLabel(" ");
			add(boy2);

			JLabel boy3 = new JLabel(" ");
			add(boy3);

			JLabel boy4 = new JLabel(" ");
			add(boy4);
			JLabel boy5 = new JLabel(" ");
			add(boy5);
			JLabel boy6 = new JLabel(" ");
			add(boy6);

			JLabel boy11 = new JLabel(" ");
			add(boy11);

			JLabel boy7 = new JLabel(" ");
			add(boy7);
			JLabel boy8 = new JLabel(" ");
			add(boy8);
			JLabel boy9 = new JLabel(" ");
			add(boy9);
			JLabel boy10 = new JLabel(" ");
			add(boy10);
		}
		
		validate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if (e.getActionCommand().equals("type selected")) {
			//System.out.println(sushi_box.getSelectedItem());
			
			if (sushi_box.getSelectedItem().equals("Nigiri")) {
				rolltype = "Nigiri";
				currentSush = 1;
				//System.out.println(currentSush);
			} else if (sushi_box.getSelectedItem().equals("Roll")) {
				currentSush = 2;
				rolltype = "Roll";
			} else if (sushi_box.getSelectedItem().equals("Sashimi")) {
				currentSush = 3;
				rolltype = "Sashimi";
			} else if (sushi_box.getSelectedItem().equals("- none -")) {
				currentSush = 4;
			}
			refreshPanel();

		} else if (e.getActionCommand().equals("add roll")) {
			name = rollname.getText();
			if (!name.toLowerCase().contains(" roll")) {
				name = rollname.getText() + " " +"Roll";
			}
			for (int i = 0; i < ingredients.length; i++) {
				if (ingredients[i].isSelected() && !ounces[i].getText().equals("")) {
					String text = ounces[i].getText();
					//System.out.println(text);
					double amounts = Double.parseDouble(text);
					//System.out.println(amounts);
					if (amounts > 1.5) {
						JOptionPane.showMessageDialog(null, "Amount added is >1.5", "Amount Error", JOptionPane.INFORMATION_MESSAGE);
						throw new RuntimeException("ur stupid");
					} else {
						if (i == 0) {
							yummy_stuff.add(new SalmonPortion(amounts));
						} else if (i == 1) {
							yummy_stuff.add(new SeaweedPortion(amounts));
						} else if (i == 2) {
							yummy_stuff.add(new CrabPortion(amounts));
						} else if (i == 3) {
							yummy_stuff.add( new RicePortion(amounts));
						} else if (i == 4) {
							yummy_stuff.add(new EelPortion(amounts));
						} else if (i == 5) {
							yummy_stuff.add(new TunaPortion(amounts));
						} else if (i == 6) {
							yummy_stuff.add(new ShrimpPortion(amounts));
						} else if (i == 7) {
							yummy_stuff.add(new AvocadoPortion(amounts));
						}
					}
				}
			}
			
				Plate.Color local_plate = (Plate.Color) platecolor.getSelectedItem();
				int local_position = Integer.parseInt((String) position.getSelectedItem());
				if (yummy_stuff.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ur roll has noting", "Roll Problems", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (local_plate.equals(Plate.Color.RED)) {
					Roll roll = new Roll(name, yummy_stuff.toArray(new IngredientPortion[yummy_stuff.size()]));
					makeRedPlateRequest(roll, local_position);
					yummy_stuff.clear();
				} else if (local_plate.equals(Plate.Color.GREEN)) {
					Roll roll = new Roll(name, yummy_stuff.toArray(new IngredientPortion[yummy_stuff.size()]));
					makeGreenPlateRequest(roll, local_position);
					yummy_stuff.clear();
				} else if (local_plate.equals(Plate.Color.BLUE)) {
					Roll roll = new Roll(name, yummy_stuff.toArray(new IngredientPortion[yummy_stuff.size()]));
					makeBluePlateRequest(roll, local_position);
					yummy_stuff.clear();
				} else if (local_plate.equals(Plate.Color.GOLD)) {
					Roll roll = new Roll(name, yummy_stuff.toArray(new IngredientPortion[yummy_stuff.size()]));
					makeGoldPlateRequest(roll, local_position, slider_value);
					yummy_stuff.clear();
				}

		} else if (e.getActionCommand().equals("add nigiri")) {

			Plate.Color local_plate = (Plate.Color) platecolor.getSelectedItem();
			int local_position = Integer.parseInt((String) position.getSelectedItem());
			Nigiri.NigiriType local_nigiri = (Nigiri.NigiriType) toppings.getSelectedItem();

			if (local_plate.equals(Plate.Color.RED)) {
				Nigiri nigiri = new Nigiri(local_nigiri);
				makeRedPlateRequest(nigiri, local_position);
			} else if (local_plate.equals(Plate.Color.GREEN)) {
				Nigiri nigiri = new Nigiri(local_nigiri);
				makeGreenPlateRequest(nigiri, local_position);
			} else if (local_plate.equals(Plate.Color.BLUE)) {
				Nigiri nigiri = new Nigiri(local_nigiri);
				makeBluePlateRequest(nigiri, local_position);
			} else if (local_plate.equals(Plate.Color.GOLD)) {
				Nigiri nigiri = new Nigiri(local_nigiri);
				makeGoldPlateRequest(nigiri, local_position, slider_value);
			}
		} else if (e.getActionCommand().equals("add sashimi")) {
			Plate.Color local_plates = (Plate.Color) platecolor.getSelectedItem();
			int local_positions = Integer.parseInt((String) position.getSelectedItem());
			Sashimi.SashimiType local_sashimi = (Sashimi.SashimiType) toppings.getSelectedItem();

			if (local_plates.equals(Plate.Color.RED)) {
				Sashimi sashimi = new Sashimi(local_sashimi);
				makeRedPlateRequest(sashimi, local_positions);
			} else if (local_plates.equals(Plate.Color.GREEN)) {
				Sashimi sashimi = new Sashimi(local_sashimi);
				makeGreenPlateRequest(sashimi, local_positions);
			} else if (local_plates.equals(Plate.Color.BLUE)) {
				Sashimi sashimi = new Sashimi(local_sashimi);
				makeBluePlateRequest(sashimi, local_positions);
			} else if (local_plates.equals(Plate.Color.GOLD)) {
				Sashimi sashimi = new Sashimi(local_sashimi);
				makeGoldPlateRequest(sashimi, local_positions, slider_value);
			}

		}
		
		} catch(RuntimeException ex) {
			JOptionPane.showMessageDialog(null, "Ur amount is too smol", "Amount Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
