package org.cdrgeek;

import java.util.ArrayList;
import java.util.List;

public class Lee784 {

    public boolean isAlpha(String s) {
        if(s == null) {
            return false;
        }
        char cur = s.charAt(0);
        if((cur >= 'a' && cur <= 'z') || (cur >= 'A' && cur <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }

    // 基础实现版
//    public void backtrace(String out, int index, String src, List<String> ans) {
//        if(out.length() == src.length()) {
//            ans.add(out);
//            return;
//        }
//        String cur = src.substring(index, index + 1);
//        if(isAlpha(cur)) {
//            // alpha
//            String upper_cur = cur.toUpperCase();
//            backtrace(out + upper_cur, index + 1, src, ans);
//            String lower_cur = cur.toLowerCase();
//            backtrace(out + lower_cur, index +1, src, ans);
//        } else {
//            backtrace(out + cur, index + 1, src, ans);
//        }
//    }

    // 优化：减少不必要递归调用
    public void backtrace(String out, int index, String src, List<String> ans) {
        if(out.length() == src.length()) {
            ans.add(out);
            return;
        }
        String cur = src.substring(index, index + 1);
        if(isAlpha(cur)) {
            // alpha
            String upper_cur = cur.toUpperCase();
            backtrace(out + upper_cur, index + 1, src, ans);
            String lower_cur = cur.toLowerCase();
            backtrace(out + lower_cur, index +1, src, ans);
        } else {
            // TODO： 优化
            boolean goon = true;
            do {
                out += cur;
                index ++;
                if (src.length() > index) {
                    cur = src.substring(index, index + 1);
                } else {
                    goon = false;
                }
            } while(goon && !isAlpha(cur));
            backtrace(out, index, src, ans);
        }
    }
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new  ArrayList<String>();
        backtrace("", 0, S, ans);
        return ans;
    }

    public static void main(String args[]) {
        Lee784 lee784 = new Lee784();
        List<String> ans = lee784.letterCasePermutation("a1b2");
        System.out.println(ans);

        List<String> ans2 = lee784.letterCasePermutation("33Bt1");
        System.out.println(ans2);
    }
}
