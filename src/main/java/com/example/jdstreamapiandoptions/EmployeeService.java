package com.example.jdstreamapiandoptions;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private Employee[] employees = new Employee[3];
    EmployeeService() {
        employees[0] = new Employee("Employee 1", 50000, 1);
        employees[1] = new Employee("Employee 2", 1000000, 2);
        employees[2] = new Employee("Employee 3", 2000000, 2);
    }

    public Employee maxSalaryEmp(int department) {
        return Arrays.stream(employees)
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(e -> e.getSalary()))
                .get();
    }
    public Employee minSalaryEmp(int department) {
        return Arrays.stream(employees)
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(e -> e.getSalary()))
                .get();
    }

    public List<Employee> printAll() {
        return Arrays.stream(employees)
                .sorted(Comparator.comparingInt(e -> e.getDepartment()))
                .collect(Collectors.toList());
    }

    public List<Employee> printEmpDepartment(int id) {
        return Arrays.stream(employees)
                .filter(e -> e.getDepartment() == id)
                .collect(Collectors.toList());
    }
}
