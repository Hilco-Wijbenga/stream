package org.cavebeetle.stream;

import java.util.Iterator;

public final class StreamUtils
{
    public static final class StreamIterator<T>
        implements
            Iterator<T>
    {
        private Stream<T> stream;

        public StreamIterator(final Stream<T> stream)
        {
            this.stream = stream;
        }

        @Override
        public boolean hasNext()
        {
            return !stream.isEmpty();
        }

        @Override
        public T next()
        {
            try
            {
                return stream.head();
            }
            finally
            {
                stream = stream.tail();
            }
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException("A StreamIterator does not support remove.");
        }
    }

    public static final class StreamIterable<T>
        implements
            Iterable<T>
    {
        private final Iterator<T> iterator;

        public StreamIterable(final Stream<T> stream)
        {
            iterator = toIterator(stream);
        }

        @Override
        public Iterator<T> iterator()
        {
            return iterator;
        }
    }

    public static final <T> Iterator<T> toIterator(final Stream<T> stream)
    {
        return new StreamIterator<T>(stream);
    }

    public static final <T> Iterable<T> toIterable(final Stream<T> stream)
    {
        return new StreamIterable<T>(stream);
    }
}
