package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

public class IO {
    

    private final BufferedReader reader;
    private final PrintWriter writer;

    public IO(Reader reader, Writer writer) {
        this.reader = new BufferedReader(reader);
        this.writer = new PrintWriter(writer);
    }

    /**
     * Returns the next command or null if end of file is reached.
     */
    public Command next() throws IOException {
        String line;

        // Advance until next command line
        while ((line = reader.readLine()) != null && (line.startsWith("#") || line.isEmpty())) {
            // Copy all non-command lines
            writer.println(line);
        }

        if (line == null) {
            return null;
        }

        // Extract command + argument
        String command = line.substring(1, line.indexOf(']'));
        String argument = line.substring(line.indexOf(']') + 1).trim();

        // Copy command line if command is not one of the answer commands
        List<String> noCopy = Arrays.asList("answ-q", "answ-r", "answer", "answ-a", "answ-b", "answ-d");
        if (!noCopy.contains(command)) {
            writer.println(line);
        } else {
            // Make space for the answer
            writer.printf("[%s] ", command);
        }

        return new Command(command, argument);
    }
    
    /**
     * Print a string with a linebreak at the end.
     */
    void print(String str) {
        writer.println(str);
    }

}
