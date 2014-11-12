package org.cavebeetle.stream.impl;

import org.cavebeetle.stream.StreamState;

public final class InfiniteStreamState<T>
    implements
        StreamState<T>
{
    private final T element;

    public InfiniteStreamState(final T element)
    {
        this.element = element;
    }

    @Override
    public T head()
    {
        return element;
    }

    @Override
    public StreamState<T> tail()
    {
        return this;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public void abort()
    {
        // Empty.
    }
}
