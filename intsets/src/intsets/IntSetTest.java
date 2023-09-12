package intsets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntSetTest {
	
	void testIntSet(IntSet set) {
		assertArrayEquals(new int[] {}, set.getElements());
		assertEquals(0, set.getSize());
		assertEquals(1, set.getRank(11));
		assertEquals(1, set.getRank(42));
		
		set.add(11);
		assertArrayEquals(new int[] {11}, set.getElements());
		assertEquals(1, set.getSize());
		assertEquals(11, set.getElementAtRank(1));
		assertEquals(1, set.getRank(10));
		assertEquals(1, set.getRank(11));
		assertEquals(2, set.getRank(42));
		
		set.add(11);
		assertArrayEquals(new int[] {11}, set.getElements());
		assertEquals(1, set.getSize());
		assertEquals(11, set.getElementAtRank(1));
		assertEquals(1, set.getRank(10));
		assertEquals(1, set.getRank(11));
		assertEquals(2, set.getRank(42));
		
		set.add(12);
		assertArrayEquals(new int[] {11, 12}, set.getElements());
		assertEquals(2, set.getSize());
		assertEquals(11, set.getElementAtRank(1));
		assertEquals(12, set.getElementAtRank(2));
		assertEquals(1, set.getRank(10));
		assertEquals(1, set.getRank(11));
		assertEquals(2, set.getRank(12));
		assertEquals(3, set.getRank(42));
		
		set.add(12);
		assertArrayEquals(new int[] {11, 12}, set.getElements());
		assertEquals(2, set.getSize());
		assertEquals(11, set.getElementAtRank(1));
		assertEquals(12, set.getElementAtRank(2));
		assertEquals(1, set.getRank(10));
		assertEquals(1, set.getRank(11));
		assertEquals(2, set.getRank(12));
		assertEquals(3, set.getRank(42));
		
		set.add(13);
		assertArrayEquals(new int[] {11, 12, 13}, set.getElements());
		assertEquals(3, set.getSize());
		assertEquals(11, set.getElementAtRank(1));
		assertEquals(12, set.getElementAtRank(2));
		assertEquals(13, set.getElementAtRank(3));
		assertEquals(1, set.getRank(10));
		assertEquals(1, set.getRank(11));
		assertEquals(2, set.getRank(12));
		assertEquals(3, set.getRank(13));
		assertEquals(4, set.getRank(42));
		
		set.add(10);
		assertArrayEquals(new int[] {10, 11, 12, 13}, set.getElements());
		assertEquals(4, set.getSize());
		assertEquals(10, set.getElementAtRank(1));
		assertEquals(11, set.getElementAtRank(2));
		assertEquals(12, set.getElementAtRank(3));
		assertEquals(13, set.getElementAtRank(4));
		assertEquals(1, set.getRank(10));
		assertEquals(2, set.getRank(11));
		assertEquals(3, set.getRank(12));
		assertEquals(4, set.getRank(13));
		assertEquals(5, set.getRank(42));
		
		ArrayIntSet arrayIntSet = new ArrayIntSet();
		arrayIntSet.add(10);
		arrayIntSet.add(11);
		assertFalse(set.equals(arrayIntSet));
		
		arrayIntSet.add(12);
		arrayIntSet.add(13);
		assertTrue(set.equals(arrayIntSet));
		
		IntRange intRange = new IntRange();
		intRange.add(10);
		intRange.add(11);
		assertFalse(set.equals(intRange));
		
		intRange.add(12);
		intRange.add(13);
		assertTrue(set.equals(intRange));
		
		set.remove(14);
		assertArrayEquals(new int[] {10, 11, 12, 13}, set.getElements());
		assertEquals(4, set.getSize());
		assertEquals(10, set.getElementAtRank(1));
		assertEquals(11, set.getElementAtRank(2));
		assertEquals(12, set.getElementAtRank(3));
		assertEquals(13, set.getElementAtRank(4));
		assertEquals(1, set.getRank(10));
		assertEquals(2, set.getRank(11));
		assertEquals(3, set.getRank(12));
		assertEquals(4, set.getRank(13));
		assertEquals(5, set.getRank(42));
		
		set.remove(13);
		assertArrayEquals(new int[] {10, 11, 12}, set.getElements());
		assertEquals(3, set.getSize());
		assertEquals(10, set.getElementAtRank(1));
		assertEquals(11, set.getElementAtRank(2));
		assertEquals(12, set.getElementAtRank(3));
		assertEquals(1, set.getRank(10));
		assertEquals(2, set.getRank(11));
		assertEquals(3, set.getRank(12));
		assertEquals(4, set.getRank(13));
		assertEquals(4, set.getRank(42));
		
		set.remove(10);
		assertArrayEquals(new int[] {11, 12}, set.getElements());
		assertEquals(2, set.getSize());
		assertEquals(11, set.getElementAtRank(1));
		assertEquals(12, set.getElementAtRank(2));
		assertEquals(1, set.getRank(10));
		assertEquals(1, set.getRank(11));
		assertEquals(2, set.getRank(12));
		assertEquals(3, set.getRank(42));
		
		set.remove(12);
		assertArrayEquals(new int[] {11}, set.getElements());
		assertEquals(1, set.getSize());
		assertEquals(11, set.getElementAtRank(1));
		assertEquals(1, set.getRank(10));
		assertEquals(1, set.getRank(11));
		assertEquals(2, set.getRank(42));
		
		set.remove(11);
		assertArrayEquals(new int[] {}, set.getElements());
		assertEquals(0, set.getSize());
		assertEquals(1, set.getRank(11));
		assertEquals(1, set.getRank(42));
		
		ArrayIntSet emptyArrayIntSet = new ArrayIntSet();
		assertTrue(set.equals(emptyArrayIntSet));
		IntRange emptyIntRange = new IntRange();
		assertTrue(set.equals(emptyIntRange));
		assertEquals(set.hashCode(), emptyIntRange.hashCode());
	}

	@Test
	void test() {
		testIntSet(new ArrayIntSet());
		testIntSet(new IntRange());
	}

}
