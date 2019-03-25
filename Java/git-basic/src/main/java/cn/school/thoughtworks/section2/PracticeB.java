package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeB {
    Map<String, Integer> countSameElements(List<String> collection1) {

        Map<String,Integer> result = new HashMap<>();

        for (int i = 0; i < collection1.size(); i++) {
            String letter = collection1.get(i).trim();
            int time = 1; // 次数加+1
            if (letter.length() > 1) {
                time = Integer.parseInt(letter.charAt(letter.length() - 1)+"");
                letter = letter.charAt(0) + "";
            }
            if (result.containsKey(letter)) {
                result.put(letter, (result.get(letter) + time));
            }
            else {
                result.put(letter, time);
            }
        }

        return result;
    }
}
