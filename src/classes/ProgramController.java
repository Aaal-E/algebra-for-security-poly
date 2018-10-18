package classes;

import classes.field.Arithmetic;
import classes.field.Inverse;
import classes.field.Primitive;
import classes.field.TableGenerator;
import classes.polynomial.Adder;
import classes.polynomial.Divider;
import classes.polynomial.Euclid;
import classes.polynomial.Euclid.Result;
import classes.polynomial.Irreducible;
import classes.polynomial.Multiplier;

import java.io.*;
import java.util.List;

public class ProgramController {

    private int mod;
    private String computation;
    private boolean computationDone;
    private List<Integer> f;
    private List<Integer> g;
    private List<Integer> h;
    private String answer;
    private String answQ;
    private String answR;
    private String answA;
    private String answB;
    private String answD;
    private int deg;
    private List<Integer> modPoly;
    private List<Integer> a;
    private List<Integer> b;

    /**
     * Parses the commands in the input file and writes answers to the output file.
     */
    private void run(String inputFile, String outputFile) throws IOException {
        // Create IO
        Reader reader = new FileReader(inputFile);
        Writer writer = new FileWriter(outputFile);
        IO io = new IO(reader, writer);

        try {
            // Process commands
            Command command;
            while ((command = io.next()) != null) {
                Logger.log("processing the following command: %s", command);
                process(command, io);
            }
        } catch (Exception e) {
            // Make sure that files are also closed during an exception.
            reader.close();
            writer.close();
            throw e;
        }

        // Close files
        reader.close();
        writer.close();
    }

    private void process(Command command, IO io) {
        switch (command.command) {
            case "mod":
                mod = Integer.parseInt(command.argument);

                // New computation, resetting all variables
                computation = null;
                computationDone = false;
                f = null;
                g = null;
                h = null;
                answer = null;
                answQ = null;
                answR = null;
                answA = null;
                answB = null;
                answD = null;
                deg = -1;
                modPoly = null;
                a = null;
                b = null;

                break;
            case "display-poly":
            case "add-poly":
            case "subtract-poly":
            case "multiply-poly":
            case "long-div-poly":
            case "euclid-poly":
            case "equals-poly-mod":
            case "irreducible":
            case "find-irred":
            case "add-table":
            case "mult-table":
            case "display-field":
            case "add-field":
            case "subtract-field":
            case "multiply-field":
            case "inverse-field":
            case "division-field":
            case "equals-field":
            case "primitive":
            case "find-prim":
                computation = command.command;
                break;
            case "f":
                f = Formatter.toPoly(command.argument);
                break;
            case "g":
                g = Formatter.toPoly(command.argument);
                break;
            case "h":
                h = Formatter.toPoly(command.argument);
                break;
            case "answer":
            case "answ-q":
            case "answ-r":
            case "answ-a":
            case "answ-b":
            case "answ-d":
                // Compute
                computeAnswer();
                // Print result
                io.print(getAnswer(command.command));
                break;
            case "deg":
                deg = Integer.parseInt(command.argument);
                break;
            case "mod-poly":
                modPoly = Formatter.toPoly(command.argument);
                break;
            case "a":
                a = Formatter.toPoly(command.argument);
                break;
            case "b":
                b = Formatter.toPoly(command.argument);
                break;

        }
    }

    /**
     * Computes the answer for a computation using the class fields data.
     */
    private void computeAnswer() {
        if (computationDone) {
            Logger.log("computeAnswer(): skipping since it has already been computed");
            return;
        }
        Logger.log("computeAnswer(): computing for computation %s", computation);

        switch (computation) {
            case "display-poly":
                answer = Formatter.toString(Polynomial.reduce(f, mod));
                break;

            case "add-poly":
                answer = Formatter.toString(new Adder().add(f, g, mod));
                break;

            case "subtract-poly":
                answer = Formatter.toString(new Adder().subtract(f, g, mod));
                break;

            case "multiply-poly":
                answer = Formatter.toString(new Multiplier().multiply(f, g, mod));
                break;

            case "long-div-poly":
                Divider.Result result = new Divider().divide(f, g, mod);
                if (result == null) {
                    answQ = "ERROR";
                    answR = "ERROR";
                } else {
                    answQ = Formatter.toString(result.q);
                    answR = Formatter.toString(result.r);
                }
                break;

            case "euclid-poly":
                
                Result r = new Euclid().euclid(f,g,mod);
                answA = Formatter.toString(r.a);
                answB = Formatter.toString(r.b);
                answD = Formatter.toString(r.d);
                break;
            case "equals-poly-mod":
                answer = (Field.polyequals(f,g,h,mod))? "TRUE":"FALSE";
                break;
            case "irreducible":
                answer = (new Irreducible().isIrreducible(f, mod))? "TRUE":"FALSE";
                break;
            case "find-irred":
                answer = Formatter.toString(new Irreducible().findIrreducible(deg, mod));
                break;
            case "add-table":
                answer = Formatter.tableToString(new TableGenerator().createAddTable(modPoly, mod));
                break;
            case "mult-table":
                answer = Formatter.tableToString(new TableGenerator().createMulTable(modPoly, mod));
                break;
            case "display-field":
                answer = Formatter.toString(Field.reduce(a, modPoly, mod));
                break;
            case "add-field":
                answer = Formatter.toString(new Arithmetic().add(a, b, modPoly, mod));
                break;
            case "subtract-field":
                answer = Formatter.toString(new Arithmetic().subtract(a, b, modPoly, mod));
                break;
            case "multiply-field":
                answer = Formatter.toString(new Arithmetic().multiply(a, b, modPoly, mod));
                break;
            case "inverse-field":
                answer = Formatter.toString(new Inverse().findInverse(a, modPoly, mod));
                break;
            case "division-field":
                answer = Formatter.toString(new Arithmetic().div(a, b, modPoly, mod));
                break;
            case "equals-field":
                answer = (Field.polyequals(a,b,modPoly,mod))? "TRUE":"FALSE";
                break;
            case "primitive":
                answer = (new Primitive().isPrimitive(a, modPoly, mod))? "TRUE":"FALSE";
                break;
            case "find-prim":
                answer = Formatter.toString(new Primitive().findPrimitive(modPoly, mod));
        }

        computationDone = true;
    }

    /**
     * Returns the answer variable corresponding to given command.
     */
    private String getAnswer(String command) {
        switch (command) {
            case "answer":
                return answer;
            case "answ-q":
                return answQ;
            case "answ-r":
                return answR;
            case "answ-a":
                return answA;
            case "answ-b":
                return answB;
            case "answ-d":
                return answD;
        }
        throw new IllegalArgumentException("Unknown command");
    }

    /**
     * Parses the command line arguments.
     */
    public static void main(String[] args) throws IOException {
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
