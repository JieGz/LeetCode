package com.learn.kmp.v2;

//还有KMP,BM,Sunday算法,效率一个比一个高
public class Solution {
    public static void main(String[] args) {
        String mainStr = "ABC ABCDABCD";
        String m = "ABCDABCD";
        System.out.println(new Solution().violentMatch(mainStr, m));
    }


    private int violentMatch(String s, String p) {
        final char[] sChar = s.toCharArray();
        final char[] pChar = p.toCharArray();
        int index = -1;

        int i = 0, j = 0;

        while (i < sChar.length && j < pChar.length) {
            if (sChar[i] == pChar[j]) {
                ++i;
                ++j;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == pChar.length) {
            index = i - j;
        }

        return index;
    }
}
