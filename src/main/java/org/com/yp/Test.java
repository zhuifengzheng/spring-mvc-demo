package org.com.yp;

/**
 * @Author by yuanpeng
 * @Date 2020/12/14
 */
public class Test {
    private Integer id;
    private String name;

    public Test() {
    }

    public Test(String name) {
        this.name = name;
    }

    public Test(Integer id) {
        this.id = id;
    }

    public Test(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}