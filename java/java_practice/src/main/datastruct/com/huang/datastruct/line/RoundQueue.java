package com.huang.datastruct.line;

public

class

RoundQueue

{

	private

	long[] a;

	private

	int size;

	// �����С

	private

	int nItems;

	// ʵ�ʴ洢����

	private

	int front;

	// ͷ

	private

	int rear;

	// β

	public

	RoundQueue(int maxSize)

	{

		this.size = maxSize;
		a =

				new

				long[size];
		front =

				0;
		rear =

				-1;
		nItems =

				0;

	}

	public

			void insert(long value)

	{

		if (isFull()) {

			System.out.println("��������");

			return;

		}
		rear =

				++rear % size;
		a[rear]

				= value;

		// βָ�����˾�ѭ����0��,����൱������ע������
		nItems++;
		/*
		 * if(rear == size-1){ rear = -1; } a[++rear] = value;
		 */

	}

	public

			long remove()

	{

		if (isEmpty())

		{

			System.out.println("����Ϊ�գ�");

			return

			0;

		}
		nItems--;
		front = front % size;

		return a[front++];

	}

	public

			void display()

	{

		if (isEmpty())

		{

			System.out.println("����Ϊ�գ�");

			return;

		}

		int item = front;

		for (int i =

				0; i < nItems; i++)

		{

			System.out.print(a[item++

					% size]

					+

					" ");

		}

		System.out.println("");

	}

	public

			long peek()

	{

		if (isEmpty())

		{

			System.out.println("����Ϊ�գ�");

			return

			0;

		}

		return a[front];

	}

	public

			boolean isFull()

	{

		return

		(nItems == size);

	}

	public

			boolean isEmpty()

	{

		return

		(nItems ==

		0);

	}

	public

			int size()

	{

		return nItems;

	}
}