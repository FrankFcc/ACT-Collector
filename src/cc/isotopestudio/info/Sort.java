/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.isotopestudio.info;

import cc.isotopestudio.data.Score;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mac
 */
public class Sort {

    public static void sortByComposite(ArrayList<Score> score) {
        for (int i = 0; i < score.size(); i++) {
            int min = i;
            /* 将当前下标定义为最小值下标 */

            for (int j = i + 1; j < score.size(); j++) {
                if (score.get(min).getComposite() > score.get(j).getComposite()) {
                    /* 如果有小于当前最小值的关键字 */
                    min = j;
                    /* 将此关键字的下标赋值给min */
                }
            }
            if (i != min) {/* 若min不等于i，说明找到最小值，交换 */
                Score temp = score.get(min);
                score.set(min, score.get(i));
                score.set(i, temp);
            }
        }
    }

    public static void _choiceSort(Integer[] a) {
        if (a == null || a.length <= 0) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            int min = i;
            /* 将当前下标定义为最小值下标 */

            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    /* 如果有小于当前最小值的关键字 */
                    min = j;
                    /* 将此关键字的下标赋值给min */
                }
            }
            if (i != min) {/* 若min不等于i，说明找到最小值，交换 */
                int tmp = a[min];
                a[min] = a[i];
                a[i] = tmp;
            }
        }
    }
    static String[][] Results = {
        {"61D", "Dec2012", "32", "32", "33", "33", "11", "33"},
        {"62C", "Dec2013", "25", "34", "34", "32", "10", "31"},
        {"63H", "Dec2014", "34", "32", "31", "36", "11", "33"}};

    public static String[][] SequenceEnglish(String[][] a) {
        Arrays.sort(a, (String[] o1, String[] o2) -> {
            String Number1 = o1[2];
            String Number2 = o2[2];
            return Number1.compareTo(Number2);
        });
        return a;
    }

    public static String[][] SequenceMath(String[][] a) {
        Arrays.sort(a, (String[] o1, String[] o2) -> {
            String Number1 = o1[3];
            String Number2 = o2[3];
            return Number1.compareTo(Number2);
        });
        return a;
    }

    public static String[][] SequenceReading(String[][] a) {
        Arrays.sort(a, (String[] o1, String[] o2) -> {
            String Number1 = o1[4];
            String Number2 = o2[4];
            return Number1.compareTo(Number2);
        });
        return a;
    }

    public static String[][] SequenceScience(String[][] a) {
        Arrays.sort(a, (String[] o1, String[] o2) -> {
            String Number1 = o1[5];
            String Number2 = o2[5];
            return Number1.compareTo(Number2);
        });
        return a;
    }

    public static String[][] SequenceComposite(String[][] a) {
        Arrays.sort(a, (String[] o1, String[] o2) -> {
            String Number1 = o1[7];
            String Number2 = o2[7];
            return Number1.compareTo(Number2);
        });
        return a;
    }

    public static String[][] SequenceWriting(String[][] a) {
        Arrays.sort(a, (String[] o1, String[] o2) -> {
            String Number1 = o1[6];
            String Number2 = o2[6];
            return Number1.compareTo(Number2);
        });
        return a;
    }

    public static void main(String[] args) {
        System.out.print("Please enter value: ");
        Scanner sc = new Scanner(System.in);
        String valueEnt = sc.next();
        if (valueEnt.equals("English")) {
            Sort.SequenceEnglish(Results);
            System.out.println(Arrays.deepToString(Results));
        } else if (valueEnt.equals("Math")) {
            Sort.SequenceMath(Results);
            System.out.println(Arrays.deepToString(Results));
        } else if (valueEnt.equals("Reading")) {
            Sort.SequenceReading(Results);
            System.out.println(Arrays.deepToString(Results));
        } else if (valueEnt.equals("Science")) {
            Sort.SequenceScience(Results);
            System.out.println(Arrays.deepToString(Results));
        } else if (valueEnt.equals("Writing")) {
            Sort.SequenceWriting(Results);
            System.out.println(Arrays.deepToString(Results));
        } else if (valueEnt.equals("Composite")) {
            Sort.SequenceComposite(Results);
            System.out.println(Arrays.deepToString(Results));
        } else {
            System.out.println("The value you entered is invalid.");
        }

    }

}
