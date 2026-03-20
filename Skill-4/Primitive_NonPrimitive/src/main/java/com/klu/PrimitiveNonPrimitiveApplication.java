package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimitiveNonPrimitiveApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PrimitiveNonPrimitiveApplication.class, args);
	}
	@Autowired
	Student s;
	 @Override
     public void run(String... args) {
    	 s.display();
     }
    
	

}
