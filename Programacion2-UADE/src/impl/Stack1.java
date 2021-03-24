package impl;

import java.util.Arrays;

import api.StackADT;

public class Stack1 implements StackADT {
	int[] stack;
	int index;

	@Override
	public void push(int x) {
		stack[index] = x;
		index++;
	}

	@Override
	public void pop() {
		index--;
	}

	@Override
	public void initializeStack() {
		stack = new int[20];
		index = 0;

	}

	@Override
	public int lastElement() {
		return stack[index - 1];
	}

	@Override
	public boolean isEmpty() {
		return index == 0;
	}

	@Override
	public void print() {
		String toPrint = " Current index: " + index + "\n Stack: " + Arrays.toString(stack);
		System.out.print(toPrint);
	}
}
