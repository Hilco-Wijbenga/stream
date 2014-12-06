package org.cavebeetle.stream;

public interface Stream<T>
    extends
        Iterable<T>
{
    T head();

    Stream<T> tail();

    boolean isEmpty();

    void abort();

    Stream<T> concatenate(Stream<T> stream);

    Stream<T> insert(Stream<T> stream);
}
