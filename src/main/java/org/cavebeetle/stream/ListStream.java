package org.cavebeetle.stream;

import java.util.List;

public final class ListStream<T>
    implements
        Stream<T>
{
    private final List<T>      list;
    private final int          index;
    private volatile Stream<T> tail;

    public ListStream(final List<T> list)
    {
        this.list = list;
        this.index = 0;
    }

    private ListStream(final List<T> list, final int index)
    {
        this.list = list;
        this.index = index;
    }

    @Override
    public T head()
    {
        if (isEmpty())
        {
            throw new EmptyStreamException();
        }
        return list.get(index);
    }

    @Override
    public Stream<T> tail()
    {
        if (isEmpty())
        {
            throw new EmptyStreamException();
        }
        if (tail == null)
        {
            synchronized (this)
            {
                if (tail == null)
                {
                    tail = new ListStream<T>(list, index + 1);
                }
            }
        }
        return tail;
    }

    @Override
    public boolean isEmpty()
    {
        return index == list.size();
    }

    @Override
    public void abort()
    {
        // Empty.
    }
}
