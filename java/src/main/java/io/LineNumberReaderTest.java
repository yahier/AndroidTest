package io;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * LineNumberReader StringReader
 */
public class LineNumberReaderTest {

    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("hello");
        LineNumberReader lineNumberReader = new LineNumberReader(reader);
        PrintWriter writer = new PrintWriter(System.out);
        writer.println(lineNumberReader.readLine());
        writer.flush();

    }
}
