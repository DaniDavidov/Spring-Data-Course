package bg.softuni.modelmapper.entities.dtos;

import bg.softuni.modelmapper.entities.Employee;

import java.util.List;

public class ManagerDto {
    private String firstName;
    private String lastName;
    private List<Employee> employeesOfManager;

    public ManagerDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Employee> getEmployeesOfManager() {
        return employeesOfManager;
    }

    public void setEmployeesOfManager(List<Employee> employeesOfManager) {
        this.employeesOfManager = employeesOfManager;
    }
}
