package pers.yzcam.objectclass.test;

import pers.yzcam.objectclass.entity.User;

public class UserTest {
    public static void main(String[] args) {

        User user = new User("202004402186", "yzcam", 10);
        // 默认调用 toString()
        System.out.println(user);

        // equals 测试
        User user1 = new User("202004402186", "miaomiaopu", 20);
        System.out.println(user.equals(user1));

        // getClass 测试
        Class userClass = user.getClass();
        // 使用 Class 对象获取当前对象的类的完全限定名称
        System.out.println("类名称是: " + userClass.getName());

        // hashCode 测试
        User user2 = user;
        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());

        // clone 测试
        try {
            User cloneUser = user.clone();
            System.out.println(cloneUser == user);
            System.out.println(user);
            System.out.println(cloneUser);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
