
//P511
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;

public class MenuTest extends JFrame {
	private final Color colorValues[] = { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN };
	private final String colorNames[] = { "Black", "Blue", "Red", "Green" };
	private final String fontNames[] = { "Serif", "Monospaced", "SaneSerif" };
	private final String styleNames[] = { "Bold", "Italic" };
	private JRadioButtonMenuItem colorItems[], fontItems[];
	private JCheckBoxMenuItem styleItems[];
	private JLabel displayJLabel;
	private ButtonGroup fontGroup, colorGroup;
	private int style;

	public MenuTest() {
		// TODO Auto-generated constructor stub
		super("Testing Menu");
		JMenu fileJMenu = new JMenu("File");
		fileJMenu.setMnemonic('F');

		JMenuItem aboutItem = new JMenuItem("About...");
		aboutItem.setMnemonic('A');
		fileJMenu.add(aboutItem);

		aboutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(MenuTest.this, "This is an example\nof using menus", "About",
						JOptionPane.PLAIN_MESSAGE);

			}
		});

		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('E');
		fileJMenu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(fileJMenu);

		JMenu formatMenu = new JMenu("Format");
		formatMenu.setMnemonic('r');

		JMenu colorMenu = new JMenu("Color");
		colorMenu.setMnemonic('c');

		colorItems = new JRadioButtonMenuItem[colorNames.length];
		colorGroup = new ButtonGroup();
		ItemHandler itemHandler = new ItemHandler();

		for (int count = 0; count < colorNames.length; count++) {
			colorItems[count] = new JRadioButtonMenuItem(colorNames[count]);
			colorMenu.add(colorItems[count]);
			colorGroup.add(colorItems[count]);
			colorItems[count].addActionListener(itemHandler);
		}

		colorItems[0].setSelected(true);
		formatMenu.add(colorMenu);
		formatMenu.addSeparator();

		JMenu fontMenu = new JMenu("Font");
		fontMenu.setMnemonic('n');

		fontItems = new JRadioButtonMenuItem[fontNames.length];
		fontGroup = new ButtonGroup();

		for (int count = 0; count < fontItems.length; count++) {
			fontItems[count] = new JRadioButtonMenuItem(fontNames[count]);
			fontMenu.add(fontItems[count]);
			fontGroup.add(fontItems[count]);
			fontItems[count].addActionListener(itemHandler);
		}

		styleItems = new JCheckBoxMenuItem[styleNames.length];
		StyleHandler styleHandler = new StyleHandler();

		for (int count = 0; count < styleItems.length; count++) {
			styleItems[count] = new JCheckBoxMenuItem(styleNames[count]);
			fontMenu.add(styleItems[count]);
			fontGroup.add(styleItems[count]);
			styleItems[count].addItemListener(styleHandler);
		}

		formatMenu.add(fontMenu);
		bar.add(formatMenu);

		displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
		displayJLabel.setBackground(colorValues[0]);
		displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));
		getContentPane().setBackground(Color.CYAN);
		getContentPane().add(displayJLabel, BorderLayout.CENTER);

		setSize(500, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		MenuTest menuTest = new MenuTest();
		menuTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class ItemHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int count = 0; count < colorItems.length; count++) {
				if (colorItems[count].isSelected()) {
					displayJLabel.setForeground(colorValues[count]);
					break;
				}
			}

			for (int count = 0; count < fontItems.length; count++) {
				if (fontItems[count].isSelected()) {
					displayJLabel.setFont(new Font(fontItems[count].getText(), style, 72));
				}
			}
			repaint();
		}

	}

	private class StyleHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			style = 0;
			if (styleItems[0].isSelected())
				style += Font.BOLD;
			if (styleItems[1].isSelected())
				style += Font.ITALIC;
			displayJLabel.setFont(new Font(displayJLabel.getFont().getName(), style, 72));
			repaint();
		}

	}
}
