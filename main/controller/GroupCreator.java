package main.controller;

import main.model.Group;
import main.model.Human;

public class GroupCreator {
    public static Group createGroup(String name, Human head) {
        Group group = new Group();
        group.setName(name);
        group.setHead(head);
        return group;
    }
}
