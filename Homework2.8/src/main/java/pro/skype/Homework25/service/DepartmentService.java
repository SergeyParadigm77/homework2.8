package pro.skype.Homework25.service;
import java.util.List;
import java.util.Map;

import pro.skype.Homework25.Employee;

public interface DepartmentService {
    Employee ReturnEmployeeWithMaxSalary(Integer departmentId);
    Employee ReturnEmployeeWithMinSalary(Integer departmentId);
    List<Employee> ReturnAllEmployeeDepartment(Integer departmentId);
    Map<Integer, List<Employee>> ReturnAllEmployeeCollectedDepartment();
}
