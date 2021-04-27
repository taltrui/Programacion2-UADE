package api;

public interface SimpleDict {
	void add(int key, int value);
	
	void remove(int key);
	
	int get(int key);
	
	String getKeys();
	
	void init();
}
