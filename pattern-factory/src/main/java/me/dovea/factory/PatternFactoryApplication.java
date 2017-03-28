package me.dovea.factory;

import lombok.extern.slf4j.Slf4j;
import me.dovea.factory.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class PatternFactoryApplication implements CommandLineRunner{

	@Autowired
	private ShapeService shapeService;

	public static void main(String[] args) {
		SpringApplication.run(PatternFactoryApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info(shapeService.sayHello("circle"));
		log.info(shapeService.sayHello("rectangle"));
		log.info(shapeService.sayHello("triangle"));
	}
}
