package com.taotao.portal.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.taotao.portal.task.SyncTask;

public class InitListener implements ServletContextListener {
	private static final Logger logger = LoggerFactory.getLogger(InitListener.class);
	private ApplicationContext context = null;
	private SyncTask syncTask = null;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());

		//这里其实可以配置多个task,task也可以配置在数据库中。。
		//这里配置了一个同步缓存的task
		syncTask = (SyncTask) context.getBean("syncTask");
		syncTask.setApplication(event.getServletContext());// task依赖于他的父task
		new Timer(true).schedule(syncTask, 0, 1000*60*10);//每隔十分钟自动刷新一次缓存。
		logger.info("context Initialized.......");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("context Destroyed.........");
	}

}
