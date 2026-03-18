package extend_property;

public class Parent {
    private int age;
    private String name;
    private String address;

    protected Parent(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    protected String getName() {
        return name;
    }
    protected int getAge() {
        return age;
    }
    private String getAddress() {
        return address;
    }
}
