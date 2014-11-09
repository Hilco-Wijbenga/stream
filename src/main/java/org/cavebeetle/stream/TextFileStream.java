package org.cavebeetle.stream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public final class TextFileStream
    implements
        Stream<Line>
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

    private final File              file;
    private final Line              line;
    private final LineNumberReader  lineNumberReader;
    private volatile TextFileStream tail;

    public TextFileStream(final File file)
    {
        this.file = file;
        try
        {
            lineNumberReader = new LineNumberReader(new FileReader(file));
            final String text = lineNumberReader.readLine();
            if (text == null)
            {
                lineNumberReader.close();
                line = null;
            }
            else
            {
                line = new Line(file, lineNumberReader.getLineNumber(), text);
            }
        }
        catch (final IOException e)
        {
            throw new UncheckedException(e.getMessage(), e);
        }
    }

    private TextFileStream(final File file, final LineNumberReader lineNumberReader)
    {
        this.file = file;
        try
        {
            this.lineNumberReader = lineNumberReader;
            final String text = lineNumberReader.readLine();
            if (text == null)
            {
                lineNumberReader.close();
                line = null;
            }
            else
            {
                line = new Line(file, lineNumberReader.getLineNumber(), text);
            }
        }
        catch (final IOException e)
        {
            throw new UncheckedException(e.getMessage(), e);
        }
    }

    @Override
    public Line head()
    {
        if (isEmpty())
        {
            throw new EmptyStreamException();
        }
        return line;
    }

    @Override
    public Stream<Line> tail()
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
                    tail = new TextFileStream(file, lineNumberReader);
                }
            }
        }
        return tail;
    }

    @Override
    public boolean isEmpty()
    {
        return line == null;
    }

    @Override
    public void abort()
    {
        try
        {
            lineNumberReader.close();
        }
        catch (final IOException e)
        {
            throw new UncheckedException(e.getMessage(), e);
        }
    }
}
