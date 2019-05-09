//P565
public class StackInException {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage() + "\n");
			e.printStackTrace();
			StackTraceElement[] traceElements = e.getStackTrace();
			System.out.println("\nStackTrace from getStackTrace:\n");
			System.out.println("Class\t\tFile\t\tLine\t\tMethod");
			for (int i = 0; i < traceElements.length; i++) {
				StackTraceElement currentElement = traceElements[i];
				System.out.print(currentElement.getClassName() + "\t");
				System.out.print(currentElement.getFileName() + "\t");
				System.out.print(currentElement.getLineNumber() + "\t");
				System.out.print(currentElement.getMethodName() + "\t\n");
			}
		}
	}

	public static void method1() throws Exception {
		method2();
	}

	public static void method2() throws Exception {
		method3();
	}

	public static void method3() throws Exception {
		throw new Exception("Exception thrown in method3");
	}
}
