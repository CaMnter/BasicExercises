package com.camnter.basicexercises.bit;

/**
 * 不用额外变量交换整数值
 * <p/>
 * a = 6 = 110
 * b = 7 = 111
 * <p/>
 * 假如 c = a ^ b = 110
 * c 表示的是 a 整数位信息 和 b 整数位信息 不同的信息
 * <p/>
 * 看看 c ^ a = 110 ^ 110 = 111 = b
 * c ^ b = 110 ^ 111 = 110 = a
 * <p/>
 * 有次可以记住两个数的 异或值
 * 再次与 其中一个数 异或 的话 能得到另外一个数
 *
 * @author CaMnter
 */
public class SpecialExchangeValue {

    public void specialExchangeValue(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.print("交换后：a = " + a + "   b = " + b);
    }

    public static void main(String[] args) {
        int a = 6;
        int b = 7;
        SpecialExchangeValue specialExchangeValue = new SpecialExchangeValue();
        specialExchangeValue.specialExchangeValue(a, b);
    }


}
