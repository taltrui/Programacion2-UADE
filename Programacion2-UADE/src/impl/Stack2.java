package impl;

import java.util.Arrays;

import api.StackADT;

public class Stack2 implements StackADT {
	int[] stack;
	int index;

	void moveItemsRight() {
		for (int i = index; i > 0; --i) {
			stack[i] = stack[i - 1];
		}
	}

	void moveItemsLeft() {
		for (int i = 0; i < index - 1; ++i) {
			stack[i] = stack[i + 1];
		}
	}

	@Override
	public void push(int x) {
		moveItemsRight();
		stack[0] = x;
		index++;
	}

	@Override
	public void pop() {
		moveItemsLeft();
		index--;
	}

	@Override
	public void initializeStack() {
		stack = new int[20];
		index = 0;
	}

	@Override
	public boolean isEmpty() {
		return index == 0;

	}

	@Override
	public int lastElement() {
		return stack[0];
	}

	@Override
	public void print() {
		String toPrint = " Current index: " + index + "\n Stack: " + Arrays.toString(stack);
		System.out.print(toPrint);
	}

}
