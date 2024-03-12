package test;


import static org.junit.Assert.assertEquals;

import java.util.Objects;

import main.controller.JsonManager;
import main.model.Department;
import main.model.Faculty;
import main.model.Group;
import main.model.Human;
import main.model.Sex;
import main.model.Student;
import main.model.University;

public @interface Test {

    public class TestUniversityManagementSystem {

    @Test
    void testJsonSerializationDeserialization() {
        // Create oldUniversity with the specified structure
        University oldUniversity = createSampleUniversity();

        // Serialize oldUniversity to JSON and write to a file
        JsonManager.writeToJsonFile(oldUniversity, "university.json");

        // Deserialize from the JSON file to create newUniversity
        University newUniversity = JsonManager.readFromJsonFile("university.json");

        // Check equality
        assertEquals(oldUniversity, newUniversity);
    }


    private University createSampleUniversity() {
        // Create a sample university structure
        University university = new University();
        university.setName("Sample University");

        // Create faculties
        Faculty engineeringFaculty = new Faculty();
        engineeringFaculty.setName("Engineering Faculty");
        Faculty businessFaculty = new Faculty();
        businessFaculty.setName("Business Faculty");

        // Create departments within faculties
        Department computerScienceDept = new Department();
        computerScienceDept.setName("Computer Science Department");
        Department mechanicalDept = new Department();
        mechanicalDept.setName("Mechanical Engineering Department");

        Department financeDept = new Department();
        financeDept.setName("Finance Department");
        Department marketingDept = new Department();
        marketingDept.setName("Marketing Department");

        engineeringFaculty.addDepartment(computerScienceDept);
        engineeringFaculty.addDepartment(mechanicalDept);

        businessFaculty.addDepartment(financeDept);
        businessFaculty.addDepartment(marketingDept);

        // Create groups within departments
        Group csGroup = new Group();
        csGroup.setName("CS101");
        Group mechGroup = new Group();
        mechGroup.setName("ME101");

        Group financeGroup = new Group();
        financeGroup.setName("FIN201");
        Group marketingGroup = new Group();
        marketingGroup.setName("MKT201");

        computerScienceDept.addGroup(csGroup);
        mechanicalDept.addGroup(mechGroup);

        financeDept.addGroup(financeGroup);
        marketingDept.addGroup(marketingGroup);

        // Create students
        Student student1 = new Student(null, null, null, null);
        student1.setName("John");
        student1.setSurname("Doe");
        student1.setPatronymic("Jr.");
        student1.setSex(Sex.MALE);
        student1.setGroup(csGroup);

        Student student2 = new Student(null, null, null, null);
        student2.setName("Alice");
        student2.setSurname("Smith");
        student2.setPatronymic("Sr.");
        student2.setSex(Sex.FEMALE);
        student2.setGroup(mechGroup);

        Student student3 = new Student(null, null, null, null);
        student3.setName("Bob");
        student3.setSurname("Johnson");
        student3.setPatronymic("III");
        student3.setSex(Sex.MALE);
        student3.setGroup(financeGroup);

        Student student4 = new Student(null, null, null, null);
        student4.setName("Eva");
        student4.setSurname("Williams");
        student4.setPatronymic("IV");
        student4.setSex(Sex.FEMALE);
        student4.setGroup(marketingGroup);

        // Add students to groups
        csGroup.addStudent(student1);
        mechGroup.addStudent(student2);
        financeGroup.addStudent(student3);
        marketingGroup.addStudent(student4);

        // Set heads for faculties, departments, and groups (for demonstration purposes)
        university.setHead(new Human("University Head", "Surname", "Patronymic", Sex.MALE));
        engineeringFaculty.setHead(new Human("Engineering Dean", "Surname", "Patronymic", Sex.MALE));
        businessFaculty.setHead(new Human("Business Dean", "Surname", "Patronymic", Sex.MALE));
        computerScienceDept.setHead(new Human("CS Head", "Surname", "Patronymic", Sex.MALE));
        mechanicalDept.setHead(new Human("Mechanical Head", "Surname", "Patronymic", Sex.MALE));
        financeDept.setHead(new Human("Finance Head", "Surname", "Patronymic", Sex.MALE));
        marketingDept.setHead(new Human("Marketing Head", "Surname", "Patronymic", Sex.MALE));
        csGroup.setHead(new Human("CS Group Head", "Surname", "Patronymic", Sex.MALE));
        mechGroup.setHead(new Human("Mechanical Group Head", "Surname", "Patronymic", Sex.MALE));
        financeGroup.setHead(new Human("Finance Group Head", "Surname", "Patronymic", Sex.MALE));
        marketingGroup.setHead(new Human("Marketing Group Head", "Surname", "Patronymic", Sex.MALE));

        return university;
    }
}


}