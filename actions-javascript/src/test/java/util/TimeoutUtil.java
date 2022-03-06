package util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TimeoutUtil {

	private static final Logger logger = LogManager.getLogger(TimeoutUtil.class.getSimpleName());

	public static final long SECOND = 1000;
	public static final long MINUTE = 60 * SECOND;

	public static void waitSeconds(long seconds) {
		logger.info("Waiting for " + seconds + " seconds...");
		sleep(seconds * SECOND);
	}

	public static void waitMinutes(long minutes) {
		logger.info("Waiting for " + minutes + " minutes...");
		sleep(minutes * MINUTE);
	}

	private static void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException ex) {
			logger.error("Thread Sleep failed", ex);
		}
	}
}
