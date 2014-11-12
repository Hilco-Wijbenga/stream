package org.cavebeetle.stream;

import java.util.Iterator;

public interface Stream<T>
{
    public interface Map<IN, OUT>
    {
        OUT map(IN element);
    }

    T head();

    Stream<T> tail();

    boolean isEmpty();

    void abort();

    Iterator<T> toIterator();

    Iterable<T> toIterable();

    <U> Stream<U> map(Map<T, U> map);

    Stream<T> concatenate(Stream<T> stream);

    Stream<T> insert(Stream<T> stream);
}
