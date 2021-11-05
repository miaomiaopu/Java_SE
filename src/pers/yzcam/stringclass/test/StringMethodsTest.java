package pers.yzcam.stringclass.test;

import pers.yzcam.stringclass.pojo.User;

public class StringMethodsTest {

    public static void main(String[] args) {
        String name = "miaomiaopu";

        // charAt
        char res = name.charAt(1);
        System.out.println(res);

        // compareTo
        String str1 = "abcdefg";
        String str2 = "abcdeeg";
        System.out.println(str1.compareTo(str2));

        // startsWith、endsWith
        String email = new String("yzcam@qq.com");
        System.out.println(email + " 是否是以.cn结尾的 " + (email.endsWith(".cn")));
        System.out.println(email + " 是否是以yzcam开头的 " + (email.startsWith("yzcam")));

        // trim
        String srcStr = " miaomiaopu pu ";
        String destStr = srcStr.trim();
        System.out.println("原串:" + srcStr);
        System.out.println("新串:" + destStr);

        // indexOf
        System.out.println(email + " 中@符号的位置 " + email.indexOf('@'));
        System.out.println(email + " 中@符号的位置(从6位置开始) " + email.indexOf('@', 6));
        System.out.println(email + " 中\".com\"的位置 " + email.indexOf(".com"));
        System.out.println(email + " 中\".com\"的位置(从9开始查) " + email.indexOf(".com", 9));

        // split
        String personNames = "小红，小明，小雷，小刚";
        String[] personNameList = personNames.split("，");
        for (String s : personNameList) {
            System.out.println(s);
        }

        // substring
        String nums = "0123456789";
        System.out.println("从0位置开始复制 " + nums.substring(0));
        System.out.println("从0位置开始复制到4位置(4位置舍去) " + nums.substring(0, 4));

        // toCharArray
        char[] numList = nums.toCharArray();
        for (char num : numList) {
            System.out.print(num + " ");
        }

        // contain
        String nonsense = "miomiaopu%yzcam^miaomioopu$yzacm";
        System.out.println("字符串中是否包含yzcam " + nonsense.contains("yzcam"));

        // replace
        String color = "blue";
        System.out.println("将\"blue\"的'u'替换成'l' " + color.replace('u', 'l'));
        System.out.println("将\"blue\"的\"lu\"替换成\"ul\" " + color.replace("lu", "ul"));

        // valueOf
        String str = String.valueOf(new User());
        System.out.println(str);
    }
}
