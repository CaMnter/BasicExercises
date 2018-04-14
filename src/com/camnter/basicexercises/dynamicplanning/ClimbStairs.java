package com.camnter.basicexercises.dynamicplanning;

/**
 * 爬楼梯问题（一次 1~2 阶）
 * <p/>
 * 即一个 N 阶的楼梯，每次能走 1～2 阶，问走到N阶一共多少种走法
 *
 * @author CaMnter
 */
public class ClimbStairs {

    /**
     * 0阶 1 种
     * 1阶 1 种
     * 2阶 2 种
     * 3阶 3 种
     * 4阶 5 种
     * 5阶 8 种
     * <p/>
     * 公式如下：f(n)=f(n−1)+f(n−2)，f(0)=1，f(1)=1
     *
     * @param n n
     * @return int
     */
    public int climbStairsRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    /**
     * 动态规划的数组实现
     * <p/>
     * 创建一个 n+1 的数组
     * 用于记录曾经记录过的值
     *
     * @param n n
     * @return int
     */
    public int climbStairsDP(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairsDP(5));
    }

}
