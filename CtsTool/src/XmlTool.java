import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class TestAtom {
	String testPackageName;
	Vector<String> vTestCaseNames = new Vector<String>();
	String testName = "";
	String command = "";
	String errMsg = "";
	String owner = "";
	String dir = "";
	String addon = "";

	String lastTestCaseName = "";
	double count = 0;

	boolean readErrMsgDone = false;
	boolean needReadErrMsg = false;

	final String testFlags[] = { "TestPackage", "TestSuite", "TestCase", "Test" };
	final String errFlag = "FailedScene";
	String tmpString = "";

	int indexKeyBeginFlag = -1;
	int indexKeyEndFlag = -1;
	int indexValBeginFlag = -1;
	int indexValEndFlag = -1;

	protected String dump() {
		if (readErrMsgDone) {
			command = "run cts -c " + dumpVector(vTestCaseNames) + " -m " + testName
					+ " --force-abi --skip-preconditions --disable-reboot";
			System.out.println(dumpVector(vTestCaseNames) + "#" + testName + "\t");// + errMsg + "\t" + owner + "\t" +
																					// addon);
			return dumpVector(vTestCaseNames) + "#" + testName + "\t" + errMsg + "\t" + owner + "\t" + command + "\t"
					+ dir + "\t" + addon + "\n";
		} else {
			// if (!vTestCaseNames.isEmpty())
			// System.out.println("dump " + dumpVector(vTestCaseNames) + "#" + testName);
		}
		return "";
	}

	public String praseFile(String string) {
		count++;
		readErrMsgDone = false;
		int a = 3;
		int b = 4;
		if (a == b) {
			try {
				System.out.println(new String(string.getBytes("ISO-8859-1"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int count = 0; count < testFlags.length; count++) {
			indexKeyBeginFlag = string.indexOf("<" + testFlags[count] + " name");
			indexKeyEndFlag = string.indexOf("</" + testFlags[count] + ">");
			if (indexKeyBeginFlag != -1) {
				indexValBeginFlag = string.indexOf("\"", indexKeyBeginFlag) + 1;
				indexValEndFlag = string.indexOf("\"", indexValBeginFlag);
				tmpString = string.substring(indexValBeginFlag, indexValEndFlag);
				if (count == 0) {
					testPackageName = tmpString;
				}
				if (count == 1 || count == 2) {
					if (vTestCaseNames.isEmpty() == true)
						vTestCaseNames.add(tmpString);
					else
						vTestCaseNames.add("." + tmpString);
				}
				if (count == testFlags.length - 1) {
					testName = tmpString;
				}
			}
			if (indexKeyEndFlag != -1) {
				if (count >= 1 && count < testFlags.length - 1) {
					if (count == 1 || count == 2) {
						vTestCaseNames.remove(vTestCaseNames.size() - 1);
					}
					if (count == 3) {
						vTestCaseNames.remove(vTestCaseNames.size() - 1);
						testName = "";
					}
				}
			}
		}
		// if (lastTestCaseName.equals(dumpVector(vTestCaseNames)) != true)
		// System.out.println(count + ": " + dumpVector(vTestCaseNames));
		// lastTestCaseName = dumpVector(vTestCaseNames);
		if (string.indexOf("<" + errFlag + " message") != -1) {
			tmpString = tmpString + string.substring(string.indexOf("<" + errFlag));
			needReadErrMsg = true;
		} else if (needReadErrMsg) {
			tmpString = tmpString + string;
		}
		if (string.indexOf("</" + errFlag + ">") != -1) {
			errMsg = tmpString;
			readErrMsgDone = true;
			needReadErrMsg = false;
			return dump();
		}
		return "";
	}

	protected String dumpVector(Vector<String> vNames) {
		String tmpString = "";
		for (int count = 0; count < vNames.size(); count++) {
			// System.out.println(vNames.elementAt(count));
			tmpString = tmpString + vNames.elementAt(count);
		}
		return tmpString;
	}
}