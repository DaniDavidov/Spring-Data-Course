package bg.softuni.modelmapper.services;

import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.CreateEmployeeDto;
import bg.softuni.modelmapper.entities.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeDto employeeDto);
    List<EmployeeDto> findAll();
}
