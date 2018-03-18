package com.baobaotao.introduce;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
/**
 * ������ǿ�࣬֯�뵽ForumService.java��
 * @author Administrator
 *���Կ����������ǿ���Ŀ���������һ������MonitorStatusMap
 *ͬʱ��Ŀ�����ÿ����������ǰ��������һ���߼�
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