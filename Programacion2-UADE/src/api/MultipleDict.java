package api;

public interface MultipleDict {
	void add(int key, int value);
	
	void remove(int key);
	
	void removeValue(int key, int value);

	String get(int key);
	
	String getKeys();
	
	void init();
}
