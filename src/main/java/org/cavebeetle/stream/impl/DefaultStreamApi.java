package org.cavebeetle.stream.impl;

import java.io.File;
import org.cavebeetle.stream.Line;
import org.cavebeetle.stream.Stream;
import org.cavebeetle.stream.StreamApi;

public final class DefaultStreamApi
    implements
        StreamApi
{
    @Override
    public <T> Stream<T> newInfiniteStreamOf(final T element)
    {
        return new DefaultStream<T>(new InfiniteStreamState<T>(element));
    }

    @Override
    public <T> Stream<T> newSingletonStream(final T element)
    {
        return new DefaultStream<T>(new SingletonStreamState<T>(element));
    }

    @Override
    public <T> Stream<T> newIterableStream(final Iterable<T> iterable)
    {
        return new DefaultStream<T>(new IterableStreamState<T>(iterable));
    }

    @Override
    public Stream<Line> newTextFileStream(final File textFile)
    {
        return new DefaultStream<Line>(new TextFileStreamState(textFile));
    }
}
