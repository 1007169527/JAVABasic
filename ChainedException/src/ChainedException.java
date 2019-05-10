//P566
public class ChainedException {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void method1() throws Exception {
		try {
			method2();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Exception thrown in method1", e);
		}
	}

	private static void method2() throws Exception {
		try {
			method3();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Exception thrown in method2", e);
		}
	}

	private static void method3() throws Exception {
		throw new Exception("Exception thrown in method3");
	}
}
