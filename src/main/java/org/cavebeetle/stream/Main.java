package org.cavebeetle.stream;

import static org.cavebeetle.stream.StreamUtils.toIterable;
import java.io.File;

public final class Main
{
    public static final void main(final String[] args)
    {
        final File dir = new File("src/main/java");
        final File file = new File(dir, "org/cavebeetle/stream/TextFileStream.java");
        final Stream<Line> stream = new TextFileStream(file);
        for (final Line line : toIterable(stream))
        {
            System.out.println(line);
        }
    }
}
