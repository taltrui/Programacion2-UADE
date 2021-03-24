package api;

public interface QueueTDA {
	void push(int x);

	void pop();

	void initialize();

	boolean isEmpty();

	int first();

	void print();
}
