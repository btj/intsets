package intsets;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @invar | getElements() != null
 * @invar | getSize() == getElements().length
 * @invar | IntStream.range(1, getSize()).allMatch(i -> getElements()[i - 1] < getElements()[i])
 */
public abstract class IntSet {
	
	/**
	 * @creates | result
	 */
	public abstract int[] getElements();
	public abstract int getSize();
	/**
	 * @pre | 1 <= i
	 * @pre | i <= getSize() 
	 * @post | result == getElements()[i - 1]
	 */
	public abstract int getElementAtRank(int i);
	/**
	 * @post | 1 <= result
	 * @post | result <= getSize() + 1
	 * @post | IntStream.range(1, result).allMatch(i -> getElements()[i - 1] < value)
	 * @post | IntStream.range(result, getSize() + 1).allMatch(i -> value <= getElements()[i - 1])
	 */
	public abstract int getRank(int value);
	/**
	 * @post | Arrays.stream(old(getElements())).allMatch(e -> Arrays.stream(getElements()).anyMatch(e1 -> e1 == e))
	 * @post | Arrays.stream(getElements()).anyMatch(e -> e == value)
	 * @post | Arrays.stream(getElements()).allMatch(e -> e == value || Arrays.stream(old(getElements())).anyMatch(e1 -> e1 == e))
	 */
	public abstract void add(int value);
	/**
	 * @post | Arrays.stream(old(getElements())).allMatch(e -> e == value || Arrays.stream(getElements()).anyMatch(e1 -> e1 == e))
	 * @post | Arrays.stream(getElements()).allMatch(e -> e != value && Arrays.stream(old(getElements())).anyMatch(e1 -> e1 == e))
	 */
	public abstract void remove(int value);
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof IntSet s && Arrays.equals(getElements(), s.getElements());
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(getElements());
	}

}
