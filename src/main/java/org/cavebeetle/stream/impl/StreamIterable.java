package org.cavebeetle.stream.impl;

import java.util.Iterator;
import org.cavebeetle.stream.Stream;

public final class StreamIterable<T>
    implements
        Iterable<T>
{
    private final Iterator<T> iterator;

    public StreamIterable(final Stream<T> stream)
    {
        iterator = stream.toIterator();
    }

    @Override
    public Iterator<T> iterator()
    {
        return iterator;
    }
}
