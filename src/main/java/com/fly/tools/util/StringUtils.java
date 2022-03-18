package com.fly.tools.util;

import java.util.Scanner;

/**
 * @author：zhangpengfei
 * @since：2022/3/18
 */
public class StringUtils {
    public static String add(String one, String two) {
        int size = Math.max(one.length(), two.length());
        char[] oc = one.toCharArray();
        char[] tc = two.toCharArray();
        char[] result = new char[size];
        int other = 0;
        for (int i = 0; i < size; i++) {
            int on = 0;
            int tw = 0;
            if (one.length() > i) {
                on = oc[oc.length - i - 1] - '0';
            }
            if (two.length() > i) {
                tw = tc[tc.length - i - 1] - '0';
            }
            int te = on + tw + other;
            result[result.length - i - 1] = (char) (te % 10 + '0');
            other = te / 10;
        }
        String sum = String.valueOf(result);
        return other == 0 ? sum : other + sum;
    }
//
//    public static void main(String[] args) {
//        Solution solution = new AdditiveNumber().new Solution();
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            String s = scanner.nextLine();
//            System.out.println(solution.isAdditiveNumber(s));
//        }
//    }
//
//    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//        public boolean isAdditiveNumber(String num) {
//            int m = 1;
//            while (m < num.length()) {
//                int k = m;
//                while (k < num.length()) {
//                    boolean flag = check(0, m, k + 1, num);
//                    if (flag) {
//                        return true;
//                    }
//                    k++;
//                }
//                m++;
//            }
//            return false;
//        }
//
//        public boolean check(int s, int m, int e, String num) {
//            String one = num.substring(s, m);
//            String two = num.substring(m, e);
//            String sum = add(one, two);
//            int f = sum.length() + e;
//            if (f > num.length()) {
//                return false;
//            }
//            if ((!"0".equals(one) && one.startsWith("0"))) {
//                return false;
//            }
//            if ((!"0".equals(two) && two.startsWith("0"))) {
//                return false;
//            }
//            if (f - e > 1 && "0".equals(num.substring(e, e + 1))) {
//                return false;
//            }
//            if (sum.equals(num.substring(e, f))) {
//                if (f == num.length()) {
//                    return true;
//                }
//                return check(m, e, f, num);
//            }
//            return false;
//        }
}
