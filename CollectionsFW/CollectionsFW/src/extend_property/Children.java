package extend_property;

public class Children extends Parent {
    private int grade;

    public Children(int age, String name, String address, int grade) {
        super(age, name, address);
        this.grade = grade;
    }

    public String getName() {
        return super.getName(); // This will cause an error because 'name' is private in Parent
    }
    public int getAge() {
        return super.getAge(); // This will cause an error because 'age' is private in Parent
    }
    public int getGrade() {
        return grade;
    }
}
