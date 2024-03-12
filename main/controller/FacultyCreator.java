package main.controller;

import main.model.Faculty;
import main.model.Human;

public class FacultyCreator {
    public static Faculty createFaculty(String name, Human head) {
        Faculty faculty = new Faculty();
        faculty.setName(name);
        faculty.setHead(head);
        return faculty;
    }
}
