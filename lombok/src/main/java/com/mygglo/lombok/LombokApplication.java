package com.mygglo.lombok;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LombokApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LombokApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info("My cool info log");
		log.error("My cool error log");
		log.warn("My cool warn log");

		Person person = new Person();
		person.setLastName("Toto");
		person.setFirstName("Nama");
		person.setId(1L);
		person.setTelephone("7788888");
		System.out.println("=================="+person);

		Person person1 = Person.builder()
				.firstName("My first")
				.lastName("Leuk")
				.id(2L)
				.telephone("88888")
				.build();

		log.info(person1.toString());

	}
}
