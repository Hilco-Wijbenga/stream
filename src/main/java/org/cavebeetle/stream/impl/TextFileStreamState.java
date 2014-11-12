package org.cavebeetle.stream.impl;

import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import org.cavebeetle.stream.Line;
import org.cavebeetle.stream.StreamException;
import org.cavebeetle.stream.StreamState;

public final class TextFileStreamState
    implements
        StreamState<Line>
{
    public static final class UncheckedException
        extends
            StreamException
    {
        private static final long serialVersionUID = -5935810349120611017L;

        public UncheckedException(final String message, final Throwable cause)
        {
            super(message, cause);
        }
    }

    public static final FileReader newFileReader(final File file)
    {
        try
        {
            return new FileReader(file);
        }
        catch (final IOException e)
        {
            throw new UncheckedException(e.getMessage(), e);
        }
    }

    public static final String readLine(final LineNumberReader lineNumberReader)
    {
        try
        {
            return lineNumberReader.readLine();
        }
        catch (final IOException e)
        {
            close(lineNumberReader);
            throw new UncheckedException(e.getMessage(), e);
        }
    }

    public static final void close(final Closeable closeable)
    {
        try
        {
            closeable.close();
        }
        catch (final IOException e)
        {
            throw new UncheckedException(e.getMessage(), e);
        }
    }

    private final File             file;
    private final Line             line;
    private final LineNumberReader lineNumberReader;

    public TextFileStreamState(final File file)
    {
        this(file, new LineNumberReader(newFileReader(file)));
    }

    private TextFileStreamState(final File file, final LineNumberReader lineNumberReader)
    {
        this.file = file;
        this.lineNumberReader = lineNumberReader;
        final String text = readLine(lineNumberReader);
        if (text == null)
        {
            close(lineNumberReader);
            line = null;
        }
        else
        {
            line = new Line(file, lineNumberReader.getLineNumber(), text);
        }
    }

    @Override
    public Line head()
    {
        return line;
    }

    @Override
    public StreamState<Line> tail()
    {
        return new TextFileStreamState(file, lineNumberReader);
    }

    @Override
    public boolean isEmpty()
    {
        return line == null;
    }

    @Override
    public void abort()
    {
        close(lineNumberReader);
    }
}
