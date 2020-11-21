package org.cdrgeek;

import java.util.ArrayList;
import java.util.List;

public class Lee78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> out = new ArrayList<Integer>();
        int i = 0;
        backtrace(out, i, nums, ans);
        return ans;
    }

    public  void  copy(List<Integer> src,  List<Integer> dest)
    {
        int  srcStartPos = 0;
        int  srcEndPos = src.size();

        for (int i = srcStartPos; i < srcEndPos; i++)
        {
            dest.add(src.get(i));
        }
    }

    public void backtrace(List<Integer> out, int i, int[] src, List<List<Integer>> ans) {
        if (i == src.length) {
            // 所有选项遍历完成，插入结果值到ans
            List<Integer> tmp = new ArrayList<Integer>();
            copy(out, tmp);
            ans.add(tmp);
            return;
        }
        int cur = src[i];
        // 选择1： 选中当前元素
        i++;
        out.add(cur);
        backtrace(out, i, src, ans);
        // 选择2： 不选择当前元素，回退历史记录
        out.remove(out.size() - 1);
        backtrace(out, i, src, ans);
    }

    public static void main(String args[]) {
        int[] nums = {1,2,3};
        Lee78 lee = new Lee78();
        List<List<Integer>> ans = lee.subsets(nums);
        System.out.println(ans);
    }
}
