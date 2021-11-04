package pers.yzcam.packingclass.integer.tool;

public class IntegerManagement {
    /**
     * 将int数据转换成2进制，8进制，16进制字符串
     *
     * @param target 目标数据
     * @param tag    转换标识 2,8,16
     * @return String数据
     */
    public static String fromIntegerToStringByArg(int target, int tag) {
        if (tag == 2) {
            return Integer.toBinaryString(target);
        } else if (tag == 8) {
            return Integer.toOctalString(target);
        } else if (tag == 16) {
            return Integer.toHexString(target);
        }
        return null;
    }
}
