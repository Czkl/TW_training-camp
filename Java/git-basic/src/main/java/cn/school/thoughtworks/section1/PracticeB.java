package cn.school.thoughtworks.section1;

import java.util.ArrayList;
import java.util.List;

public class PracticeB {
    List<String> collectSameElements(List<String> collection1, List<List<String>> collection2) {

        List<String> result = new ArrayList<>(collection1);
        List<String> temp = new ArrayList<>(collection1);

        List<String> mergeCollection2 = collection2.get(0);
        for (int i = 1; i < collection2.size(); i++) {
            mergeCollection2.removeAll(collection2.get(i));
            mergeCollection2.addAll(collection2.get(i));
        }

        temp.removeAll(mergeCollection2);
        result.removeAll(temp);

        return result;
    }
}
