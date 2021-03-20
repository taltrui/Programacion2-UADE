package impl;

import java.util.Arrays;

import api.StackADT;

public class Stack1 implements StackADT {
	int[] stack;
	int index;
	int lastIndex;

	@Override
	public void Push(int x) {
		stack[index] = x;
		index++;
		lastIndex = index;
	}

	@Override
	public void Pop() {
		index--;
	}

	@Override
	public void InitializeStack() {
		stack = new int[10];
		index = 0;
		
	}

	@Override
	public int LastElement() {
		return stack[index-1];
	}

	@Override
	public boolean IsEmpty() {
		return index == 0;
	}

	@Override
	public void MovePointerToLastItem() {
		index = lastIndex;
		
	}

	@Override
	public void Print() {
		String toPrint = " Current index: " + index + "\n Total items: " + (lastIndex -1) + "\n Stack: " + Arrays.toString(stack);
		System.out.print(toPrint);
	}
}
