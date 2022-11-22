package com.example.demo;



import com.example.demo.controller.User;
import com.example.demo.controller.UserRepository;
import com.example.demo.controller.UserServiceInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserServiceTest {
    @Autowired
    private UserServiceInterface userServiceClass;

    private User sameLoginUser = new User("Same","Login","testUser2","pass");
    /*@Test
    public void addUserCorrectTest(){

        try{
            userServiceClass.addUser(testUser);
        }catch (Exception e){
            e.getMessage();
        }
        User found=userServiceClass.findUserById(testUser.getId());
        assertEquals(testUser,found);
        userServiceClass.deleteUser(testUser);
    }
    @Test
    public  void addSameUserTwiceTest(){
        try{
            userServiceClass.addUser(testUser);
            userServiceClass.addUser(testUser);

        }catch (Exception e){
            assertEquals("User already exist",e.getMessage());
        }
    }
    @Test
    public void deleteUserTest(){
        userServiceClass.deleteUser(testUser);
        assertFalse(userServiceClass.findAllUsers().contains(testUser));
    }

    /*@Test
    public  void findUserByIDTest(){
        assertEquals(testUser,userServiceClass.findUserById(999L));
    }
*/
    /*@Test
    public  void updateUserTest(){
        testUser.setFirst_name("newName");
        userServiceClass.updateUser(testUser);
        assertTrue(userServiceClass.findAllUsers().contains(testUser));
    }
*/
    @Test
    public void userServiceTest(){
        User testUser= new User(988L,"Test","User","testUser2","password");


            try {
                userServiceClass.addUser(testUser);
            }catch (Exception e){
                assertEquals(e.getMessage(),"could not execute statement; SQL [n/a]; constraint [null]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement");
            }



        List<User> userList = userServiceClass.findAllUsers();
        ArrayList<String> usersLogin = new ArrayList<>();



        for (User user : userList) {
           usersLogin.add(user.getLogin());
        }
        assertTrue(usersLogin.contains(testUser.getLogin()));


//        Assert.assertEquals(testUser.getLogin(),added.getLogin());
//        Assert.assertEquals(testUser.getPassword(),added.getPassword());
//        Assert.assertEquals(testUser.getFirst_name(),added.getFirst_name());
//        Assert.assertEquals(testUser.getLast_name(),added.getLast_name());

//        try{
//            userServiceClass.addUser(sameLoginUser);
//        }catch (Exception e){
//            assertSame("User already exist",e.getMessage());
//        }
//        testUser.setPassword("newPassword");
//        testUser.setLast_name("newLastName");
//        userServiceClass.updateUser(testUser);
//        User updated=userServiceClass.findAllUsers().get(userServiceClass.findAllUsers().size()-1);
//
//        Assert.assertEquals(testUser.getLogin(),updated.getLogin());
//        Assert.assertEquals(testUser.getPassword(),updated.getPassword());
//        Assert.assertEquals(testUser.getFirst_name(),updated.getFirst_name());
//        Assert.assertEquals(testUser.getLast_name(),updated.getLast_name());
//        userServiceClass.deleteUser(testUser);
//        User last=userServiceClass.findAllUsers().get(userServiceClass.findAllUsers().size()-1);

//        Assert.assertNotEquals(testUser.getLogin(),last.getLogin());
//        Assert.assertNotEquals(testUser.getPassword(),last.getPassword());
//        Assert.assertNotEquals(testUser.getFirst_name(),last.getFirst_name());
//        Assert.assertNotEquals(testUser.getLast_name(),last.getLast_name());

    }


}
