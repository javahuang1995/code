package com.huang.datastruct.line;

class

ArrayStack

{

	private

	long[] a;

	private

	int size;

	// ջ����Ĵ�С

	private

	int top;

	// ջ��

	public

	ArrayStack(int maxSize)

	{

		this.size = maxSize;

		this.a =

				new

				long[size];

		this.top =

				-1;

		// ��ʾ��ջ

	}

	public

			void push(long value)

	{
		// ��ջ

		if (isFull())

		{

			System.out.println("ջ������");

			return;

		}
		a[++top]

				= value;

	}

	public

			long peek()

	{
		// ����ջ�����ݣ�����ɾ��

		if (isEmpty())

		{

			System.out.println("ջ��û������");

			return

			0;

		}

		return a[top];

	}

	public

			long pop()

	{

		// ����ջ�����ݣ�ɾ��

		if (isEmpty())

		{

			System.out.println("ջ��û�����ݣ�");

			return

			0;

		}

		return a[top--];

	}

	public

			int size()

	{

		return top +

				1;

	}

	public

			boolean isEmpty()

	{

		return

		(top ==

		-1);

	}

	public

			boolean isFull()

	{

		return

		(top == size - 1);

	}

	public

			void display()

	{

		for (int i = top; i >=

		0; i--)

		{

			System.out.print(a[i]

					+

					" ");

		}

		System.out.println("");

	}
}