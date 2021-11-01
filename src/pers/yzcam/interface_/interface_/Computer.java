package pers.yzcam.interface_.interface_;

/**
 * Computer 接口
 */
public interface Computer {
    /**
     * 接口只允许定义公共的静态常量
     */
    int MAX_NUM = Integer.MAX_VALUE;
    int MIN_NUM = Integer.MIN_VALUE;

    /**
     * 接口只允许定义 public 的抽象方法
     * @param a a表示其中一个数
     * @param b b表示另外一个数
     * @return 返回计算结果
     */
     double count(double a,double b);
}
