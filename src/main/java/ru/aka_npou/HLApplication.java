package ru.aka_npou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.aka_npou.util.Data;

@SpringBootApplication
public class HLApplication {
    public static void main(String[] args) {
        SpringApplication.run(HLApplication.class, args);

        Data.readZipFiles();
    }
}
