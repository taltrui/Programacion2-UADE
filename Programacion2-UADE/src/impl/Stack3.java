package impl;

import java.util.Arrays;

import api.Stack;

public class Stack3 implements Stack {
	int[] stack;

	@Override
	public void push(int x) {
		stack[stack[0] + 1] = x;
		++stack[0];
	}

	@Override
	public void pop() {
		--stack[0];
	}

	@Override
	public void initializeStack() {
		stack = new int[20];
		stack[0] = 0;
	}

	@Override
	public int lastElement() {
		return stack[stack[0]];
	}

	@Override
	public boolean isEmpty() {
		return stack[0] == 0;
	}

	@Override
	public void print() {
		String toPrint = " Current index: " + stack[0] + "\n Stack: " + Arrays.toString(stack);
		System.out.print(toPrint);
	}
}
