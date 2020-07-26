package com.neha.rickandmorty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test13 {
    public static ArrayList<String> cost = new ArrayList<>();
    public static ArrayList<Integer> finalCostList = new ArrayList<>();

    public static int k = 2;
    public static int finalCost = 0;
    public static int minvalofCost = 0;
    public static int minValIndex = 0;


    public static int sumoftwonos = 0;

    public static void main(String[] args) {
        Integer[] input = {1,2,3};
        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(input));

       while(array.size()>1){testfunc(array);}

        getCost(finalCostList);

    }

    public static ArrayList<Integer> testfunc(ArrayList<Integer> array) {
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            if (array.size() > 1) {
            if (i != array.size() - 1) {
                HashMap<String, String> hashmap = new HashMap<>();

                sumoftwonos = array.get(i) + array.get(i + 1);
                hashmap.put("firstindex", array.get(i) + "");
                hashmap.put("secondindex", array.get(i + 1) + "");
                hashmap.put("cost", sumoftwonos * k + "");
                hashmap.put("sumofnos", sumoftwonos + "");
                arrayList.add(hashmap);
                System.out.println("hashmap" + arrayList);
            }
        }}

        minvalofCost = Integer.parseInt(arrayList.get(0).get("cost"));
        minValIndex = 0;
        System.out.println("array " + array);

        for (int j = 0; j < arrayList.size(); j++) {

            if (Integer.parseInt(arrayList.get(j).get("cost")) < minvalofCost) {
                minvalofCost = Integer.parseInt(arrayList.get(j).get("cost"));
                minValIndex = j;
            }


        }
        System.out.println("minvalueofcost " + minvalofCost + " index " + minValIndex);

        array.remove(minValIndex);
        array.remove(minValIndex);
        finalCostList.add(Integer.parseInt(arrayList.get(minValIndex).get("cost")));
        if(array.size()>0) {
            array.add(minValIndex, Integer.parseInt(arrayList.get(minValIndex).get("sumofnos")));
        }


        System.out.println("array " + array);
        System.out.println("finalcostlist " + finalCostList);


        return array;

    }

    public static int getCost(ArrayList<Integer> finalCostList) {
        for (int j = 0; j < finalCostList.size(); j++) {
            finalCost = finalCost + (finalCostList.get(j));
        }
        System.out.println("finalcost "+ finalCost);
        return finalCost;
    }
}