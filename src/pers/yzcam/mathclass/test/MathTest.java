package pers.yzcam.mathclass.test;

public class MathTest {

    public static void main(String[] args) {
        System.out.println("自然对数的底数 " + Math.E);
        System.out.println("圆周率 " + Math.PI);

        System.out.println("9 的平方根 " + Math.sqrt(9));
        System.out.println("27 的立方根 " + Math.cbrt(27));
        System.out.println("-9 的绝对值 " + Math.abs(-9));
        System.out.println("3.4 向上取整 " + Math.ceil(3.4));
        System.out.println("3.6 向下取整 " + Math.floor(3.6));
        System.out.println("3.2,4.3的较大值 " + Math.max(3.2, 4.3));
        System.out.println("3.2,4.3的较小值 " + Math.min(3.2, 4.3));
        System.out.println("2的3次幂 " + Math.pow(2, 3));
        System.out.println("[0,1)的随机数 " + Math.random());
    }
}
