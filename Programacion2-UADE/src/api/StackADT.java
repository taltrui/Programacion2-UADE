package api;

public interface StackADT {
	void push(int x);

	void pop();

	void initializeStack();

	boolean isEmpty();

	int lastElement();

	void print();
}
