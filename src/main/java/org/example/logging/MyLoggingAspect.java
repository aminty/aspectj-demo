package org.example.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;


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

    @Around("execution(* org.example.UserService.sleepMethod())")
    public void calcTime(ProceedingJoinPoint pj) throws Throwable {

        Long start= System.currentTimeMillis();
        System.out.println(start);
        Object result = pj.proceed();
        System.out.println(result);
        Long end=System.currentTimeMillis();
        System.out.println("--------------------------------------------");
        System.out.println(end);
        System.out.println(end-start);

    }



    @AfterReturning(
            pointcut = "execution(* org.example.UserService.getSomeStr())",
            returning = "result"
    )
    public void getAfterReturningForgetSomeStr(JoinPoint jp, List<String> result){

        String methodSignature=jp.getSignature().toString();
        System.out.println(methodSignature);

        for (String s: result
             ) {
            System.out.println(s);

        }


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
