package classes;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class InputFileTest {

    @Test
    public void inputFileTest() throws Exception {
        // Working directory is assumed to be the main directory with group35input.txt

        // Run the program
        ProgramController.main("-v -i group35input.txt".split(" "));

        // Get expected output
        String expected = getExpectedOutput();

        // Get actual output
        String actual = getActualOutput();

        // Compare
        assertEquals(expected, actual);
    }

    /**
     * Constructs the expected output file from the annotated input file.
     */
    private String getExpectedOutput() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("group35input.txt"));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            // Copy line to output
            builder.append(line);
            builder.append("\n");
            // Add expected answer to output
            if (line.startsWith("# expect ")) {
                builder.append(line.substring(9));
                builder.append("\n");
                // Skip next line
                reader.readLine();
            }
        }
        reader.close();
        return builder.toString();
    }

    /**
     * Reads the actual output.txt.
     */
    private String getActualOutput() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append("\n");
        }
        reader.close();
        return builder.toString();
    }
}
