package classes;

import java.util.*;

public class Formatter {
    public static String toString(List<Integer> poly) {
        if (Polynomial.isZero(poly)) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        for (int i = poly.size() - 1; i >= 0; i--) {
            int n = poly.get(i);

            // Skip 0 terms
            if (n == 0) {
                continue;
            }

            // Add + if it should be printed (positive n)
            if (result.length() > 0 && n >= 0) {
                result.append("+");
            }

            // Add number if it should be printed
            if (i == 0 || (n != 1 && n != -1)) {
                result.append(n);
            } else if (n == -1) {
                result.append("-");
            }

            // Add X^i
            if (i > 0) {
                result.append("X");
                if (i > 1) {
                    result.append("^");
                    result.append(i);
                }
            }
        }



        return result.toString();
    }

    public static List<Integer> toPoly(String str) {
        List<Integer> result = new ArrayList<Integer>();
        if (str.contains("{")) {
            str = str.substring(1, str.length() - 1);
            while (!str.equals("")) {
                int nextNum = 0;
                if (str.contains(","))
                    nextNum = str.indexOf(",");
                else nextNum = str.length();
                result.add(0, Integer.parseInt(str.substring(0, nextNum)));
                if (str.contains(","))
                    str = str.substring(nextNum + 1);
                else str = str.substring(nextNum);
            }
        } else {
            int degree = 0;
            if (str.contains("^")) {
                int endOfFirstPower;
                int beginOfFirstPower = str.indexOf("^") + 1;
                if (str.contains("+") && str.contains("-"))
                    if (str.indexOf("+") < str.indexOf("-", 1))
                        endOfFirstPower = str.indexOf("+");
                    else
                        endOfFirstPower = str.indexOf("-", 1);
                else if (str.contains("+"))
                    endOfFirstPower = str.indexOf("+");
                else if (str.indexOf("-", 1) > 0)
                    endOfFirstPower = str.indexOf("-", 1);
                else endOfFirstPower = str.length();
                degree = Integer.parseInt(str.substring(beginOfFirstPower, endOfFirstPower));
            } else if (str.contains("X")) {
                degree = 1;
            } else degree = 0;
            for (int i = 0; i <= degree; i++) {
                result.add(0);
            }

            int beginOfPower = 0;
            int endOfPower = 0;
            String temp = "";
            while (str.contains("^")) {
                beginOfPower = str.indexOf("^") + 1;
                if (str.contains("+") && (str.indexOf("-", 1) > 0))
                    if (str.indexOf("+") < str.indexOf("-", 1))
                        endOfPower = str.indexOf("+");
                    else
                        endOfPower = str.indexOf("-", 1);
                else if (str.contains("+"))
                    endOfPower = str.indexOf("+");
                else if (str.indexOf("-", 1) > 0)
                    endOfPower = str.indexOf("-", 1);
                else endOfPower = str.length();
                int power = Integer.parseInt(str.substring(beginOfPower, endOfPower));
                temp = str.substring(0, str.indexOf("X"));
                if (temp.equals("-"))
                    result.set(power, -1);
                else if (temp.equals(""))
                    result.set(power, 1);
                else
                    result.set(power, Integer.parseInt(temp));
                str = str.substring(endOfPower);
                if (str.indexOf("+") == 0)
                    str = str.substring(1);
            }
            if (str.contains("X")) {
                if (str.contains("+") && (str.indexOf("-", 1) > 0))
                    if (str.indexOf("+") < str.indexOf("-", 1))
                        endOfPower = str.indexOf("+");
                    else
                        endOfPower = str.indexOf("-", 1);
                else if (str.contains("+"))
                    endOfPower = str.indexOf("+");
                else if (str.indexOf("-", 1) > 0)
                    endOfPower = str.indexOf("-", 1);
                else endOfPower = str.length();

                temp = str.substring(0, str.indexOf("X"));
                if (temp.equals("-"))
                    result.set(1, -1);
                else if (temp.isEmpty())
                    result.set(1, 1);
                else
                    result.set(1, Integer.parseInt(temp));
                str = str.substring(endOfPower);
                if (str.indexOf("+") == 0)
                    str = str.substring(1);
            }
            if (!str.equals("")) {
                result.set(0, Integer.parseInt(str));
            }
        }
        return result;
    }

    public static String tableToString(List<List<List<Integer>>> table) {
        StringBuilder builder = new StringBuilder();
        builder.append("{");

        boolean firstRow = true;
        for (List<List<Integer>> row : table) {
            // Join string
            if (!firstRow) {
                builder.append("; ");
            } else {
                firstRow = false;
            }

            boolean firstCell = true;
            for (List<Integer> cell : row) {
                // Join string
                if (!firstCell) {
                    builder.append(", ");
                } else {
                    firstCell = false;
                }

                builder.append(toString(cell));
            }
        }

        builder.append("}");
        return builder.toString();
    }
}
