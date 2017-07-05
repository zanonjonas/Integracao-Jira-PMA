package br.com.paxtecnologia.paxteam.log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;

public class LoggerPma {
	private static final String LoggerPma = "LoggerPax";

	private String system;
	private String subsystem;

	private static final Logger logger = LogManager.getLogger(LoggerPma);
	private static final String logErrorPath= "/var/log/wildfly/appPma.log";

	// Constructor

	public LoggerPma(String system, String subsystem) {
		this.subsystem = subsystem;
		this.system = system;
	}

	public void setLevelInfo() {
		setLevel(Level.INFO);
	}

	public void setLevelDebug() {
		setLevel(Level.DEBUG);
	}

	public void setLevelTrace() {
		setLevel(Level.TRACE);
	}

	public static void setLevel(Level level) {
		LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
		Configuration conf = ctx.getConfiguration();
		conf.getLoggerConfig(LogManager.ROOT_LOGGER_NAME).setLevel(level);
		ctx.updateLoggers(conf);
	}

	// Methods

	public void info(String methodName, String texto) {
		String format = formatLog(system, subsystem, methodName);
		logger.info(format + " - " + texto);

	}

	public void debug(String methodName, String texto) {
		String format = formatLog(system, subsystem, methodName);
		logger.debug(format + " - " + texto);

	}

	public void error(String methodName, String texto) {
		String format = formatLog(system, subsystem, methodName);
		logger.error(format + " - " + texto);

	}

	public void error(String methodName, String texto, Exception e) {
		String format = formatLog(system, subsystem, methodName);
		logger.error(format + " - " + texto);
		e.printStackTrace();

	}

	public void trace(String methodName, String texto) {
		String format = formatLog(system, subsystem, methodName);
		logger.trace(format + " - " + texto);

	}

	private String formatLog(String system, String subsystem, String methodName) {
		return "Sistema: [" + system + "] - Modulo: [" + subsystem + "] - Metodo: [" + methodName + "]";
	}

	public String processCausedBy(Throwable throwable) {
		if (throwable != null) {
			if (throwable.getCause() != null) {
				return processCausedBy(throwable.getCause());
			} else {
				return throwable.getMessage();
			}
		} else {
			return null;
		}
	}

	// Get And Set
	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getSubsystem() {
		return subsystem;
	}

	public void setSubsystem(String subsystem) {
		this.subsystem = subsystem;
	}

	public static String getLoggerPmaName() {
		return LoggerPma;
	}

	public static Logger getLogger() {
		return logger;
	}

	public void createErrorFile() {
		final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
		Configuration config = ctx.getConfiguration();
		LoggerConfig x = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
		Layout<?> layout = PatternLayout.createLayout(PatternLayout.SIMPLE_CONVERSION_PATTERN, null, config, null, null,
				false, false, null, null);
		@SuppressWarnings("deprecation")
		Appender appender = FileAppender.createAppender(logErrorPath, "true", "false", "File", "true", "false",
				"false", "4000", layout, null, "false", null, config);
		appender.start();
		// config.addAppender(appender);
		// AppenderRef ref = AppenderRef.createAppenderRef("File", null, null);
		// AppenderRef[] refs = new AppenderRef[] { ref };
		// LoggerConfig loggerConfig = LoggerConfig.createLogger(false, HISTORY,
		// "HistoryLog", "true", refs, null, config,
		// null);
		x.addAppender(appender, Level.ERROR, null);
		ctx.updateLoggers(config);

	}

}
