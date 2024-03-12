
import controller.DepartmentCreator;
import controller.FacultyCreator;
import controller.GroupCreator;
import controller.StudentCreator;
import model.Department;
import model.Faculty;
import model.Group;
import model.Human;
import model.Sex;
import model.Student;
import model.University;

public class Run {
    public static void main(String[] args) {
        createTypicalUniversity();
    }

    public static void createTypicalUniversity() {
        // Create a university
        University university = new University();
        university.setName("Sample University");

        // Create faculties
        Faculty engineeringFaculty = FacultyCreator.createFaculty("Engineering Faculty", new Human(null, null, null, null));
        Faculty businessFaculty = FacultyCreator.createFaculty("Business Faculty", new Human(null, null, null, null));

        // Create departments within faculties
        Department computerScienceDept = DepartmentCreator.createDepartment("Computer Science Department", new Human(null, null, null, null));
        Department mechanicalDept = DepartmentCreator.createDepartment("Mechanical Engineering Department", new Human(null, null, null, null));

        Department financeDept = DepartmentCreator.createDepartment("Finance Department", new Human(null, null, null, null));
        Department marketingDept = DepartmentCreator.createDepartment("Marketing Department", new Human(null, null, null, null));

        engineeringFaculty.addDepartment(computerScienceDept);
        engineeringFaculty.addDepartment(mechanicalDept);

        businessFaculty.addDepartment(financeDept);
        businessFaculty.addDepartment(marketingDept);

        // Create groups within departments
        Group csGroup = GroupCreator.createGroup("CS101", new Human(null, null, null, null));
        Group mechGroup = GroupCreator.createGroup("ME101", new Human(null, null, null, null));

        Group financeGroup = GroupCreator.createGroup("FIN201", new Human(null, null, null, null));
        Group marketingGroup = GroupCreator.createGroup("MKT201", new Human(null, null, null, null));

        computerScienceDept.addGroup(csGroup);
        mechanicalDept.addGroup(mechGroup);

        financeDept.addGroup(financeGroup);
        marketingDept.addGroup(marketingGroup);

        // Create students
        Student student1 = StudentCreator.createStudent("John", "Doe", "Jr.", Sex.MALE, csGroup);
        Student student2 = StudentCreator.createStudent("Alice", "Smith", "Sr.", Sex.FEMALE, mechGroup);
        Student student3 = StudentCreator.createStudent("Bob", "Johnson", "III", Sex.MALE, financeGroup);
        Student student4 = StudentCreator.createStudent("Eva", "Williams", "IV", Sex.FEMALE, marketingGroup);

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

        // Print the created university structure
        printUniversityStructure(university);
    }

    private static void printUniversityStructure(University university) {
        // Print the university structure (for demonstration purposes)
        // You can customize this based on your specific requirements
        System.out.println("University: " + university.getName());
        System.out.println("Head: " + university.getHead().getName() + " " + university.getHead().getSurname());

        for (Faculty faculty : university.getFaculties()) {
            System.out.println("\tFaculty: " + faculty.getName());
            System.out.println("\tHead: " + faculty.getHead().getName() + " " + faculty.getHead().getSurname());

            for (Department department : faculty.getDepartments()) {
                System.out.println("\t\tDepartment: " + department.getName());
                System.out.println("\t\tHead: " + department.getHead().getName() + " " + department.getHead().getSurname());

                for (Group group : department.getGroups()) {
                    System.out.println("\t\t\tGroup: " + group.getName());
                    System.out.println("\t\t\tHead: " + group.getHead().getName() + " " + group.getHead().getSurname());

                    for (Student student : group.getStudents()) {
                        System.out.println("\t\t\t\tStudent: " + student.getName() + " " + student.getSurname());
                    }
                }
            }
        }
    }
}

