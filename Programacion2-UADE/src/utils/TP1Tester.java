package utils;

import api.StackADT;
import impl.Stack1;

public class TP1Tester {
	int SumStack(StackADT stack) {
		int sum = 0;
		while(!stack.IsEmpty()) {
			sum += stack.LastElement();
			stack.Pop();
		}

		stack.MovePointerToLastItem();
		return sum;
	}
	
	int CountStack(StackADT stack) {
		int count = 0;
		while(!stack.IsEmpty()) {
			count += 1;
			stack.Pop();
		}

		stack.MovePointerToLastItem();
		return count;
	}
	
	void TransferStack(StackADT stack, StackADT newStack) {
		while(!stack.IsEmpty()) {
			newStack.Push(stack.LastElement());
			stack.Pop();
		}
		stack.MovePointerToLastItem();
	}
	
	void CopyStack(StackADT stack, StackADT newStack, StackADT bufferStack) {
		while(!stack.IsEmpty()) {
			bufferStack.Push(stack.LastElement());
			stack.Pop();
		}
		
		stack.MovePointerToLastItem();

		while(!bufferStack.IsEmpty()) {
			newStack.Push(bufferStack.LastElement());
			bufferStack.Pop();
		}
	}
	
	void InvertStack(StackADT stack, StackADT bufferStack, StackADT secondBuffer) {
		while(!stack.IsEmpty()) {
			bufferStack.Push(stack.LastElement());
			stack.Pop();
		}
		
		while(!bufferStack.IsEmpty()) {
			secondBuffer.Push(bufferStack.LastElement());
			bufferStack.Pop();
		}
		
		while(!secondBuffer.IsEmpty()) {
			stack.Push(secondBuffer.LastElement());
			secondBuffer.Pop();
		}
	}
	
	float StackAverage(StackADT stack) {
		float count = CountStack(stack);
		float sum = SumStack(stack);
		
		return sum / count;
	}

	Stack1 createStack1WithItems() {
		Stack1 stack = new Stack1();
		stack.InitializeStack();

		for (int i = 0; i < 10; i++) {
			stack.Push(i+1);
		}
		
		return stack;
	}

	void PrintStack(String title, StackADT stack) {
		System.out.print("\n\n" + title + ":\n");
		stack.Print();
	}
	
	void PrintTitle(String title) {
		System.out.print("\n\n" + title);
	}

	void Test(StackADT stack, StackADT test1NewStack, StackADT test1BufferStack, StackADT test1SecondBufferStack) {
		PrintTitle("Test 1 - Move one stack to another");
		TransferStack(stack, test1NewStack);
		PrintStack("Original", stack);
		PrintStack("New", test1NewStack);
		PrintTitle("-----------------");
		
		PrintTitle("Test 2 - Copy one stack to another");
		test1NewStack.InitializeStack();
		CopyStack(stack, test1NewStack, test1BufferStack);
		PrintStack("Original", stack);
		PrintStack("New", test1NewStack);
		PrintTitle("-----------------");
		
		PrintTitle("Test 3 - Invert stack");
		test1BufferStack.InitializeStack();
		PrintStack("Original", stack);
		InvertStack(stack, test1BufferStack, test1SecondBufferStack);
		PrintStack("Inverted", stack);
		PrintTitle("-----------------");
		
		PrintTitle("Test 4 - Stack count");
		PrintStack("Counted stack", stack);
		int count = CountStack(stack);
		PrintTitle("Result: " + count);
		PrintTitle("-----------------");
		
		PrintTitle("Test 5 - Stack sum");
		PrintStack("Summed stack", stack);
		int sum = SumStack(stack);
		PrintTitle("Result: " + sum);
		PrintTitle("-----------------");
		
		PrintTitle("Test 6 - Stack average");
		PrintStack("Summed stack", stack);
		float avg = StackAverage(stack);
		PrintTitle("Result: " + avg);
		PrintTitle("-----------------");
		
		
	}
	public void TestStack1() {
		
		PrintTitle("Tests for stack implementation 1");
		PrintTitle("-----------------");
		Stack1 stack = createStack1WithItems();
		Stack1 test1NewStack = new Stack1();
		test1NewStack.InitializeStack();
		Stack1 test1BufferStack = new Stack1();
		test1BufferStack.InitializeStack();
		Stack1 test1SecondBufferStack = new Stack1();
		test1SecondBufferStack.InitializeStack();

		Test(stack, test1NewStack, test1BufferStack, test1SecondBufferStack);
	}
	
}
