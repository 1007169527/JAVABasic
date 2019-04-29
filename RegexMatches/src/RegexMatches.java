import java.util.regex.Matcher;
import java.util.regex.Pattern;

//P405
public class RegexMatches {
	public static void main(String args[]) {
		String output = "";
		Pattern expression = Pattern.compile("J.*\\d[0-35-9]-\\d\\d-\\d\\d");
		String string1 = "Jane's Birthday is 05-12-75";
		string1 += "\nDave's Bitrhday is 11-04-68";
		string1 += "\nJojn's Birthady is 04-28-73";
		string1 += "\nJoe's Birthday is 12-17-77";

		Matcher matcher = expression.matcher(string1);

		while (matcher.find()) {
			output += matcher.group() + "\n";
		}

		System.out.println(output);
	}
}
