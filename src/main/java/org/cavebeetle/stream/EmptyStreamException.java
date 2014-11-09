package org.cavebeetle.stream;

public final class EmptyStreamException
    extends
        StreamException
{
    private static final long serialVersionUID = -262607813675925911L;

    public EmptyStreamException()
    {
        super("The stream has no more elements.");
    }
}
