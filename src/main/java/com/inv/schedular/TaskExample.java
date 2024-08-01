package com.inv.schedular;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class TaskExample {

    /*
    Schedular example
     */
    @Scheduled(initialDelay = 2000, fixedRate = 5000)
    public void firstTask(){
        System.out.println("Task is exicuting"+new Date());
    }

    @Scheduled(fixedRate = 5000, scheduler = "schedular-1")
    @Async
    public void manualScheduling1() {
        System.out.println(Thread.currentThread().getName()+" - schedular-1"+new Date());
    }

    @Scheduled(fixedRate = 5000, scheduler = "schedular-2")
    public void manualScheduling2() {
        System.out.println(Thread.currentThread().getName()+" - schedular-2"+new Date());
    }

    @Scheduled(cron = "0 0 * * * *")
    public void manualSchedulingByType() {
        System.out.println(Thread.currentThread().getName()+ "cron ");
    }

    @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void doSomething() {
        System.out.println("Time unit is working"+new Date());
        // method is invoked every five seconds
    }

    /*
    Value getting from properties file example
     */
    @Scheduled(initialDelayString="${spring.task.scheduling.delaytimevalue}", fixedRateString = "${spring.task.scheduling.ratetimevalue}")
    public void valueFromPropertiesTask(){
        System.out.println("initialDelayString Task is exicuting");
    }

    /*
        PT2S means 2 Seconds
        PT2M means 2 Minutes
    */
    @Scheduled(fixedRateString = "PT2S")
    public void valueWithPTTask(){
        System.out.println("Task is exicuting");
    }

    /*
      Cron schedular example
     */
    @Scheduled(cron = "2 * * * * *")
    public void valueWithCronTask(){
        System.out.println("Task is exicuting");
    }
}
