package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
@Component

public class FileCustomerLogger implements CustomerLogger{
    private final String fileName;

    public FileCustomerLogger(@Value("${customerlogger.filename}") String fileName) { //c tu sie stalo??
        this.fileName = fileName;
    }

    @Override
    public void log() {
        final var message = new String(LocalDateTime.now() + ": Customer operation");
        try {
            Files.write(Paths.get(fileName), message.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
