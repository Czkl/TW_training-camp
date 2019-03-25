package cn.school.thoughtworks.section3;

import java.util.List;
import java.util.Map;

public class PracticeB {
    Map<String,Integer> createUpdatedCollection(Map<String,Integer> collectionA, Map<String,List<String>> object) {

        List<String> list = object.get("value");

        for (int i = 0; i < list.size(); i++) {
            String t = list.get(i);
            if (collectionA.containsKey(t)) {
                int num = collectionA.get(t);
                collectionA.put(t, num - (num / 3));
            }
        }

        return collectionA;
    }
}
