package org.cavebeetle.stream.impl;

import org.cavebeetle.stream.StreamState;

public final class SingletonStreamState<T>
    implements
        StreamState<T>
{
    private final boolean empty;
    private final T       singleton;

    public SingletonStreamState(final T singleton)
    {
        empty = false;
        this.singleton = singleton;
    }

    private SingletonStreamState()
    {
        empty = true;
        this.singleton = null;
    }

    @Override
    public T head()
    {
        return singleton;
    }

    @Override
    public StreamState<T> tail()
    {
        return new SingletonStreamState<T>();
    }

    @Override
    public boolean isEmpty()
    {
        return empty;
    }

    @Override
    public void abort()
    {
        // Empty.
    }
}
