//P562
public class ExceptionsTest {
	public static void main(String args[]) {
		try {
			throwException();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception handled in main");
		}
		doesNotThrowException();
	}

	public static void throwException() throws Exception {
		try {
			System.out.println("Method throwException");
			throw new Exception();
		} catch (Exception e) {
			System.err.println("Exception handled in Method throwException");
			throw new Exception();
		} finally {
			// TODO: handle finally clause
			System.err.println("Finally executed in throwException");
		}
	}

	public static void doesNotThrowException() {
		try {
			System.out.println("Method doesNotThrowException");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		} finally {
			System.err.println("Finally executed in doesNotThrowException");
		}
	}
}
