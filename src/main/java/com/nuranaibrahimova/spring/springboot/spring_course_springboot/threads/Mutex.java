package com.nuranaibrahimova.spring.springboot.spring_course_springboot.threads;

import org.springframework.stereotype.Component;

@Component
public class Mutex {
    public static boolean isGetRequestSent = false;
 //   static final Object lock = new Object();

    public   synchronized void  waitForGetRequest() throws InterruptedException {

            while (isGetRequestSent==false) {
                wait();
            }
            if (isGetRequestSent==true)
        isGetRequestSent = false;
            notify();
     }


    public synchronized void changeStatusToTrue() throws InterruptedException {

            isGetRequestSent = true;
            notify();
        }

}
