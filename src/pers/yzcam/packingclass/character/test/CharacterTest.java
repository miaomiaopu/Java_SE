package pers.yzcam.packingclass.character.test;

import pers.yzcam.packingclass.character.tool.CharacterManager;

public class CharacterTest {
    public static void main(String[] args) {
        Character character1 = 'A';
        Character character2 = Character.valueOf('a');

        // compareTo
        System.out.println(CharacterManager.equals(character1, character2));
    }
}
