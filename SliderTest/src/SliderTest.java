
//P507
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTest extends JFrame {
	private JSlider diameterSlider;
	private OvalPanel myPanel;

	public SliderTest() {
		// TODO Auto-generated constructor stub
		super("Testing Slider");
		myPanel = new OvalPanel();
		myPanel.setBackground(Color.YELLOW);
		diameterSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
		diameterSlider.setMajorTickSpacing(10);
		diameterSlider.setPaintTicks(true);
		diameterSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				myPanel.setDiameter(diameterSlider.getValue());
			}
		});
		Container container = getContentPane();
		container.add(diameterSlider, BorderLayout.SOUTH);
		container.add(myPanel, BorderLayout.CENTER);
		setSize(220, 270);
		setVisible(true);
	}

	public static void main(String[] args) {
		SliderTest sliderTest = new SliderTest();
		sliderTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
