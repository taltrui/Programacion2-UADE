package impl;

import java.util.Arrays;

import api.QueueTDA;

public class Queue3 implements QueueTDA {
	int[] stack;

	void moveItemsRight() {
		for (int i = stack[0]; i > 0; --i) {
			stack[i] = stack[i - 1];
		}
	}

	@Override
	public void push(int x) {
		moveItemsRight();
		stack[stack[0]] = x;
		++stack[0];
	}

	@Override
	public void pop() {
		stack[0]--;
	}

	@Override
	public void initialize() {
		stack = new int[20];
		stack[0] = 0;
	}

	@Override
	public boolean isEmpty() {
		return stack[0] == 0;
	}

	@Override
	public int first() {
		return stack[stack[0]];
	}

	@Override
	public void print() {
		String toPrint = " Current index: " + stack[0] + "\n Stack: " + Arrays.toString(stack);
		System.out.print(toPrint);
	}

}
