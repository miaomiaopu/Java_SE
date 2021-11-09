package pers.yzcam.stringbuilderclass.test;

import org.junit.jupiter.api.Test;
import pers.yzcam.stringbuilderclass.Dao.StaffDao;
import pers.yzcam.stringbuilderclass.utils.StringManagement;

import java.util.HashMap;
import java.util.Map;

class StringBuilderTest {
    /**
     * 测试对象的创建
     */
    @Test
    void testCreateStringBuilder() {
        StringBuilder builder = new StringBuilder("yzcam");
        System.out.println(builder);
        System.out.println("长度 " + builder.length());
        System.out.println("默认容量 " + builder.capacity());
    }

    /**
     * 测试 append 方法
     */
    @Test
    void testAppendMethod() {
        StringBuilder builder = new StringBuilder("yzcam");
        System.out.println(builder.append("@qq.com"));
        StringBuilder builder1 = new StringBuilder("I'm ");
        StringBuilder builder2 = builder1.append("yzcam");
        System.out.println(builder1);
        System.out.println(builder2);
        System.out.println(builder1 == builder2);
    }

    /**
     * 测试 delete 方法
     */
    @Test
    void testDeleteMethod() {
        System.out.println(StringManagement.removeStringFromStartToEnd("yzcam@qq.com", 5, 12));
    }

    /**
     * 测试 replace 方法
     */
    @Test
    void testReplaceMethod() {
        String target = "{a=1,b=2,c=3}";
        System.out.println(StringManagement.replaceTargetFromStartToEnd(target, ":"));
    }

    /**
     * 测试 insert 方法
     */
    @Test
    void testInsertMethod() {
        String target = "name:\"king\",age:,address:\"home\";\n" +
                "name:\"lucy\",age:,address:\"home\";\n" +
                "name:\"tom\",age:,address:\"home\";\n";
        String res = StringManagement.insertObjectOn(target, "age:,", 18);
        System.out.println(res);
    }

    /**
     * 测试 append 方法
     */
    @Test
    void staffDaoTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "king");
        map.put("gender", "male");
        map.put("post", 3);
        map.put("address", "人民大街");
        new StaffDao().findByArgs(map);
    }

    /**
     * 测试 reverse 方法
     */
    @Test
    void reverseMethodTest() {
        StringBuilder builder = new StringBuilder("abcdefg");
        System.out.println(builder.reverse());
    }

    /**
     * 测试 setLength 方法
     */
    @Test
    void setLengthMethodTest() {
        StringBuilder builder = new StringBuilder("012345");
        builder.setLength(4);
        System.out.println(builder);
    }

    /**
     * 测试 setCharAt 方法
     */
    @Test
    void setCharAtMethodTest() {
        StringBuilder builder = new StringBuilder("011345");
        builder.setCharAt(2, '2');
        System.out.println(builder);
    }
}
