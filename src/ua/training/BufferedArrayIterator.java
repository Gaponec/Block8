package ua.training;

import java.util.Iterator;

public class BufferedArrayIterator<T> implements Iterator<T> {

    private int index = 0;
    T[] elements;
    private int buffer;

    public BufferedArrayIterator(T[] elements, int buffer) {
        this.elements = elements;
        this.buffer = buffer;
    }

    @Override
    public boolean hasNext() {
        if (index >= elements.length - buffer) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public T next() {
        T element = elements[index];
        index++;
        return element;
    }
}
