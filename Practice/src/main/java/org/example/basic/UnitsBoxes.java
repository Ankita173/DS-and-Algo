package org.example.basic;

import java.util.Arrays;
import java.util.List;

public class UnitsBoxes {

    public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
        long unit = 0;
        System.out.println("boxes "+boxes);
        System.out.println("boxeunits "+unitsPerBox);
        System.out.println("size "+truckSize);
        for(int i = 0; i < boxes.size() || truckSize > 0; i++) {
            long boxCount = boxes.get(i);
            long boxUnit = unitsPerBox.get(i);
            while (truckSize > 0 && boxCount > 0) {
                unit += boxUnit;
                boxCount--;
                truckSize--;
            }
        }
        return unit;
    }


    public static void main(String[] args) {
        List<Long> boxes = Arrays.asList(1l, 2l, 3l);
        List<Long> unitsPerBoxes = Arrays.asList(3l, 2l, 1l);
        long tructSize = 3;
        System.out.println(getMaxUnits(boxes, unitsPerBoxes, tructSize));

        boxes = Arrays.asList(1l, 1l);
        unitsPerBoxes = Arrays.asList(9l, 6l);
        tructSize = 1;
        System.out.println(getMaxUnits(boxes, unitsPerBoxes, tructSize));
    }
}
