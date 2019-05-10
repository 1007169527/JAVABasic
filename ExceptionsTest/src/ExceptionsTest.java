
import java.util.concurrent.TimeUnit;

//P562
public class ExceptionsTest {
	private static void delay() {
		;
	}

	private static void delay1() {
		try {
			TimeUnit.MILLISECONDS.sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void main(String args[]) {
		try {
			throwException();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(System.currentTimeMillis() + " 4 Exception handled in main");
			delay();
		}
		doesNotThrowException();
	}

	public static void throwException() throws Exception {
		try {
			System.out.println(System.currentTimeMillis() + " 1 Method throwException");
			delay();
			throw new Exception();
		} catch (Exception e) {
			System.err.println(System.currentTimeMillis() + " 2 Exception handled in Method throwException");
			delay();
			throw new Exception();
		} finally {
			// TODO: handle finally clause
			System.err.println(System.currentTimeMillis() + " 3 Finally executed in throwException");
			delay();
		}
	}

	public static void doesNotThrowException() {
		try {
			System.out.println(System.currentTimeMillis() + " 5 Method doesNotThrowException");
			delay();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
			System.out.println(System.currentTimeMillis() + " 6 Exception handled in Method doesNotThrowException");
			delay();
		} finally {
			System.err.println(System.currentTimeMillis() + " 7 Finally executed in doesNotThrowException");
			delay();
		}
	}
}
