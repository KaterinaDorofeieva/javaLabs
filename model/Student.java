package model;

public class Student extends Human {
    private Group group;

    public Student(String name, String surname, String patronymic, Sex sex) {
        super(name, surname, patronymic, sex);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    // Override and implement the following methods from the superclass

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    public void setPatronymic(String patronymic) {
        super.setPatronymic(patronymic);
    }

    @Override
    public void setSex(Sex sex) {
        super.setSex(sex);
    }
}