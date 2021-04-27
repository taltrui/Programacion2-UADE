package primitives;

public class MultipleDictElement {
	public int key;
	public int[] values;
	public int cantValues;

	public MultipleDictElement(int newKey, int initialValue) {
		values = new int[20];
		key = newKey;
		add(initialValue);
	}

	int getIndex(int value) {
		for (int i = 0; i < cantValues; ++i) {
			if (values[i] == value)
				return i;
		}

		return -1;
	}

	public void add(int value) {
		values[cantValues] = value;
		cantValues++;
	}

	public void remove(int value) {

		int index = getIndex(value);

		if (index == -1)
			return;

		values[index] = values[cantValues - 1];
		cantValues--;
	}
	
	public String get() {
		StringBuilder bld = new StringBuilder();
		bld.append("{ ");

		for (int i = 0; i < cantValues; ++i) {
			if (i > 0) bld.append(", ");
			bld.append(Integer.toString(values[i]));
		} 
		
		return bld.append(" }").toString();
	}
}
