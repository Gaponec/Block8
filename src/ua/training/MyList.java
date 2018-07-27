package ua.training;

public interface MyList<T> extends Iterable<T> {
    public void add(T e);
    public void put(int index, T e);
    T get(int index);
    int length();
}
