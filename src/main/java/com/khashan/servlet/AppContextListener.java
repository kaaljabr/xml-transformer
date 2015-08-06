package com.khashan.servlet;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.khashan.task.TransformTask;
import com.khashan.util.PropertiesManager;

@WebListener
public class AppContextListener implements ServletContextListener {

	private static final String TRANSFORMATION_TASK_UPDATE_INTERVAL_MINUTES = "transformation.task.update.interval.minutes";
	private static final String TRANSFORMATION_TASK_UPDATE_START_AFTER_MINUTES = "transformation.task.update.start.after.minutes";
	private static final String XML_URL_ENDPOINT = "xml.url.endpoint";

	private static final Logger logger = LoggerFactory.getLogger(AppContextListener.class);

	private static final ScheduledExecutorService eventsTaskExecutorService = Executors
			.newSingleThreadScheduledExecutor();

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.warn("APP JUST STARTED NOW...");
		logger.warn("URL to read XML from is: {}", PropertiesManager.getInstance().getProperty(XML_URL_ENDPOINT));
		logger.warn("Scheduled Task will start in: {} minutes",
				PropertiesManager.getInstance().getPropertyInt(TRANSFORMATION_TASK_UPDATE_START_AFTER_MINUTES));
		logger.warn("Task is scheduled to run every: {} minutes",
				PropertiesManager.getInstance().getPropertyInt(TRANSFORMATION_TASK_UPDATE_INTERVAL_MINUTES));
		final TransformTask transformTask = new TransformTask();
		/*
		 * eventsTaskExecutorService.scheduleWithFixedDelay(transformTask,
		 * PropertiesManager.getInstance().getPropertyInt(
		 * TRANSFORMATION_TASK_UPDATE_START_AFTER_MINUTES),
		 * PropertiesManager.getInstance().getPropertyInt(
		 * TRANSFORMATION_TASK_UPDATE_INTERVAL_MINUTES), TimeUnit.MINUTES);
		 */
		eventsTaskExecutorService.scheduleWithFixedDelay(transformTask, 10, 60, TimeUnit.SECONDS);

	}

}
