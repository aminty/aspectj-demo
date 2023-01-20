package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(Config.class);

        UserService userService= (UserService) context.getBean("userService");

        userService.deleteUser();
        System.out.println("--------------------------------");
        userService.saveUser();
        System.out.println("--------------------------------");
        userService.saveUser(new User("aminty","1234"));
        System.out.println("--------------------------------");
        userService.sampleOne();
        userService.sleepMethod();
        userService.getSomeStr();

    }
}