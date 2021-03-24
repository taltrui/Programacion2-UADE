package api;

public interface Stack {
	void push(int x);

	void pop();

	void initializeStack();

	boolean isEmpty();

	int lastElement();

	void print();
}
