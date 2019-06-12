
//P832

import java.util.Arrays;

public class UsingArrays {
	private int intValues[] = { 1, 2, 3, 4, 5, 6 };
	private double doubleValues[] = { 8.4, 9.5, 0.2, 7.9, 3.4 };
	private int filledInt[], intValuesCopy[];

	public UsingArrays() {
		// TODO Auto-generated constructor stub
		filledInt = new int[10];
		intValuesCopy = new int[intValues.length];

		Arrays.fill(filledInt, 7);
		Arrays.parallelSort(doubleValues);

		System.arraycopy(intValues, 0, intValuesCopy, 0, intValues.length);
	}

	public void printArrays() {
		System.out.print("doubleValues: ");
		for (int count = 0; count < doubleValues.length; count++)
			System.out.print(doubleValues[count] + " ");
		System.out.print("\nintValues: ");
		for (int count = 0; count < intValues.length; count++)
			System.out.print(intValues[count] + " ");
		System.out.print("\nfilledInt: ");
		for (int count = 0; count < filledInt.length; count++)
			System.out.print(filledInt[count] + " ");
		System.out.print("\nintValuesCopy: ");
		for (int count = 0; count < intValuesCopy.length; count++)
			System.out.print(intValuesCopy[count] + " ");
		System.out.println();
	}

	public int searchForInt(int value) {
		return Arrays.binarySearch(intValues, value);
	}

	public void printEquality() {
		boolean b = Arrays.equals(intValues, intValuesCopy);
		System.out.println("intValue " + (b ? "==" : "!=") + " intValueCopy");
		b = Arrays.equals(intValues, filledInt);
		System.out.println("intValue " + (b ? "==" : "!=") + " filledInt");
	}

	public static void main(String[] args) {
		UsingArrays usingArrays = new UsingArrays();
		usingArrays.printArrays();
		usingArrays.printEquality();

		int location = usingArrays.searchForInt(5);
		System.out.println(location >= 0 ? "Found 5 at element " + location : "5 not found " + "in intValues");

		location = usingArrays.searchForInt(5567);
		System.out.println(location >= 0 ? "Found 5567 at element " + location : "5567 not found " + "in intValues");

	}
}
