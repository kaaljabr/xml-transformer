package com.khashan.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TaskExecutor implements Runnable {

	private long sleepTime = 10000l;

	private static final Logger log = LoggerFactory.getLogger(TaskExecutor.class);

	@Override
	public void run() {
		try {
			doTask();
		} catch (Throwable t) {
			log.error(t.getMessage(), t);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				log.error("", e);
			}
		}
	}

	public abstract void doTask();

}
