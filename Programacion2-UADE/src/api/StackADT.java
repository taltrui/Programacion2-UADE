package api;

public interface StackADT {
	void Push(int x);
	void Pop();
	void InitializeStack();
	boolean IsEmpty();
	int LastElement();
	void MovePointerToLastItem();
	void Print();
}
