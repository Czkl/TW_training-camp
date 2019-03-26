package com.thoughtworks.collection;

import java.util.Collections;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
//        throw new NotImplementedException();
        Collections.sort(arrayList);
        return arrayList.get(arrayList.size() - 1);
    }

    public double getMinimum() {
//        throw new NotImplementedException();

        Collections.sort(arrayList);
        return arrayList.get(0);
    }

    public double getAverage() {
//        throw new NotImplementedException();
        double sum = 0;

        for (Integer integer : arrayList) {
            sum += integer;
        }

        return sum / arrayList.size();
    }

    public double getOrderedMedian() {
//        throw new NotImplementedException();
        Collections.sort(arrayList);
        int len = arrayList.size();

        if (len % 2 != 0) {
            return arrayList.get((len - 1) / 2);
        } else {
            double temp1 = (double) arrayList.get(len / 2);
            double temp2 = (double) arrayList.get(len / 2 - 1);
            return (temp1 + temp2) / 2;
        }
    }

    public int getFirstEven() {
//        throw new NotImplementedException();
        int result = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                result =  arrayList.get(i);
                break;
            }
        }
        return result;
    }

    public int getIndexOfFirstEven() {
//        throw new NotImplementedException();
        int result = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                result =  i;
                break;
            }
        }
        return result;
    }


    public boolean isEqual(List<Integer> arrayList) {
//        throw new NotImplementedException();
        boolean flag = true;
        if (this.arrayList.size() != arrayList.size()) {
            flag = false;
        } else {
            for (Integer i : this.arrayList) {
                if (arrayList.contains(i)) {
                    continue;
                } else {
                    flag = false;
                }
            }
        }
        return flag;
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
//        throw new NotImplementedException();
        int len = arrayList.size();
        if (len % 2 != 0) {
            double temp3 = arrayList.get((len - 1) / 2);
            return temp3;
        } else {
            double temp1 = (double) arrayList.get(len / 2);
            double temp2 = (double) arrayList.get(len / 2 - 1);
            return (temp1 + temp2) / 2;
        }

    }

    public int getLastOdd() {
//        throw new NotImplementedException();
        Integer result = -1;
        for (int i = arrayList.size() -1 ; i >= 0; i--) {
            if (arrayList.get(i) % 2 != 0) {
                result = arrayList.get(i);
                break;
            }
        }
        return result;
    }

    public int getIndexOfLastOdd() {
//        throw new NotImplementedException();
        int result = -1;
        for (int i = arrayList.size() -1 ; i >= 0; i--) {
            if (arrayList.get(i) % 2 != 0) {
                result = i;
                break;
            }
        }
        return result;
    }
}
