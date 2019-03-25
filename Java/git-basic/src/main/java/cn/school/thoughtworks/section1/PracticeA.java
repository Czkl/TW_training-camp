package cn.school.thoughtworks.section1;

import java.util.ArrayList;
import java.util.List;

public class PracticeA {
    List<String> collectSameElements(List<String> collection1, List<String> collection2) {

        List<String> result = new ArrayList<>(collection1);
        List<String>  temp = new ArrayList<>(collection1);

        temp.removeAll(collection2);
        result.removeAll(temp);

        System.out.println(result);
        return result;
    }
}
