package br.edu.gedaam;

import br.edu.gedaam.service.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class Application {


    private static void wakeup(){
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                System.out.println("Wake up");
                EmailService emailService = new EmailService();
                emailService.sendEmail("RaqueL Lemos", "raqlem@gmail.com",
                        "Wake Up", "Waking up");
            }
        };
        Timer timer = new Timer("Timer");

        long delay  = 1000L*60L*29L;
        long period = 1000L*60L*29L; //(29mins)
        timer.scheduleAtFixedRate(repeatedTask, delay, period);
    }

    public static void main(String[] args) {
        wakeup();
        SpringApplication.run(Application.class, args);
    }
}
