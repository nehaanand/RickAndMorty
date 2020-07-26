package com.neha.rickandmorty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static ArrayList<Integer> cost = new ArrayList<>();

    public static int k = 3;
    public static int finalCost = 0;

    public static void main(String[] args) {
        Integer[] input = {2,3,1};
        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(input));

        while (array.size() > 1) {
            ArrayList<Integer> test = testfunc(array);

        }
        finalCost = getFinalCost(cost);

    }

    public static ArrayList<Integer> testfunc(ArrayList<Integer> array) {
        int sumoftwonos = 0;

        for (int i = 0; i < array.size(); i++) {
            sumoftwonos = array.get(0) + array.get(1);
        }
//

        array.remove(0);
        array.remove(0);
        array.add(sumoftwonos);
        cost.add(sumoftwonos * k);
        Collections.sort(array);



        return array;

    }

    public static int getFinalCost(ArrayList<Integer> cost) {
        for (int j = 0; j < cost.size(); j++) {
            finalCost = finalCost + (cost.get(j));
        }
        System.out.println(finalCost);
        return finalCost;
    }}