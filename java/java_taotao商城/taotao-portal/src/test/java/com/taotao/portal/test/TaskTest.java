package com.taotao.portal.test;

import java.util.Timer;
import org.junit.Test;

import com.taotao.portal.task.SyncTask;

public class TaskTest {

	public static void main(String[] args) {
		long delay = 0; 
		long period = 5000;
		new Timer(true).schedule(new SyncTask(), delay, period);//单位毫秒
	}

}
