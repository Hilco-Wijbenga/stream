package org.cavebeetle.stream;

public class StreamException
    extends
        RuntimeException
{
    private static final long serialVersionUID = -446579071219355705L;

    public StreamException(final String message)
    {
        super(message);
    }

    public StreamException(final String message, final Throwable cause)
    {
        super(message, cause);
    }
}
