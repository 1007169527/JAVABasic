
//P673
//It still can not run properly after I tried several times ...
import java.applet.AppletContext;
import java.awt.BorderLayout;
import java.awt.Container;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SiteSelector extends JApplet {
	private HashMap sites;
	private Vector siteNames;
	private JList siteChooser;

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		sites = new HashMap();
		siteNames = new Vector();
		getSitesFromHTMLParameters();

		Container container = getContentPane();
		container.add(new JLabel("Choose a site to browser"), BorderLayout.NORTH);

		siteChooser = new JList(siteNames);
		siteChooser.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				Object object = siteChooser.getSelectedValue();
				URL newDocument = (URL) sites.get(object);
				System.out.println("URL is " + newDocument);
				AppletContext browser = getAppletContext();
				browser.showDocument(newDocument); // nothing happened here
			}
		});

		container.add(new JScrollPane(siteChooser), BorderLayout.CENTER);
	}

	private void getSitesFromHTMLParameters() {
		// TODO Auto-generated method stub
		String title, location;
		URL url;
		int counter = 0;

		title = getParameter("title" + counter);

		while (title != null) {
			location = getParameter("location" + counter); // we should add param in Run Config
			try {
				url = new URL(location + "/index.html");
				sites.put(title, url);
				siteNames.add(title);
			} catch (MalformedURLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			++counter;
			title = getParameter("title" + counter);
		}
	}
}
