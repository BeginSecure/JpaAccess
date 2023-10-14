package com.beginsecure.JpaAccess;

import com.beginsecure.JpaAccess.model.Employee;
import com.beginsecure.JpaAccess.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class JpaAccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAccessApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(EmployeeRepository repository) {

		return (args) -> {

			repository.save(new Employee("Bill", "Gates", new BigDecimal("1000000")));
			repository.save(new Employee("Elon", "Musk", new BigDecimal("2000000")));
			repository.save(new Employee("Jeff", "Bezos", new BigDecimal("1800000")));

			for(Employee employee : repository.findAll())
				System.out.println(employee);

			System.out.println(repository.findByLastName("Musk").getSalary());

			System.out.println(String.format("%,.2f",repository.findByFirstName("Bill").getSalary()));

		};
	}

}
