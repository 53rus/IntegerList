package proskyIntegerList.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proskyIntegerList.exception.InvalidIndexException;
import proskyIntegerList.exception.NullItemException;
import proskyIntegerList.exception.StorageIsFullException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegerListTest {

    private final IntegerList list = new IntegerListImpl(11);

    @BeforeEach
    public void setUp() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

    }

    @Test
    public void addTest() {
        assertEquals(10, list.size());
    }

    @Test
    public void StorageIsFullExceptionTest() {
        list.add(100500);

        assertThrows(StorageIsFullException.class, () -> list.add(11));

    }

    @Test
    public void addIndexTest() {
        list.add(3, 100500);

        Assertions.assertEquals(100500, list.get(3));
        Assertions.assertEquals(10, list.get(10));

    }

    @Test
    public void setTest() {

        list.set(4, 100500);
        Assertions.assertEquals(100500, list.get(4));

    }

    @Test
    public void removeItemTest() {

        list.remove(1);

        Assertions.assertEquals(9, list.size());
        Assertions.assertEquals(3, list.get(1));
    }

    @Test
    public void removeIndexTest() {

        list.remove(0);

        Assertions.assertEquals(9, list.size());
        Assertions.assertEquals(2, list.get(0));
    }

    @Test
    public void containsTest() {

        Assertions.assertTrue(list.contains(1));
        Assertions.assertTrue(list.contains(2));
        Assertions.assertTrue(list.contains(7));

    }

    @Test
    public void indexOfTest() {

        Assertions.assertEquals(0, list.indexOf(1));
        Assertions.assertEquals(-1, list.indexOf(20));
    }

    @Test
    public void lastIndexOfTest() {

        Assertions.assertEquals(0, list.indexOf(1));
        Assertions.assertEquals(-1, list.indexOf(20));
    }

    @Test
    public void getTest() {

        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(10, list.get(9));
    }

    @Test
    public void equalsTest() {
        IntegerList testList = new IntegerListImpl(11);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        testList.add(7);
        testList.add(8);
        testList.add(9);
        testList.add(10);

        assertTrue(list.equals(testList));

    }

    @Test
    public void sizeTest() {

        assertEquals(10, list.size());
    }

    @Test
    public void isEmptyTest() {

        IntegerList testList = new IntegerListImpl(11);

        assertFalse(list.isEmpty());
        assertTrue(testList.isEmpty());
    }

    @Test
    public void clearTest() {

        list.clear();

        assertTrue(list.isEmpty());

    }

    @Test
    public void toArrayTest() {

        Integer[] testList = list.toArray();

        assertEquals(1,testList[0]);
        assertEquals(10, testList.length);

    }

    @Test
    public void InvalidIndexExceptionTest() {

        assertThrows(InvalidIndexException.class, () -> list.get(20));
    }

    @Test
    public void NullItemExceptionTest() {

        assertThrows(NullItemException.class, () -> list.add(null));

    }
}

