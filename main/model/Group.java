package main.model;
import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private Human head;
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void setHead(Human human) {
        this.head = human;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public Student[] getStudents() {
        return students.toArray(new Student[0]);
    }

    public void setName(String name) {
        this.name = name;
    }

    // Other constructors, getters, and setters
}

