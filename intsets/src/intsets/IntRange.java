package intsets;

public class IntRange extends IntSet {
	
	/**
	 * @invar | 0 <= size
	 */
	private int size;
	private int start;
	
	@Override
	public int[] getElements() {
		int[] result = new int[size];
		for (int i = 0; i < size; i++)
			result[i] = start + i;
		return result;
	}
	
	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	public int getElementAtRank(int i) {
		return start + (i - 1);
	}
	
	@Override
	public int getRank(int value) {
		if (size == 0 || value <= start)
			return 1;
		if (start + size <= value)
			return 1 + size;
		return 1 + value - start;
	}
	
	/**
	 * @post | getSize() == 0
	 */
	public IntRange() {}
	
	@Override
	public void add(int value) {
		if (size == 0)
			start = value;
		else if (start <= value && value < start + size)
			return;
		else if (value == start - 1) {
			start--;
		} else if (value != start + size) {
			throw new UnsupportedOperationException();
		}
		size++;
	}
	
	@Override
	public void remove(int value) {
		if (size == 0 || value < start || start + size <= value)
			return;
		if (value == start)
			start++;
		else if (value != start + size - 1)
			throw new UnsupportedOperationException();
		size--;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IntRange r)
			return size == r.size && (size == 0 || start == r.start);
		return super.equals(obj);
	}

}
