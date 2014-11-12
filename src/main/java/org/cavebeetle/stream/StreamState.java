package org.cavebeetle.stream;

public interface StreamState<T>
{
    T head();

    StreamState<T> tail();

    boolean isEmpty();

    void abort();
}
