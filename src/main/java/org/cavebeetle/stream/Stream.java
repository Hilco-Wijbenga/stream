package org.cavebeetle.stream;

public interface Stream<T>
{
    T head();

    Stream<T> tail();

    boolean isEmpty();

    void abort();
}
