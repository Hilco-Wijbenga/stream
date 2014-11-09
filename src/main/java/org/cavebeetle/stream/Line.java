package org.cavebeetle.stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;
import java.io.File;

public final class Line
{
    private final File   source;
    private final int    lineNumber;
    private final String text;

    public Line(final File source, final int lineNumber, final String text)
    {
        checkNotNull(source, "Missing 'source'.");
        checkArgument(lineNumber > 0, "Invalid 'lineNumber'.");
        checkNotNull(text, "Missing 'text'.");
        this.source = source;
        this.lineNumber = lineNumber;
        this.text = text;
    }

    public File getSource()
    {
        return source;
    }

    public int getLineNumber()
    {
        return lineNumber;
    }

    public String getText()
    {
        return text;
    }

    @Override
    public int hashCode()
    {
        final int prime = 43;
        int result = 1;
        result = prime * result + source.hashCode();
        result = prime * result + lineNumber;
        result = prime * result + text.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        final Line other = (Line) obj;
        if (!source.equals(other.source))
        {
            return false;
        }
        if (lineNumber != other.lineNumber)
        {
            return false;
        }
        if (!text.equals(other.text))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return format("[Line source='%s' lineNumber=%d text='%s']", source, lineNumber, text);
    }
}
