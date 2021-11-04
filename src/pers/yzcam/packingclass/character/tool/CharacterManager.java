package pers.yzcam.packingclass.character.tool;

public class CharacterManager {
    private static final int UPPER = 1;
    private static final int LOWER = 0;

    public static String equals(Character character1, Character character2) {
        if (character1.compareTo(character2) == 0) {
            return "相等";
        } else if (character1.compareTo(character2) > 0) {
            return "大于";
        } else {
            return "小于";
        }
    }

    /**
     * 统计密码中有多少个字母，数字，大写字母，小写字母，非数字且非字母字符
     *
     * @param passwordArray 密码数组
     */
    public static void validatePassword(char[] passwordArray) {
        int letter = 0;
        int digit = 0;
        int upperLetter = 0;
        int lowerLetter = 0;
        int notLetterOrDigit = 0;

        for (char password : passwordArray) {
            if (Character.isLetter(password)) {
                ++letter;
            }
            if (Character.isDigit(password)) {
                ++digit;
            }
            if (Character.isUpperCase(password)) {
                ++upperLetter;
            }
            if (Character.isLowerCase(password)) {
                ++lowerLetter;
            }
            if (!Character.isLetterOrDigit(password)) {
                ++notLetterOrDigit;
            }
        }

        System.out.println("字母数目 " + letter);
        System.out.println("小写字母数目 " + lowerLetter);
        System.out.println("大写字母数目 " + upperLetter);
        System.out.println("数字数目 " + digit);
        System.out.println("非字母且非数字数目 " + notLetterOrDigit);

    }

    /**
     * 删除密码中空格
     *
     * @param passwordArray 密码数组
     * @return 修改后的密码 String
     */
    public static String dropSpaceChar(char[] passwordArray) {
        String str = "";
        for (char password : passwordArray) {
            if (!Character.isWhitespace(password)) {
                str += password;
            }
        }
        return str;
    }

    /**
     * 把密码中的字母转化成大写或者小写
     *
     * @param passwordArray 密码数组
     * @param tag           转化成大小写的标志
     * @return 转化后的数组
     */
    public static char[] toUpperCaseOrLowerCase(char[] passwordArray, int tag) {
        for (int i = 0; i < passwordArray.length; i++) {
            if (tag == UPPER) {
                passwordArray[i] = Character.toUpperCase(passwordArray[i]);
            } else {
                passwordArray[i] = Character.toLowerCase(passwordArray[i]);
            }
        }
        return passwordArray;
    }
}
