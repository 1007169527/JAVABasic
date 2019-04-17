
//P253
import javax.swing.JOptionPane;

public class TimeTest {
	public static void main(String args[]) {
		Time time = new Time();
		String output = "The initial universal time is: " + time.toUniversalString() + "\n"
				+ "The initial standard time is: " + time.toStandardString() + "\n";
		time.setTime(13, 27, 6);
		output += "The universal time after call setTime is: " + time.toUniversalString() + "\n"
				+ "The standard time after call setTime is: " + time.toStandardString() + "\n";
		time.setTime(99, 99, 99);
		output += "The universal time after call setTime with an invalid value is: " + time.toUniversalString() + "\n"
				+ "The standard time after call setTime with an invalid value is: " + time.toStandardString() + "\n";
		JOptionPane.showMessageDialog(null, output, "Testing Class First Class", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
