package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
//        throw new NotImplementedException();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 == 0) {
                result.add(array.get(i));
            }
        }
        return result;
    }


    public List<Integer> filterMultipleOfThree() {
//        throw new NotImplementedException();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 3 == 0) {
                result.add(array.get(i));
            }
        }
        return result;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
//        throw new NotImplementedException();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < firstList.size(); i++) {

            if (secondList.contains(firstList.get(i))) {
                result.add(firstList.get(i));
            }
        }
        return result;
    }


    public List<Integer> getDifferentElements() {
//        throw new NotImplementedException();
        Set<Integer> temp = new HashSet<>();
        for (Integer i : array) {
            temp.add(i);
        }
        List<Integer> result = new ArrayList<>();
        for (Integer i : temp) {
            result.add(i);
        }
        return result;
    }
}