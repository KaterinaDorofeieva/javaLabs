package main.model;
import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private Human head;
    private List<Group> groups;

    public Department() {
        this.groups = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
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

    public List<Group> getGroups() {
        return groups;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Other getters and setters for head's surname
    public String getSurname() {
        return head.getSurname();
    }

    // Additional methods, if needed

    // Example method to print department details
    public void printDepartmentDetails() {
        System.out.println("Department: " + name);
        System.out.println("Head: " + head.getName() + " " + head.getSurname());
        System.out.println("Groups:");
        for (Group group : groups) {
            System.out.println("\t" + group.getName());
        }
    }
}