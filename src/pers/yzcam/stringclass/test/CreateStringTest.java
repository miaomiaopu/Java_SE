package pers.yzcam.stringclass.test;

public class CreateStringTest {

    public static void main(String[] args) {
        String dec = "中国人";
        String newDec = new String(dec);

        System.out.println("是否有相同的字符序列 " + dec.equals(newDec));
        System.out.println("是否具有相同的引用 " + dec == newDec);

        char[] chars = {'2', 33, '喵', '_'};

        String str = new String(chars);
        System.out.println(str);
    }
}
