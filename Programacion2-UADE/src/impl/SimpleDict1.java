package impl;

import api.SimpleDict;
import primitives.SimpleDictElement;

public class SimpleDict1 implements SimpleDict {
	SimpleDictElement[] elements;
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
			SimpleDictElement newElem = new SimpleDictElement(key, value);
			elements[cant] = newElem;
			cant++;
		} else {
			elements[index].value = value;
		}
		
	}

	@Override
	public void remove(int key) {
		int index = getIndex(key);
		
		if (index == -1) return;
		
		elements[index] = elements[cant-1];
		cant--;
	}

	@Override
	public int get(int key) {
		
		int index = getIndex(key);
		
		if (index == -1) return -1;
		
		return elements[index].value;
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
		elements = new SimpleDictElement[20];
		cant = 0;
	}

}
