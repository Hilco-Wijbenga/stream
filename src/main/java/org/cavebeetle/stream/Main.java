package org.cavebeetle.stream;

import java.io.File;
import org.cavebeetle.stream.impl.DefaultStreamApi;

public final class Main
{
    public static final void main(final String[] args)
    {
        final StreamApi streamApi = new DefaultStreamApi();
        final File dir = new File("src/main/java");
        final File file = new File(dir, "org/cavebeetle/stream/Main.java");
        final Stream<Line> stream = streamApi.newStreamFromTextFile(file);
        for (final Line line : stream)
        {
            System.out.println(line);
        }
    }
}
