package pers.yzcam.staticblock.class_;

/**
 * 静态代码块的类
 */
public class Location {
    /**
     * 静态常量的声明
     */
    public static final int EAST;
    public static final int WEST;
    public static final int SOUTH;
    public static final int NORTH;

    public double distance;

    // 只会在程序中执行一次，和类加载一起加载
    static {
        EAST = 0;
        WEST = 1;
        SOUTH = 2;
        NORTH = 3;

        displayLocation();
        // displayDistance(distance); /// 静态块中不允许访问非静态字段和方法

        // 可以定义在静态块中使用的局部类
        class B {
        }
    }

    /**
     * 显示方位
     */
    public static void displayLocation() {
        System.out.println("您的位置在" + EAST);
    }

    /**
     * 显示距离
     */
    private void displayDistance(double distance) {
        System.out.println("您的距离为" + distance);
    }
}
