package classes;

import classes.polynomial.Divider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Helper class with static methods for polynomials.
 */
public class Polynomial {
    public static final List<Integer> ZERO = Arrays.asList(0);
    public static final List<Integer> ONE = Arrays.asList(1);

    /**
     * Removes leading zeros in-place.
     */
    public static void removeLeadingZeros(List<Integer> polynomial) {
        // Remove leading zeros
        while (polynomial.size() > 1 && polynomial.get(polynomial.size() - 1) == 0) {
            polynomial.remove(polynomial.size() - 1);
        }
        // Add zero element if array is empty
        if (polynomial.isEmpty()) {
            polynomial.add(0);
        }
    }

    /**
     * Returns a random polynomial of given degree.
     */
    public static List<Integer> random(int degree, int mod) {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < degree; i++) {
            // Generate a random coefficient between 0 (inclusive) and mod (exclusive)
            int coefficient = random.nextInt(mod);
            result.add(coefficient);
        }

        // Make sure that the leading coefficient is random between 1 (inclusive) and mod (exclusive)
        result.add(random.nextInt(mod - 1) + 1);

        return result;
    }

    /**
     * Reduces and also fixes representation. Returns the result.
     */
    public static List<Integer> reduce(List<Integer> polynomial, int mod) {
        // Make a copy
        polynomial = new ArrayList<>(polynomial);

        // Reduce
        for (int i = 0; i < polynomial.size(); i++) {
            int temp = polynomial.get(i) % mod;
            temp = (temp < 0) ? temp + mod : temp;
            polynomial.set(i, temp);
        }

        // Fix representation
        removeLeadingZeros(polynomial);

        // Return
        return polynomial;
    }

    /**
     * Checks if a polynomial is equal to zero.
     */
    public static boolean isZero(List<Integer> polynomial) {
        checkRepresentation(polynomial);
        return polynomial.equals(ZERO);
    }


    private static void checkRepresentation(List<Integer> polynomial) {
        // Check if the array is not empty
        if (polynomial.isEmpty()) {
            throw new IllegalStateException("Polynomial representation invalid (empty array).");
        }
        // Check if it is doesn't have leading zeros
        if (polynomial.size() > 1 && polynomial.get(polynomial.size() - 1) == 0) {
            throw new IllegalStateException("Polynomial representation invalid (it has leading zeros).");
        }
    }

    /**
     * Returns the degree for a polynomial. Returns -1 for the zero polynomial.
     */
    public static int degree(List<Integer> polynomial) {
        checkRepresentation(polynomial);

        if (Polynomial.isZero(polynomial)) {
            return -1;
        } else {
            return polynomial.size() - 1;
        }
    }

    public static int leadingCoefficient(List<Integer> polynomial) {
        checkRepresentation(polynomial);

        int degree = degree(polynomial);
        if (degree == -1) {
            return 0;
        } else {
            return polynomial.get(degree);
        }
    }
}
