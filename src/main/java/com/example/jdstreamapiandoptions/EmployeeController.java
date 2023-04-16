package com.example.jdstreamapiandoptions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class EmployeeController {
    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String welcome() {
        return "Welcome to departmens";
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryEmp(@RequestParam("departmentId") Integer id) {
        return employeeService.maxSalaryEmp(id);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryEmp(@RequestParam("departmentId") Integer id) {
        return employeeService.minSalaryEmp(id);
    }

    @GetMapping("/all")
    public Object allEmp(@RequestParam(value = "departmentId", required = false) Integer id) {
        if (id == null)
            return employeeService.printAll();
        else
            return employeeService.printEmpDepartment(id);
    }
}
