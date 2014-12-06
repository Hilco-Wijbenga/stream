package org.cavebeetle.stream.impl;

import java.io.File;
import org.cavebeetle.stream.Line;
import org.cavebeetle.stream.Stream;
import org.cavebeetle.stream.StreamApi;

public final class DefaultStreamApi
    implements
        StreamApi
{
    private interface Lazy
    {
        Stream<?> EMPTY_STREAM = new DefaultStream<Object>(new EmptyStreamState<Object>());
    }

    @Override
    public <T> Stream<T> newStreamFromIterable(final Iterable<T> iterable)
    {
        return new DefaultStream<T>(new IterableStreamState<T>(iterable));
    }

    @Override
    public Stream<Line> newStreamFromTextFile(final File textFile)
    {
        return new DefaultStream<Line>(new TextFileStreamState(textFile));
    }

    @Override
    public <T> Stream<T> newEmptyStream()
    {
        @SuppressWarnings("unchecked")
        final Stream<T> emptyStream = (Stream<T>) Lazy.EMPTY_STREAM;
        return emptyStream;
    }
}
