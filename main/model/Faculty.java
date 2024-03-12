package main.model;
import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private Human head;
    private List<Department> departments = new ArrayList<>();

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void setHead(Human human) {
        head = human;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public String getSurname() {
        if (head != null) {
            return head.getSurname();
        }
        return null;
    }

    public Department[] getDepartments() {
        return departments.toArray(new Department[0]);
    }

    public void setName(String name) {
        this.name = name;
    }

    // constructor, getters, and setters
}