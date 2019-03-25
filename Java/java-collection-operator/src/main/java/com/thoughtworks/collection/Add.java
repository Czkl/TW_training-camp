package com.thoughtworks.collection;

import java.util.*;


public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int result = 0;
        for (int i = Math.min(leftBorder, rightBorder); i <= Math.max(leftBorder, rightBorder); i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
//        throw new NotImplementedException();
        int result = 0;
        for (int i = Math.min(leftBorder, rightBorder); i <= Math.max(leftBorder, rightBorder); i++) {
            if (i % 2 != 0) {
                result += i;
            }
        }
        return result;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
//        throw new NotImplementedException();
        int result = 0;
        for (int i = 0; i < arrayList.size(); i++) {

            result += arrayList.get(i) * 3 + 2;

        }
        return result;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
//        throw new NotImplementedException();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++) {

            if (arrayList.get(i) % 2 != 0) {
                result.add(arrayList.get(i) * 3 + 2);
            } else {
                result.add(arrayList.get(i));
            }
        }
        return result;
    }


    public int getSumOfProcessedOdds(List<Integer> arrayList) {
//        throw new NotImplementedException();

        int result = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 != 0) {
                result += arrayList.get(i) * 3 +5;
            }
        }
        return result;
    }


    public double getMedianOfEven(List<Integer> arrayList) {
//        throw new NotImplementedException();
        double result = 0;

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                temp.add(arrayList.get(i));
            }
        }
        Collections.sort(temp);

        int size = temp.size();
        if (size % 2 != 0) {
            result = temp.get((size-1) / 2);
        } else {
            result = (temp.get(size / 2) + temp.get(size / 2 - 1)) / 2;
        }

        return result;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
//        throw new NotImplementedException();
        double result = 0;
        int count = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                count++;
                result += arrayList.get(i);
            }
        }
        return result / count;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
//        throw new NotImplementedException();
        boolean flag = false;
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                temp.add(arrayList.get(i));
            }
        }

        if (specialElment % 2 == 0) {
            if (temp.contains(specialElment)) {
                flag = true;
            }
        }
        return flag;

    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
//        throw new NotImplementedException();
        Set<Integer> setTemp = new HashSet<>();


        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                setTemp.add(arrayList.get(i));
            }
        }

        List<Integer> result = new ArrayList<>(setTemp);

        return result;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
//        throw new NotImplementedException();
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i : arrayList) {
            if (i % 2 == 0) {
                temp1.add(i);
            } else {
                temp2.add(i);
            }
        }

        Collections.sort(temp1);
        Collections.sort(temp2);
        for (int i : temp1) {
            result.add(i);
        }
        for (int i = temp2.size() - 1; i >= 0; i--) {
            result.add(temp2.get(i));
        }
        return result;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
//        throw new NotImplementedException();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arrayList.size() -1; i++) {

            result.add(3 * (arrayList.get(i) + arrayList.get(i + 1)));
        }

        return result;
    }
}
