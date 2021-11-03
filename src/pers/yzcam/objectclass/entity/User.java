package pers.yzcam.objectclass.entity;

/**
 * User 实体类
 */
public class User implements Cloneable {
    private String id;
    private String name;
    private int age;

    /**
     * 无参构造器
     */
    public User() {

    }

    /**
     * 有参构造器
     *
     * @param id   id
     * @param name name
     * @param age  age
     */
    public User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * toString 方法重写
     *
     * @return toString 字符串
     */
    @Override
    public String toString() {
        return "User{" +
                "id='" + this.getId() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                '}';
    }

    /**
     * clone 方法重写
     *
     * @return 返回当前对象类型
     * @throws CloneNotSupportedException
     */
    @Override
    public User clone() throws CloneNotSupportedException {
        System.out.println("克隆对象");
        return (User) super.clone();
    }

    /**
     * equals 方法重写
     *
     * @param obj User实例
     * @return 是否相等
     */
    @Override
    public boolean equals(Object obj) {
        // 判断是否属于同一类型
        if (!(obj instanceof User))
            return false;
        User user;
        user = (User) obj;
        return this.getId().equals(user.getId());
    }


}
