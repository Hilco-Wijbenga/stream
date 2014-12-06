package org.cavebeetle.stream;

import java.io.File;

public interface StreamApi
{
    <T> Stream<T> newStreamFromIterable(Iterable<T> iterable);

    Stream<Line> newStreamFromTextFile(File textFile);

    <T> Stream<T> newEmptyStream();
}
