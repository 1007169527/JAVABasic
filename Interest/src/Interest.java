import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class Interest {
	public static void main(String args[]) {
		double amount;
		double principal = 1000.0;
		double rate = 0.05;
		
		NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
		
		JTextArea outputTextArea = new JTextArea();
		
		outputTextArea.setText("Year\tAmount on deposit\n");
		
		for(int year = 1;year <= 10; year++) {
			amount = principal * Math.pow(1.0+rate, year);
			outputTextArea.append(year+"\t"+money.format(amount)+"\n");
		}
			
		JOptionPane.showMessageDialog(null, outputTextArea,"Compound Interest",JOptionPane.INFORMATION_MESSAGE);
	}
}
