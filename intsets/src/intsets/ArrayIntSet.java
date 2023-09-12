package intsets;

import java.util.stream.IntStream;

public class ArrayIntSet extends IntSet {
	
	/**
	 * @invar | elements != null
	 * @invar | IntStream.range(1, elements.length).allMatch(i -> elements[i - 1] < elements[i])
	 */
	private int[] elements = new int[0];
	
	@Override
	public int[] getElements() {
		return elements.clone();
	}
	
	@Override
	public int getSize() {
		return elements.length;
	}
	
	@Override
	public int getElementAtRank(int i) {
		return elements[i - 1];
	}
	
	@Override
	public int getRank(int value) {
		int i = 0;
		while (i < elements.length && elements[i] < value)
			i++;
		return 1 + i;
	}
	
	/**
	 * @post | getSize() == 0
	 */
	public ArrayIntSet() {}
	
	@Override
	public void add(int value) {
		int i = getRank(value) - 1;
		if (i == elements.length || elements[i] != value) {
			int[] newElements = new int[elements.length + 1];
			System.arraycopy(elements, 0, newElements, 0, i);
			newElements[i] = value;
			System.arraycopy(elements, i, newElements, i + 1, elements.length - i);
			elements = newElements;
		}
	}
	
	@Override
	public void remove(int value) {
		int i = getRank(value) - 1;
		if (i < elements.length && elements[i] == value) {
			int[] newElements = new int[elements.length - 1];
			System.arraycopy(elements, 0, newElements, 0, i);
			System.arraycopy(elements, i + 1, newElements, i, elements.length - i - 1);
			elements = newElements;
		}
	}

}
