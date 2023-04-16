package pro.skype.Homework25.service.Impl;
import org.springframework.stereotype.Service;
import pro.skype.Homework25.Employee;
import pro.skype.Homework25.exceptions.EmployeeAlreadyAddedException;
import pro.skype.Homework25.exceptions.EmployeeNotFoundException;
import pro.skype.Homework25.service.EmployeeService;


import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;
    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }
    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        if (employees.containsKey(key)) {
            return employees.get(key);
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
