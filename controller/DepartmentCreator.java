package controller;

import model.Department;
import model.Human;

public class DepartmentCreator {

    public static Department createDepartment(String name, Human head) {
        Department department = new Department();
        department.setName(name);
        department.setHead(head);
        return department;
    }
}
