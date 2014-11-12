package org.cavebeetle.stream.impl;

import org.cavebeetle.stream.Stream;
import org.cavebeetle.stream.StreamState;

public final class MappedStreamState<IN, OUT>
    implements
        StreamState<OUT>
{
    private final Stream<IN>          stream;
    private final Stream.Map<IN, OUT> map;

    public MappedStreamState(final Stream<IN> stream, final Stream.Map<IN, OUT> map)
    {
        this.stream = stream;
        this.map = map;
    }

    @Override
    public OUT head()
    {
        return map.map(stream.head());
    }

    @Override
    public StreamState<OUT> tail()
    {
        return new MappedStreamState<IN, OUT>(stream.tail(), map);
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
