package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {
	public static final Logger logger = LogManager.getLogger(LogUtil.class);

	public static void info(String message) {
		logger.info(message);
	}


	public static void error(String message) {
		logger.error(message);
	}

}
