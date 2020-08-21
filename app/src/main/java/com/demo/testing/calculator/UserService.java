package com.demo.testing.calculator;

public class UserService {

    public static User getUser(int userId) {
        throw new CollaboratorCallException("unit test should not call this collaborator");
    }
}
