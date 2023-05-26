package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    SILab2 testerLab2;
    @Test
    void TestEveryBranch() {

        //testcase1: user.getPassword() == null; allUsers == whathever(T or F);
        //Passed edges: 1-2, 2-18;

        ArrayList<User> Lista = new ArrayList<>();
        User user = new User("UserTest", null, "email@smth.com");
        assertThrows(RuntimeException.class,() -> testerLab2.function(user, Lista));


        //testcase2: user.username = username, user.email = FAIL,  user.pass = 223305, list = [Username2];
        //Passed edges: 1-3, 3-5, 5-11, 11-13, 13-14.1, 14.1-14.2, (14.2-15, 15-14.3, 14.3-14.2) 14.2-17, 17-18;

        User FirstUser = new User("usernameTEST", "223305", "emailNoRegex");
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Username2", "Password2", "Email2"));

        assertFalse(() -> testerLab2.function(FirstUser, users));


        //testcase3: user.username == null, user.pass == "010101", user.email = "email@smth.com", list = [sameAs, unique, unique];
        //Passed edges: 1-3, 3-4, 4-5, 5-6.1, 6.1-6.2, (6.2-7, 7-9, 9-6.3, 6.3-6.2), 6.2-7, 7-8, 8-9, 9-10, 10-6.3, 6.3-6.2, 6.2-11, 11-12, 12-18;

        ArrayList<User> userList = new ArrayList<>();
        User user2 = new User(null, "010101", "email@smth.com");
        userList.add(user2);
        userList.add(new User("UsernameOne", "222222", "email@email.com"));
        userList.add(new User("UsernameTwo", "333333", "emailTwo@email.com"));

        assertFalse(() -> testerLab2.function(user2, userList));

        //testcase4: user.password = "empty1 2space"; list = [] empty;
        // Passed edges: 1-3, 3-5, 5-11, 11-13, 13-17, 17-18;

        User Dimitar = new User("Dimitar", "empty1 2space", "MyNewMail@yahoo.com");

        assertFalse(() -> testerLab2.function(Dimitar, new ArrayList<>()));


        // testcase5: user.password = "special%&'()*+,-./:;<Pass123", user.email = "emailNoRegex", user.username = Dimitar2, empty List allUsers = [];
        //Passed edges: 1-3, 3-5, 5-11, 11-13, 13-14.1, 14.1-14.2, (14.2-15, 15-14.3, 14.3-14.2), 14.2-15, 15-16, 16-18;

        User Dimitar2 = new User("Dimitar2", "special%&'()*+,-./:;<Pass123", "emailNoRegex");

        assertFalse(() -> testerLab2.function(Dimitar2, new ArrayList<>()));

    }
    @Test
    void TestMultipleCondition() {
        //if (user==null || user.getPassword()==null || user.getEmail()==null);


        //testcase1: True, Anything (T or F) Password, Anything (T or F) Email;
        // user == null, (user.password == null || user.password != null), (user.email == null || user.email != null);

        ArrayList<User> Lista1 = new ArrayList<>();

        assertThrows(RuntimeException.class, () -> testerLab2.function(null, Lista1));


        //testcase2: FALSE (F) User, TRUE (T) Password, Anything (T or F) Email;
        // user != null, user.password == null, (user.email == null || user.email != null);

        ArrayList<User> Lista2 = new ArrayList<>();
        User testUserOne = new User("testUserOne", null, "testUserOne@mailO.com");

        assertThrows(RuntimeException.class, () -> testerLab2.function(testUserOne, Lista2));


        //testcase3: FALSE (F) User, FALSE (F) Password, TRUE (T) Email;
        // user != null, user.password != null && user.email == null;

        ArrayList<User> Lista3 = new ArrayList<>();
        User testUserTwo = new User("testUserTwo", "someHardPass123", null);

        assertThrows(RuntimeException.class, () -> testerLab2.function(testUserTwo, Lista3));


        //testcase4 FALSE (F) User, FALSE (F) Password, FALSE (F) Email;
        // user != null, user.password != null && user.email != null

        ArrayList<User> Lista4 = new ArrayList<>();
        User testUserThree = new User("testUserThree", "evenHarderPass321", "testUserThree@mail1.com");

        assertFalse(() -> testerLab2.function(testUserThree, Lista4));
    }
}