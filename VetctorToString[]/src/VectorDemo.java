import java.util.Arrays;
import java.util.Vector;

public class VectorDemo {
	final public static void main(String[] args) {
		Vector<String> vNames= new Vector<String>();
		vNames.add("GCP");
		vNames.add("HCH");
		vNames.add("GSL");
        Object[] aColumNames = vNames.toArray();
        String[] aNames = Arrays.copyOf(aColumNames, aColumNames.length, String[].class);
        for(int count=0;count<aNames.length;count++)
        	System.out.print(aNames[count]+"\t");
	}
}
