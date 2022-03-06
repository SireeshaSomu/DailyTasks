package util;

public class TimeoutUtil {

	public static final long SECOND = 1000;
	public static final long MINUTE = 60 * SECOND;

	public static void waitSeconds(long seconds) {
		System.out.println("Waiting for " + seconds + " seconds...");
		sleep(seconds * SECOND);
	}

	public static void waitMinutes(long minutes) {
		System.out.println("Waiting for " + minutes + " minutes...");
		sleep(minutes * MINUTE);
	}

	private static void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException ex) {
			System.out.println("Thread Sleep failed: " + ex.getMessage());
		}
	}
}
