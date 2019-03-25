package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
//        throw new NotImplementedException();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result.add(array[i][j]);
            }
        }
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
//        throw new NotImplementedException();
        Set<Integer> temp = new LinkedHashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                temp.add(array[i][j]);
            }
        }
        for (Integer i : temp) {
            result.add(i);
        }
        return result;
    }
}
