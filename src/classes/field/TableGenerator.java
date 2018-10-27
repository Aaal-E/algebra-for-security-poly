package classes.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classes.Field;
import classes.Polynomial;
import classes.polynomial.Adder;
import classes.polynomial.Divider;
import classes.polynomial.Multiplier;

public class TableGenerator {
    Adder adder = new Adder();
    Multiplier multiplier = new Multiplier();

    public List<List<List<Integer>>> createAddTable(List<Integer> characteristic, int mod) {
        List<List<Integer>> elements = getElements(characteristic, mod);

        List<List<List<Integer>>> table = new ArrayList<>();
        for (List<Integer> rowElement : elements) {
            List<List<Integer>> row = new ArrayList<>();
            for (List<Integer> columnElement : elements) {
                // Addition
                List<Integer> cell = adder.add(rowElement, columnElement, mod);
                row.add(cell);
            }
            table.add(row);
        }
        return table;
    }

    public List<List<List<Integer>>> createMulTable(List<Integer> characteristic, int mod) {
        List<List<Integer>> elements = getElements(characteristic, mod);

        List<List<List<Integer>>> table = new ArrayList<>();
        for (int i = 0; i < (characteristic.size() - 1) * mod; i++) {
            List<List<Integer>> row = new ArrayList<>();
            for (int j = 0; j < (characteristic.size() - 1) * mod; j++) {
                // Multiply
                List<Integer> cell = multiplier.multiply(elements.get(i), elements.get(j), mod);
                // Reduce
                cell = Field.reduce(cell, characteristic, mod);
                // Store
                row.add(cell);
            }
            table.add(row);
        }
        return table;
    }

    /**
     * Finds the elements for a characteristic with given mod.
     */
    private List<List<Integer>> getElements(List<Integer> characteristic, int mod) {
        List<List<Integer>> elements = new ArrayList<>();
        for (int i = 0; i < characteristic.size() - 1; i++) {
            for (int j = 0; j < mod; j++) {
                List<Integer> element = new ArrayList<>(Arrays.asList(j, i));
                Polynomial.removeLeadingZeros(element);
                elements.add(element);
            }
        }
        return elements;
    }

}
