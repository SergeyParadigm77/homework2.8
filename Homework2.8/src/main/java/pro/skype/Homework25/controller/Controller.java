package pro.skype.Homework25.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skype.Homework25.Employee;
import pro.skype.Homework25.exceptions.EmployeeNotFoundException;
import pro.skype.Homework25.service.EmployeeService;
import java.util.Collection;
@RestController
@RequestMapping("/employees")
public class Controller {
    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
@GetMapping("/add")
public Employee addEmployee(@RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam Integer salary,
                            @RequestParam Integer department) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
}
@GetMapping("/remove")
public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
    return employeeService.removeEmployee(firstName, lastName);
}
@GetMapping("/find")
public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
    Employee employee = employeeService.findEmployee(firstName, lastName);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
}
    @GetMapping
    public Collection<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }
}