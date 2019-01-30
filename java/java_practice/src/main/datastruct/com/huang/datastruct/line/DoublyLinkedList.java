package com.huang.datastruct.line;

public

class

DoublyLinkedList

{

	private

	Node first;

	// ͷ�ڵ�

	private

	Node last;

	// β�ڵ�

	private

	int size;

	public

	DoublyLinkedList()

	{
		first =

				null;
		last =

				null;
		size =

				0;

	}

	public

			int size()

	{

		return size;

	}

	public

			boolean isEmpty()

	{

		return

		(first ==

		null);

	}

	public

			void insertFirst(long value)

	{

		// ����ͷ�ڵ�

		Node newLink =

				new

				Node(value);

		if (isEmpty())

		{
			last = newLink;

		}

		else {
			first.previous = newLink;

			// newLink <-- oldFirst.previous
			newLink.next = first;

			// newLink.next --> first

		}

		first = newLink;

		// first --> newLink
		size++;

	}

	public

			void insertLast(long value)

	{
		// ����β�ڵ�

		Node newLink =

				new

				Node(value);

		if (isEmpty()) {
			first = newLink;

		}

		else

		{
			last.next = newLink;

			// newLink <-- oldLast.next
			newLink.previous = last;

			// newLink.previous --> last

		}
		last = newLink;
		size++;

	}

	public

			Node deleteFirst()

	{
		// ɾ��ͷ���

		if (first ==

		null)

		{

			System.out.println("����Ϊ�գ�");

			return

			null;

		}

		Node temp = first;

		if (first.next ==

		null)

		{

			// ֻ��һ���ڵ�
			last =

					null;

		}

		else

		{
			first.next.previous =

					null;

		}
		first = first.next;
		size--;

		return temp;

	}

	public

			Node deleteLast()

	{
		// ɾ��β�ڵ�

		if (last ==

		null)

		{

			System.out.println("����Ϊ��");

			return

			null;

		}

		Node temp = last;

		if (last.previous ==

		null)

		{

			// ֻ��һ���ڵ�
			first =

					null;

		}

		else

		{
			last.previous.next =

					null;

		}
		last = last.previous;
		size--;

		return temp;

	}

	public

			boolean insertAfter(long key,

					long value)

	{

		// ��key�������ֵΪvalue���½ڵ�

		Node current = first;

		while (current.data != key)

		{
			current = current.next;

			if (current ==

			null)

			{

				System.out.println("������ֵΪ"

						+ value +

						"�Ľڵ㣡");

				return

				false;

			}

		}

		if (current == last)

		{
			insertLast(value);

		}

		else

		{

			Node newLink =

					new

					Node(value);
			newLink.next = current.next;
			current.next.previous = newLink;
			newLink.previous = current;
			current.next = newLink;
			size++;

		}

		return

		true;

	}

	public

			Node deleteNode(long key)

	{
		// ɾ��ָ��λ�õĽڵ�

		Node current = first;

		while (current.data != key)

		{
			current = current.next;

			if (current ==

			null)

			{

				System.out.println("�����ڸýڵ㣡");

				return

				null;

			}

		}

		if (current == first)

		{
			deleteFirst();

		}

		else

		if (current == last) {
			deleteLast();

		}

		else

		{
			current.previous.next = current.next;
			current.next.previous = current.previous;
			size--;

		}

		return current;

	}

	public

			void displayForward()

	{

		// ��ͷ��β��������

		System.out.println("List(first --> last): ");

		Node current = first;

		while (current !=

		null)

		{
			current.displayLink();
			current = current.next;

		}

		System.out.println(" ");

	}

	public

			void displayBackward()

	{

		// ��β��ͷ��������

		System.out.println("List(last --> first): ");

		Node current = last;

		while (current !=

		null)

		{
			current.displayLink();
			current = current.previous;

		}

		System.out.println(" ");

	}
}

class

Node

{

	public

	long data;

	public

	Node next;

	public

	Node previous;

	public

	Node(long value)

	{
		data = value;
		next =

				null;
		previous =

				null;

	}

	public

			void displayLink()

	{

		System.out.print(data +

				" ");

	}
}