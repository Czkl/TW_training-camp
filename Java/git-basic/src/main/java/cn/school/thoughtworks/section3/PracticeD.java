package cn.school.thoughtworks.section3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeD {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {
        Map<String,Integer> collectionC = new HashMap<>();

        // 统计collectionA 得到collectionC
        for (int i = 0; i < collectionA.size(); i++) {
            String letter = collectionA.get(i).trim();
            int time = 1; // 次数加+1
            if (letter.length() > 1) {
                time = Integer.parseInt(letter.charAt(letter.length() - 1)+"");
                letter = letter.charAt(0) + "";
            }
            if (collectionC.containsKey(letter)) {
                collectionC.put(letter, (collectionC.get(letter) + time));
            }
            else {
                collectionC.put(letter, time);
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
