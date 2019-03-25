package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeA {
    Map<String,Integer> countSameElements(List<String> collection1) {

        Map<String,Integer> result = new HashMap<>();

        for (int i = 0; i < collection1.size(); i++) {
            String temp = collection1.get(i);
            if (result.containsKey(temp)) {
                result.put(temp, result.get(temp) + 1);
            }
            else {
                result.put(temp, 1);
            }
        }

        return result;
    }
}
