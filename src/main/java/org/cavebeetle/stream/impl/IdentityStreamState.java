package org.cavebeetle.stream.impl;

import org.cavebeetle.stream.Stream;
import org.cavebeetle.stream.StreamState;

public final class IdentityStreamState<T>
    implements
        StreamState<T>
{
    private final Stream<T> stream;

    public IdentityStreamState(final Stream<T> stream)
    {
        this.stream = stream;
    }

    @Override
    public T head()
    {
        return stream.head();
    }

    @Override
    public StreamState<T> tail()
    {
        return new IdentityStreamState<T>(stream.tail());
    }

    @Override
    public boolean isEmpty()
    {
        return stream.isEmpty();
    }

    @Override
    public void abort()
    {
        stream.abort();
    }
}
