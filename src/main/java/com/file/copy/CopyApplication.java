package com.file.copy;

import com.file.copy.service.FileService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class CopyApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(CopyApplication.class, args);
        FileService.copyFileRun();
    }

}
