package pers.yzcam.packingclass.character.test;

import pers.yzcam.packingclass.character.tool.CharacterManager;

public class ICharacterTest {
    public static void main(String[] args) {
        char[] passwordArray = {'T', '9', ' ', 'x', 'Y', ' ', '4', 'n'};
        // 验证密码中字符种类和数目
        CharacterManager.validatePassword(passwordArray);
        // 删除密码中空格
        System.out.println(CharacterManager.dropSpaceChar(passwordArray));
        // 字符转化
        System.out.println(CharacterManager.toUpperCaseOrLowerCase(passwordArray, 0));
    }
}
