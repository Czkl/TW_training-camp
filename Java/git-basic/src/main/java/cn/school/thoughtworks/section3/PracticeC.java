package cn.school.thoughtworks.section3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeC {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {


        // 统计collectionA 形成collectionC
        Map<String,Integer> collectionC = new HashMap<>();

        for (int i = 0; i < collectionA.size(); i++) {
            String temp = collectionA.get(i);
            if (collectionC.containsKey(temp)) {
                collectionC.put(temp, collectionC.get(temp) + 1);
            }
            else {
                collectionC.put(temp, 1);
            }
        }

        List<String> list = object.get("value");

        for (int i = 0; i < list.size(); i++) {
            String t = list.get(i);
            if (collectionC.containsKey(t)) {
                int num = collectionC.get(t);
                collectionC.put(t, num - (num / 3));
            }
        }

        return collectionC;
    }
}
