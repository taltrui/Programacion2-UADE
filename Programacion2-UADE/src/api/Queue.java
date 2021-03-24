package api;

public interface Queue {
	void push(int x);

	void pop();

	void initialize();

	boolean isEmpty();

	int first();

	void print();
}
