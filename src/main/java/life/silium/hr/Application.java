package life.silium.hr;

import jakarta.annotation.PostConstruct;
import life.silium.hr.Service.ReadText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;


@SpringBootApplication
public class Application {
	@Autowired
	public ReadText read;

	@PostConstruct
	public void init() {
		read.read_text();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
