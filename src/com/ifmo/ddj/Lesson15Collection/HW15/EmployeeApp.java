package com.ifmo.ddj.Lesson15Collection.HW15;

import java.util.Collections;
import java.util.List;

public class EmployeeApp {
    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(10);
        System.out.println("\nСортировка по имени");
        Collections.sort(employees, new NameComparator());
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("\nСортировка по имени и зарплате");
        Collections.sort(employees, new NameComparator().thenComparing(new SalaryComparator()));
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("\nСортировка по имени, зарплате, возрасту и компании");
        Collections.sort(employees, new NameComparator().thenComparing(new SalaryComparator()
                .thenComparing(new AgeComparator().thenComparing(new CompanyComparator()))));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
