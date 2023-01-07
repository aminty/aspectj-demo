package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserService {
    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void saveUser(){
        userRepo.saveUser();
        System.out.println("call save user inside service");
    }
    public void saveUser(User user){
        userRepo.saveUser(user);
        System.out.println("call parametric save user inside service");
    }
    public void updateUser(){
        userRepo.updateUser();
        System.out.println("call update user inside service");
    }

    public void deleteUser(){
        userRepo.deleteUser();
        System.out.println("call delete user inside service");
    }


    public void sampleOne(){
        System.out.println("sample one method");
    }

    public void sampleTwo(){
        System.out.println("sample two method");
    }

}
