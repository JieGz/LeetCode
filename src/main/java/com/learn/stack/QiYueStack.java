package com.learn.stack;
//时间复杂度
public class QiYueStack {
	private String[] elements;
	private int size;
	private int length;

	public QiYueStack(int length) {
		elements = new String[length];
		this.length = length;
		this.size = 0;
	}

	public boolean push(String element) {
		if (size == length) return false;
		elements[size] = element;
		size++;
		return true;
	}

	public String pop() {
		if (size == 0) return null;
		String element = elements[size - 1];
		size--;
		return element;
	}

	public static void main(String[] args) {
		QiYueStack stack = new QiYueStack(3);
		System.out.println(stack.pop());

		System.out.println(stack.push("a"));
		System.out.println(stack.pop());

		System.out.println(stack.push("b"));
		System.out.println(stack.push("c"));
		System.out.println(stack.push("d"));
		System.out.println(stack.push("e"));
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}
}
