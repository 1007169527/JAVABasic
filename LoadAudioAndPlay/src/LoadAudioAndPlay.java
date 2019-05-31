
//P751
import java.applet.AudioClip;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class LoadAudioAndPlay extends JApplet {
	private AudioClip sound1, sound2, currentSound;
	private JButton playButton, loopButton, stopButton;
	private JComboBox chooseSound;

	public void init() {
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		String choices[] = { "wav", "mp3" };
		chooseSound = new JComboBox(choices);
		chooseSound.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				currentSound.stop();
				System.out.println("The sample music should stop now");
				currentSound = chooseSound.getSelectedIndex() == 0 ? sound1 : sound2;
			}
		});

		container.add(chooseSound);
		ButtonHandler handler = new ButtonHandler();

		playButton = new JButton("Play");
		playButton.addActionListener(handler);
		container.add(playButton);

		loopButton = new JButton("Loop");
		loopButton.addActionListener(handler);
		container.add(loopButton);

		stopButton = new JButton("Stop");
		stopButton.addActionListener(handler);
		container.add(stopButton);

		sound1 = getAudioClip(getCodeBase(), "sample.wav");
		sound2 = getAudioClip(getCodeBase(), "sample.mp3");
		if (sound1 == null || sound2 == null)
			System.out.println("init sample failed");
		currentSound = sound1;
	}

	public void stop() {
		currentSound.stop();
	}

	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getSource() == playButton) {
				currentSound.play();
				System.out.println("The sample music should be played now");
			}

			else if (arg0.getSource() == loopButton)
				currentSound.loop();
			else if (arg0.getSource() == stopButton)
				currentSound.stop();
		}
	}
}
