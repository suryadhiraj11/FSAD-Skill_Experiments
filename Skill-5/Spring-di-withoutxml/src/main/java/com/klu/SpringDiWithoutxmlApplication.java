package com.klu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component("com.klu") 
public class SpringDiWithoutxmlApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
                SpringApplication.run(SpringDiWithoutxmlApplication.class, args);

        Student student = context.getBean(Student.class);
        student.display();

	}	
		

}
