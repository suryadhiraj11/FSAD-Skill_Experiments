package com.klu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class SpringDiApplication {

	public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(SpringDiApplication.class, args);

        Student student = context.getBean(Student.class);
        student.display();
	
	}

}
