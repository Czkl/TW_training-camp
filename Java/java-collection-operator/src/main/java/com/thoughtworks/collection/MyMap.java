package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
//        throw new NotImplementedException();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            result.add(array.get(i) * 3);
        }
        return result;
    }

    public List<String> mapLetter() {
//        throw new NotImplementedException();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            String temp = "";
            int c = array.get(i) % 26;
            temp = (char)(c + 49+48-1) + "" ;
            result.add(temp);
        }
        return result;
    }

    public List<String> mapLetters() {
//        throw new NotImplementedException();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            StringBuilder t = new StringBuilder();
            String temp = "";
            int n = array.get(i) /26;
            int c = array.get(i) % 26;
            if (c == 0 && n > 1) {
                temp = (char)(c + 49+48-1+26) + "" ;
            }
            else {
                temp = (char)(c + 49+48-1) + "" ;
            }
            t.append(temp);
            while (n >= 26) {
                n = n / 26;
                c = n % 26;
                if (c == 0 && n > 1) {
                    temp = (char)(c + 49+48-1+26) + "" ;
                }
                else {
                    temp = (char)(c + 49+48-1) + "" ;
                }
                t.append(temp);
            }
            if (n > 0) {
                 temp = (char)(n + 49+48-1)+"" ;
                if (c == 0) {
                    temp = (char)(n + 49+48-1-1)+"" ;
                }

                t.append(temp);
            }
            result.add(t.reverse().toString());
        }
        return result;
    }

    public List<Integer> sortFromBig() {
//        throw new NotImplementedException();

        array.sort((o1, o2) -> {
            if (o1 >= o2) return -1;
            else return 1;});
        return array;
    }

    public List<Integer> sortFromSmall() {
//        throw new NotImplementedException();
        array.sort((o1, o2) -> {
            if (o1 >= o2) return 1;
            else return -1;});
        return array;
    }
}
