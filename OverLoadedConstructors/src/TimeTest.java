
//P263
import javax.swing.JOptionPane;

public class TimeTest {
	public static void main(String args[]) {
		Time time1 = new Time();
		String output = "The initial universal time1 is: " + time1.toUniversalString() + "\n"
				+ "The initial standard time1 is: " + time1.toStandardString() + "\n";
		time1 = new Time(13, 27);
		output += "The universal time1 is: " + time1.toUniversalString() + "\n" + "The standard time1 is: "
				+ time1.toStandardString() + "\n";
		time1 = new Time(9, 9, 9);
		output += "The universal time1 is: " + time1.toUniversalString() + "\n" + "The standard time1 is: "
				+ time1.toStandardString() + "\n";
		Time time2 = new Time(time1);
		output += "The universal time2 is: " + time2.toUniversalString() + "\n" + "The standard time2 is: "
				+ time2.toStandardString() + "\n";
		JOptionPane.showMessageDialog(null, output, "Testing OverloadedConstructors", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
