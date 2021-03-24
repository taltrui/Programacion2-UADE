package impl;

import java.util.Arrays;

import api.QueueTDA;

public class Queue1 implements QueueTDA {
	int[] stack;
	int index;

	void moveItemsRight() {
		for (int i = index; i > 0; --i) {
			stack[i] = stack[i - 1];
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
		return stack[index - 1];
	}

	@Override
	public void print() {
		String toPrint = " Current index: " + index + "\n Stack: " + Arrays.toString(stack);
		System.out.print(toPrint);
	}

}
