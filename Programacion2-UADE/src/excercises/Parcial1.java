package excercises;

import impl.MultipleDict1;

public class Parcial1 {

	public static void main(String[] args) {
		MultipleDict1 dict = new MultipleDict1();
		
		dict.init();
		dict.add(0, 2);
		dict.add(1, 3);
		dict.add(20, 1);
		dict.add(20, 20);
		dict.add(20, 10);
		dict.add(20, 5);
		dict.add(1, 20);
		dict.remove(0);
		dict.removeValue(20, 1);
		dict.add(0, 20);
		dict.getKeys();
		dict.get(1);
		dict.get(2);
		dict.get(20);
	}

}
