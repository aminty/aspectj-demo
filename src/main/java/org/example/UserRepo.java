package org.example;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {

    public void saveUser(){
        System.out.println("new user was created");
    }

    public void saveUser(User user){
        System.out.println(" user "+user.getUsername()+" was created");
    }
    public void updateUser(){

        System.out.println("found user was updated");
    }

    public void deleteUser(){
        System.out.println("found user was deleted");
    }

}
