//P677
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.BorderLayout;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class ReadServerFile extends JFrame {
	private JTextField enterField;
	private JEditorPane contentsArea;
	
	public ReadServerFile() {
		super("Simple Web Browser");
		Container container = getContentPane();
		enterField = new JTextField("Enter URL here");
		enterField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				getThePage(arg0.getActionCommand());
			}
		});
		
		container.add(enterField,BorderLayout.NORTH);
		contentsArea = new JEditorPane();
		contentsArea.setVisible(false);
		contentsArea.addHyperlinkListener(new HyperlinkListener() {
			@Override
			public void hyperlinkUpdate(HyperlinkEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
					getThePage(arg0.getURL().toString());
			}	
		});
		
		container.add(new JScrollPane(contentsArea),BorderLayout.CENTER);
		setSize(400,300);
		setVisible(true);
	}
	
	protected void getThePage(String location) {
		// TODO Auto-generated method stub
		try {
			contentsArea.setPage(location);
			enterField.setText(location);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Bad URL");
		}
	}
	
	public static void main(String args[]) {
		ReadServerFile readServerFile = new ReadServerFile();
		readServerFile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
