package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
        List<Integer> lList = new ArrayList<>();
        lList.add(4);
        lList.add(1);
        lList.add(7);
        lList.add(2);
        lList.add(9);
        lList.add(1);
        lList.add(5);

        Collections.sort(lList);
        System.out.println(lList);
    }
}