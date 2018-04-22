package com.baobaotao.introduce;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
/**
 * 引介增强类，织入到ForumService.java中
 * @author Administrator
 *可以看到，这个增强类给目标类添加了一个属性MonitorStatusMap
 *同时给目标类的每个方法调用前都增加了一段逻辑
 *PerformanceMonitor.begin();
 *PerformanceMonitor.end();
 */
public class ControllablePerformaceMonitor
		extends
			DelegatingIntroductionInterceptor implements Monitorable, Testable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6824154065335015263L;
	private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();
	public void setMonitorActive(boolean active) {
		MonitorStatusMap.set(active);
	}
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object obj = null;
		if (MonitorStatusMap.get() != null && MonitorStatusMap.get()) {
			PerformanceMonitor.begin(mi.getClass().getName() + "."
					+ mi.getMethod().getName());
			obj = super.invoke(mi);
			PerformanceMonitor.end();
		} else {
			obj = super.invoke(mi);
		}
		return obj;
	}
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("dd");
	}
}