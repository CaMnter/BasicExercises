package com.camnter.basicexercises.other;

/**
 * 求一个数 的平方根，不一定整数
 *
 * 不断二分
 * 中间值的 平方大于 目标值 的时候 取 左区间
 * 中间值的 平方小于 目标值 的时候 取 右区间
 *
 * @author CaMnter
 */
public class Sqrt {

    private double sqrt(double target) {
        double low = 0, high = target, mid, square;
        // 精度，0.0000001
        final double precise = 0.0000001;

        while (high - low > precise) {
            mid = (low + high) / 2;
            square = mid * mid;

            if (square > target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return (low + high) / 2;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        double value = 2.33;
        System.out.println(sqrt.sqrt(value * value));
    }

}
