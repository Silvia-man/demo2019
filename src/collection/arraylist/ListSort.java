package collection.arraylist;


import java.util.*;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge() {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[name: " + this.name + " age: " + this.age + "]   ";
    }
}
public class ListSort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("fghjk", 44));
        students.add(new Student("pk", 12));
        students.add(new Student("qj", 32));
        students.add(new Student("aah", 37));
        students.add(new Student("jij", 56));
        students.add(new Student("ny", 87));
        students.add(new Student("oi", 56));
        System.out.println(students);

        students.sort((o1, o2) -> o1.getAge()  - o2.getAge());
        System.out.println(students);
    }
}
