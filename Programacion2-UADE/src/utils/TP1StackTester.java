package utils;

import api.StackADT;
import impl.Stack1;
import impl.Stack2;
import impl.Stack3;

public class TP1StackTester {
	int sumStack(StackADT stack) {
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.lastElement();
			stack.pop();
		}

		populateStack(stack);
		return sum;
	}

	int countStack(StackADT stack) {
		int count = 0;
		while (!stack.isEmpty()) {
			count += 1;
			stack.pop();
		}

		populateStack(stack);
		return count;
	}

	void transferStack(StackADT stack, StackADT newStack) {
		while (!stack.isEmpty()) {
			newStack.push(stack.lastElement());
			stack.pop();
		}
		populateStack(stack);
	}

	void copyStack(StackADT stack, StackADT newStack, StackADT bufferStack) {
		while (!stack.isEmpty()) {
			bufferStack.push(stack.lastElement());
			stack.pop();
		}

		populateStack(stack);

		while (!bufferStack.isEmpty()) {
			newStack.push(bufferStack.lastElement());
			bufferStack.pop();
		}
	}

	void invertStack(StackADT stack, StackADT bufferStack, StackADT secondBuffer) {
		populateStack(stack);

		while (!stack.isEmpty()) {
			bufferStack.push(stack.lastElement());
			stack.pop();
		}

		while (!bufferStack.isEmpty()) {
			secondBuffer.push(bufferStack.lastElement());
			bufferStack.pop();
		}

		while (!secondBuffer.isEmpty()) {
			stack.push(secondBuffer.lastElement());
			secondBuffer.pop();
		}
	}

	float stackAverage(StackADT stack) {
		float count = countStack(stack);
		float sum = sumStack(stack);

		return sum / count;
	}

	void populateStack(StackADT stack) {
		stack.initializeStack();
		for (int i = 0; i < 10; i++) {
			stack.push(i + 1);
		}
	}

	void printStack(String title, StackADT stack) {
		System.out.print("\n\n" + title + ":\n");
		stack.print();
	}

	void printTitle(String title) {
		System.out.print("\n\n" + title);
	}

	void test(StackADT stack, StackADT test1NewStack, StackADT test1BufferStack, StackADT test1SecondBufferStack) {
		printTitle("Test 1 - Move one stack to another");
		transferStack(stack, test1NewStack);
		printStack("Original", stack);
		printStack("New", test1NewStack);
		printTitle("-----------------");

		printTitle("Test 2 - Copy one stack to another");
		test1NewStack.initializeStack();
		copyStack(stack, test1NewStack, test1BufferStack);
		printStack("Original", stack);
		printStack("New", test1NewStack);
		printTitle("-----------------");

		printTitle("Test 3 - Invert stack");
		test1BufferStack.initializeStack();
		printStack("Original", stack);
		invertStack(stack, test1BufferStack, test1SecondBufferStack);
		printStack("Inverted", stack);
		printTitle("-----------------");

		printTitle("Test 4 - Stack count");
		printStack("Counted stack", stack);
		int count = countStack(stack);
		printTitle("Result: " + count);
		printTitle("-----------------");

		printTitle("Test 5 - Stack sum");
		printStack("Summed stack", stack);
		int sum = sumStack(stack);
		printTitle("Result: " + sum);
		printTitle("-----------------");

		printTitle("Test 6 - Stack average");
		printStack("Summed stack", stack);
		float avg = stackAverage(stack);
		printTitle("Result: " + avg);
		printTitle("-----------------");

	}

	public void testStack1() {

		printTitle("Tests for stack implementation 1");
		printTitle("-----------------");
		Stack1 stack = new Stack1();
		stack.initializeStack();
		populateStack(stack);
		Stack1 newStack = new Stack1();
		newStack.initializeStack();
		Stack1 bufferStack = new Stack1();
		bufferStack.initializeStack();
		Stack1 secondBufferStack = new Stack1();
		secondBufferStack.initializeStack();

		test(stack, newStack, bufferStack, secondBufferStack);
	}

	public void testStack2() {

		printTitle("Tests for stack implementation 2");
		printTitle("-----------------");
		Stack2 stack = new Stack2();
		stack.initializeStack();
		populateStack(stack);
		Stack2 newStack = new Stack2();
		newStack.initializeStack();
		Stack2 bufferStack = new Stack2();
		bufferStack.initializeStack();
		Stack2 secondBufferStack = new Stack2();
		secondBufferStack.initializeStack();

		test(stack, newStack, bufferStack, secondBufferStack);
	}
	
	public void testStack3() {

		printTitle("Tests for stack implementation 3");
		printTitle("-----------------");
		Stack3 stack = new Stack3();
		stack.initializeStack();
		populateStack(stack);
		Stack3 newStack = new Stack3();
		newStack.initializeStack();
		Stack3 bufferStack = new Stack3();
		bufferStack.initializeStack();
		Stack3 secondBufferStack = new Stack3();
		secondBufferStack.initializeStack();

		test(stack, newStack, bufferStack, secondBufferStack);
	}

}
