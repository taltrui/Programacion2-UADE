package impl;

import java.util.Arrays;

import api.Queue;

public class Queue2 implements Queue {
	int[] stack;
	int index;

	void moveItemsLeft() {
		for (int i = 0; i < index - 1; ++i) {
			stack[i] = stack[i + 1];
		}
	}

	@Override
	public void push(int x) {
		stack[index] = x;
		index++;
	}

	@Override
	public void pop() {
		moveItemsLeft();
		index--;
	}

	@Override
	public void initialize() {
		stack = new int[20];
		index = 0;
	}

	@Override
	public boolean isEmpty() {
		return index == 0;
	}

	@Override
	public int first() {
		return stack[0];
	}

	@Override
	public void print() {
		String toPrint = " Current index: " + index + "\n Stack: " + Arrays.toString(stack);
		System.out.print(toPrint);
	}

}
