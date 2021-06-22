package com.q.pojo;

//实体测试类（就是为了解决数据库字段名和实体类中的属性名不一致的问题）

public class UserTest {

    private long id;
    private String name;
    private String password;

    public UserTest(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserTest() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
