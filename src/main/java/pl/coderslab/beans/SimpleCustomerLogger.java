package pl.coderslab.beans;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class SimpleCustomerLogger implements CustomerLogger{
    @Override
    public void log() {
        var now = LocalDateTime.now();
        System.out.println(now +": Customer operation");
    }
}
