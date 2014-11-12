package org.cavebeetle.stream;

import java.io.File;

public interface StreamApi
{
    <T> Stream<T> newInfiniteStreamOf(T element);

    <T> Stream<T> newSingletonStream(T element);

    <T> Stream<T> newIterableStream(Iterable<T> iterable);

    Stream<Line> newTextFileStream(File textFile);
}
