package bg.softuni.modelmapper;

import bg.softuni.modelmapper.entities.Address;
import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.AddressDto;
import bg.softuni.modelmapper.entities.dtos.CreateEmployeeDto;
import bg.softuni.modelmapper.services.AddressService;
import bg.softuni.modelmapper.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {
    private AddressService addressService;
    private EmployeeService employeeService;

    @Autowired
    public Main(AddressService addressService, EmployeeService employeeService) {
        this.addressService = addressService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        createEmployee(new Scanner(System.in));

    }

    public void createEmployee(Scanner scanner) {
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        BigDecimal salary = new BigDecimal(scanner.nextLine());
        LocalDate birthday = LocalDate.parse(scanner.nextLine());
//        Long addressId = Long.parseLong(scanner.nextLine());
        String country = scanner.nextLine();
        String city = scanner.nextLine();

        AddressDto addressDto = new AddressDto(country, city);

        CreateEmployeeDto employeeDto = new CreateEmployeeDto(firstName, lastName, salary, birthday, addressDto);
        employeeService.create(employeeDto);
    }

}
