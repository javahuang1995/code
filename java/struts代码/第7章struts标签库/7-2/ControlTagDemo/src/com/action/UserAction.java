package com.action ;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	//三个list属性
	private List myList1;
	private List myList2;
	private List myList3;
	//属性的getter方法
	public List getMyList1() {
		return myList1;
	}
	public List getMyList2() {
		return myList2;
	}
	public List getMyList3() {
		return myList3;
	}
	//调用方法
	public String execute() throws Exception {
		//新建list集合mylist1
		myList1 = new ArrayList();
		//添加元素到集合mylist1
		myList1.add("1");
		myList1.add("2");
		myList1.add("3");
		//新建list集合mylist2
		myList2 = new ArrayList();
		//添加元素到集合mylist2
		myList2.add("a");
		myList2.add("b");
		myList2.add("c");
		//新建list集合mylist3
		myList3 = new ArrayList();
		//添加元素到集合mylist3中
		myList3.add("A");
		myList3.add("B");
		myList3.add("C");
		//返回success
		return SUCCESS;
	}
}
