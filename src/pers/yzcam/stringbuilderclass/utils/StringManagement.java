package pers.yzcam.stringbuilderclass.utils;

public class StringManagement {

    /**
     * 类的静态方法
     * 删除开始到结束位置的字符
     *
     * @param res   源字符串
     * @param start 开始位置(该位置删除)
     * @param end   结束位置(该位置不删除)
     * @return 删除后的字符串
     */
    public static String removeStringFromStartToEnd(String res, int start, int end) {
        StringBuilder builder = new StringBuilder(res);
        builder.delete(start, end);
        return builder.toString();
    }

    /**
     * 类的静态方法
     * 将字符串中等号替换成目标字符
     *
     * @param res     源字符串
     * @param replace 目标字符串
     * @return 替换后的字符串
     */
    public static String replaceTargetFromStartToEnd(String res, String replace) {
        StringBuilder builder = new StringBuilder(res);
        while (builder.toString().contains("=")) {
            builder.replace(builder.indexOf("="), builder.indexOf("=") + 1, replace);
        }
        return builder.toString();
    }

    /**
     * 类的静态方法
     * 在字符串中目标字符串中的冒号后插入字符串
     *
     * @param res       源字符串
     * @param target    目标字符串
     * @param insertObj 插入字符串
     * @return 替换后的字符串
     */
    public static String insertObjectOn(String res, String target, Object insertObj) {
        StringBuilder builder = new StringBuilder(res);
        while (builder.toString().contains(target)) {
            builder.insert(builder.indexOf(target) + 4, insertObj);
        }
        return builder.toString();
    }
}
