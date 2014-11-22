package org.cavebeetle.stream;

public interface Stream<T>
    extends
        Iterable<T>
{
    public interface Map<IN, OUT>
    {
        OUT map(IN element);
    }

    T head();

    Stream<T> tail();

    boolean isEmpty();

    void abort();

    <U> Stream<U> map(Map<T, U> map);

    Stream<T> concatenate(Stream<T> stream);

    Stream<T> insert(Stream<T> stream);
}
