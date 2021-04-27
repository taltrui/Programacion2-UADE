package impl;

import api.MultipleDict;
import primitives.MultipleDictElement;

public class MultipleDict1 implements MultipleDict {
	MultipleDictElement[] elements;
	int cant;
	
	int getIndex(int key) {
		for (int i = 0; i < cant; ++i) {
			if (elements[i].key == key) return i;
		} 
		
		return -1;
	}

	@Override
	public void add(int key, int value) {
		
		int index = getIndex(key);
		
		if (index == -1) {
			MultipleDictElement newElem = new MultipleDictElement(key, value);
			elements[cant] = newElem;
			cant++;
		} else {
			elements[index].add(value);
		}
		
	}

	@Override
	public void remove(int key) {
		int index = getIndex(key);

		if (index == -1)
			return;

		elements[index] = elements[cant - 1];
		cant--;
	}


	@Override
	public void removeValue(int key, int value) {
		int index = getIndex(key);

		if (index == -1)
			return;

		elements[index].remove(value);
		
		if (elements[index].values.length == 0) remove(key);
	}

	@Override
	public String get(int key) {
		
		int index = getIndex(key);
		
		if (index == -1) return "-1";
		
		return elements[index].get();
	}

	@Override
	public String getKeys() {
		StringBuilder bld = new StringBuilder();
		bld.append("{ ");

		for (int i = 0; i < cant; ++i) {
			if (i > 0) bld.append(", ");
			bld.append(Integer.toString(elements[i].key));
		} 
		
		return bld.append(" }").toString();
	}

	@Override
	public void init() {
		elements = new MultipleDictElement[20];
		cant = 0;
	}

}
