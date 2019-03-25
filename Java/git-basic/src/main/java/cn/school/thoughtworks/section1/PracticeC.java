package cn.school.thoughtworks.section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PracticeC {
    List<String> collectSameElements(List<String> collection1, Map<String,List<String>> collection2) {

        List<String> list = collection2.get("value");

        List<String> result = new ArrayList<>(collection1);
        List<String>  temp = new ArrayList<>(collection1);

        temp.removeAll(list);
        result.removeAll(temp);

        return result;
    }
}
