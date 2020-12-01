package com.learn.kmp.v1;

public class Solution {

    public static void main(String[] args) {
        String mainStr = "BCDABCD";
        String m = "ABCDABCD";
        final int index = new Solution().violentMatchSelf(mainStr, m);
        System.out.println("final index:" + index);
    }

    private int violentMatch(String s, String p) {
        final int index = s.indexOf(p);
        System.out.println("index:" + index);
        return index;
    }


    private int violentMatchSelf(String s, String p) {
        final char[] sChar = s.toCharArray();
        final char[] pChar = p.toCharArray();
        int index = -1;
        if (sChar.length < pChar.length) {
            return index;
        }
        for (int i = 0; i < sChar.length; i++) {
            index = i;
            int j;
            for (j = 0; j < pChar.length; j++) {
                if (sChar[i] != pChar[j]) {
                    break;
                }
                ++i;
            }

            if (j == pChar.length) {
                break;
            }
        }

        if (index > sChar.length - pChar.length) {
            index = -1;
        }

        return index;
    }
}
