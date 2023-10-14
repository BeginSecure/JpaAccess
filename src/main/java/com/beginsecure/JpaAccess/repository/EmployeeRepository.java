package com.beginsecure.JpaAccess.repository;

import com.beginsecure.JpaAccess.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByFirstName(String firstName);
    Employee findByLastName(String lastName);
}
