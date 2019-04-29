//P403
public class RegexSubstitution {
	public static void main(String argsp[]) {
		String firstString = "This sentence ends in 5 stars *****";
		String secondString = "1, 2, 3, 4, 5,	6,7, 8";
		String output = "Original String 1 is: " + firstString;

		firstString = firstString.replaceAll("stars", "carets");
		output += "\n\"carets\" substitution for \"starts\": " + firstString;

		output += "\nEvery word replaced by \"word\": " + firstString.replaceAll("\\w+", "word");

		output += "\nOriginal String 2 is: " + secondString;
		for (int i = 0; i < 3; i++) {
			secondString = secondString.replaceFirst("\\d", "digit");
		}
		output += "\nFirst three digits replaced by \"digit\" " + secondString;

		output += "\nString split at commas: [";
		String results[] = secondString.split(",\\s*");
		for (int i = 0; i < results.length; i++) {
			output += "\"" + results[i] + "\", ";
		}
		output = output.substring(0, output.length() - 2) + "]";
		System.out.println(output);
	}
}
