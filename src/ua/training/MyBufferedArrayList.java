package ua.training;

import java.util.Iterator;

public class MyBufferedArrayList<T> implements MyList<T> {

    private T[] elements;
    private int bufferSize;

    public MyBufferedArrayList() {
        bufferSize = 1;
        elements = (T[]) new Object[bufferSize];
    }

    @Override
    public void add(T element) {
        try {
            elements[getCell()] = element;
            bufferSize--;
        } catch (ArrayIndexOutOfBoundsException e) {
            createNewArrayWithBuffer();
            add(element);
        }
    }

    @Override
    public void put(int index, T element) throws ArrayIndexOutOfBoundsException {
        verifyCell(index);
        elements[index] = element;
    }

    @Override
    public T get(int index) throws ArrayIndexOutOfBoundsException {
        verifyCell(index);

        return elements[index];
    }

    @Override
    public int length() {
        return elements.length - bufferSize;
    }

    @Override
    public Iterator<T> iterator() {
        return new BufferedArrayIterator<>(elements, bufferSize);
    }

    private int getCell() {
        if (bufferSize > 0) {
            return elements.length - bufferSize;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void createNewArrayWithBuffer() {
        bufferSize = elements.length / 2 + 1;
        int newLength = elements.length + bufferSize;

        T[] newArray = (T[]) new Object[newLength];
        System.arraycopy(elements, 0, newArray, 0, elements.length);

        elements = newArray;
    }

    private void verifyCell(int cell) {
        if (cell > elements.length - bufferSize - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
