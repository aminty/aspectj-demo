package org.example.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
    @Pointcut("execution(* org.example.UserService.*())")
    //mean: select all method with any type of parameter in this package
    public void forAllMethodInService() {

    }

    @Pointcut("execution(public void org.example.UserService.sampleOne())")
    public void forSampleOne() {
        System.out.println("just for sample one");
    }

    @Pointcut("execution(public void org.example.UserService.sampleTwo())")
    public void forSampleTwo() {
        System.out.println("just for sample two");
    }


    @Pointcut("forAllMethodInService() && !(forSampleOne() || forSampleTwo())")
    public void allMethodExcludeSampleOneAndTwo() {
       // System.out.println("for all method and sample one and sample two excluded");
    }

    @Before("allMethodExcludeSampleOneAndTwo()")
    public void runForAllAndNoSampleOneAndTwo() {
        System.out.println("for all method and sample one and sample two excluded");
    }




   /*
    @Before("execution(public void saveUser())")
    public void execBeforeSaveUser(){
        System.out.println("this line exec before save user method");
    }

    @After("execution(public void deleteUser())")
    public void execAfterDelete(){
        System.out.println("this line exec after delete user method");
    }

    @Before("execution(public void *User())")
    public void execBeforeContainUser(){
        System.out.println("this  line exec before each contain user method");
    }

    @After("execution(public void saveUser(org.example.User))")
    public void execAfterSaveUser(){
        System.out.println("this line exec after save user method with params");
    }
    */


}
