package com.action ;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	//����list����
	private List myList1;
	private List myList2;
	private List myList3;
	//���Ե�getter����
	public List getMyList1() {
		return myList1;
	}
	public List getMyList2() {
		return myList2;
	}
	public List getMyList3() {
		return myList3;
	}
	//���÷���
	public String execute() throws Exception {
		//�½�list����mylist1
		myList1 = new ArrayList();
		//���Ԫ�ص�����mylist1
		myList1.add("1");
		myList1.add("2");
		myList1.add("3");
		//�½�list����mylist2
		myList2 = new ArrayList();
		//���Ԫ�ص�����mylist2
		myList2.add("a");
		myList2.add("b");
		myList2.add("c");
		//�½�list����mylist3
		myList3 = new ArrayList();
		//���Ԫ�ص�����mylist3��
		myList3.add("A");
		myList3.add("B");
		myList3.add("C");
		//����success
		return SUCCESS;
	}
}
