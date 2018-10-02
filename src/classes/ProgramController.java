package classes;

import java.io.*;
import java.util.Arrays;

public class ProgramController {

    /**
     * Parses the commands in the input file and writes answers to the output file.
     */
    public void run(String inputFile, String outputFile) throws FileNotFoundException, IOException {
        // Create IO
        Reader reader = new FileReader(inputFile);
        Writer writer = new FileWriter(outputFile);
        IO io = new IO(reader, writer);

        // Process commands
        Command command;
        while ((command = io.next()) != null) {
            Logger.log("processing the following command: %s", command);
        }

        // Close files
        reader.close();
        writer.close();
    }

    /**
     * Parses the command line arguments.
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Argument default values
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        boolean verbose = false;

        // Help text
        String help = String.format("Possible arguments:\n" +
                "    -h       prints this help text and exits\n" +
                "    -v       prints debug output\n" +
                "    -i file  reads from given input file (default: input.txt)\n" +
                "    -o file  writes output to given file (default: output.txt)\n");


        // Process arguments
        for (int i=0; i<args.length; i++) {
            String arg = args[i];
            if (arg.equals("-h")) {
                // Print help text
                System.out.print(help);
                return;
            } else if (arg.equals("-v")) {
                // Verbosity
                verbose = true;
            } else if (arg.equals("-i")) {
                // Input file
                i++;
                inputFile = args[i];
            } else if (arg.equals("-o")) {
                // Output file
                i++;
                outputFile = args[i];
            }
        }

        // Set verbosity
        Logger.verbose = verbose;

        // Debug output
        Logger.log("input file: %s, output file: %s", inputFile, outputFile);

        // Run the program
        new ProgramController().run(inputFile, outputFile);
    }
}
