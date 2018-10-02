package classes;

/**
 * For printing debug output.
 */
public class Logger {
    /**
     * Determines whether to print output or not.
     */
    public static boolean verbose = false;

    public static void log(String msg) {
        if (!verbose) {
            return;
        }
        System.out.println(msg);
    }

    public static void log(String format, Object... args) {
        log(String.format(format, args));
    }
}
