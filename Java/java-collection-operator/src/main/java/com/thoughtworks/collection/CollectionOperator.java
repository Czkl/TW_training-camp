package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
//        throw new NotImplementedException();
        List<Integer> result = new ArrayList<>();

        if (left < right) {
            for (int i = left; i <= right; i++) {
                result.add(i);
            }
        } else {
            for (int i = left; i >= right; i--) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
//        throw new NotImplementedException();
        List<Integer> result = new ArrayList<>();

        if (left < right) {
            for (int i = left; i <= right; i++) {
                if (i % 2 == 0) {
                    result.add(i);
                }
            }
        } else {
            for (int i = left; i >= right; i--) {
                if (i % 2 == 0) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    public List<Integer> popEvenElments(int[] array) {
//        throw new NotImplementedException();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                result.add(array[i]);
            }
        }
        return result;
    }

    public int popLastElment(int[] array) {
//        throw new NotImplementedException();
        int result = array[array.length - 1];

        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, array.length - 1);

        return result;
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
//        throw new NotImplementedException();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < firstArray.length; i++) {
            list1.add(firstArray[i]);
        }
        for (int i = 0; i < secondArray.length; i++) {
            list2.add(secondArray[i]);
        }
        list1.retainAll(list2);
        return list1;
        
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
//        throw new NotImplementedException();


        List<Integer> list1 = Arrays.asList(firstArray);
        List<Integer> list2 = Arrays.asList(secondArray);

        List<Integer> result = new ArrayList<>(list1);
        for (Integer i : list2)

            if (!list1.contains(i)) {
                result.add(i);
            }
        return result;
    }
}
