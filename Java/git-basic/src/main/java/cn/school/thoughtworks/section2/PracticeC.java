package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeC {
    Map<String, Integer> countSameElements(List<String> collection1) {

        Map<String,Integer> result = new HashMap<>();

        for (int i = 0; i < collection1.size(); i++) {
            String temp = collection1.get(i).trim();
            int time = 1; // 次数加+1
            if (temp.length() > 1) {
                String letter = "";
                for (int j = 0; j < temp.length(); j++) {
                    char p = temp.charAt(j);
                    if (p > 'a' && p < 'z' || p > 'A' && p < 'Z') {
                        letter = p + "";

                    } else if (p >= '1' && p <= '9') {
                        String n = p +"";
                        int k = j + 1;
                        while (k<temp.length() &&temp.charAt(k) >= '0' && temp.charAt(k) <= '9') {
                            n += temp.charAt(k);
                            k++;
                        }
                        time = Integer.parseInt(n);
                    }
                }
                temp = letter;
            }

            if (result.containsKey(temp)) {
                result.put(temp, (result.get(temp) + time));
            }
            else {
                result.put(temp, time);
            }
        }

        return result;
    }
}
