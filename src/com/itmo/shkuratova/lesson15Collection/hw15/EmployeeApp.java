package com.itmo.shkuratova.lesson15Collection.hw15;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeApp {
    public static void main(String[] args) {
        //Comparator<Employee> nameComparator = Comparator.comparing(Employee::getName);
        //Comparator<Employee> companyComparator = Comparator.comparing(Employee::getCompany);
        //Comparator<Employee> salaryComparator = Comparator.comparing(Employee::getSalary);
        //Comparator<Employee> ageComparator = Comparator.comparing(Employee::getAge);

        List<Employee> employees = Employee.employeeGenerator(10);
        System.out.println("\nСортировка по имени");
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("\nСортировка по имени и зарплате");
        Collections.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("\nСортировка по имени, зарплате, возрасту и компании");
        Collections.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Comparator.comparing(Employee::getSalary)
                .thenComparing(Comparator.comparing(Employee::getAge).thenComparing(Employee::getCompany))));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
