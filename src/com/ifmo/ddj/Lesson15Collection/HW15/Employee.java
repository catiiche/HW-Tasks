package com.ifmo.ddj.Lesson15Collection.HW15;

import com.ifmo.ddj.Lesson15Collection.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

//Создать список объетов List<Employee> (использовать метод employeeGenerator)
// и сортировать по:
// имени
// имени и зарплате
// имени, зарплате, возрасту и компании

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    // TODO: конструктор, геттеры и сеттеры

    private Employee(String name, String company, int salary, int age) {
        setName(name);
        setCompany(company);
        setSalary(salary);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Objects.requireNonNull("name не должен быть null");
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        Objects.requireNonNull("company не должен быть null");
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 0) throw new IllegalArgumentException("salary не может быть меньше 0");
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 21) throw new IllegalArgumentException("age не может быть меньше 21");
        this.age = age;
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(
                    names[(int) (Math.random() * names.length)],
                    companies[(int) (Math.random() * companies.length)],
                    (int) (Math.random() * 83001 + 17000),
                    (int) (Math.random() * 40 + 21)));
        }
        return employees;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company, salary, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary &&
                age == employee.age &&
                Objects.equals(name, employee.name) &&
                Objects.equals(company, employee.company);
    }

    @Override
    public String toString() {
        return "Работник{" +
                "Имя: '" + name + '\'' +
                ", Компания: '" + company + '\'' +
                ", Возраст: " + age +
                ", Зарплата: " + salary +
                '}';
    }
}

class NameComparator implements Comparator<Employee> {
    @Override // -1(o1 меньше o2) 0(o1 равен о2) 1(o1 больше о2)
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class CompanyComparator implements Comparator<Employee> {
    @Override // -1(o1 меньше o2) 0(o1 равен о2) 1(o1 больше о2)
    public int compare(Employee o1, Employee o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override // -1(o1 меньше o2) 0(o1 равен о2) 1(o1 больше о2)
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}

class AgeComparator implements Comparator<Employee> {
    @Override // -1(o1 меньше o2) 0(o1 равен о2) 1(o1 больше о2)
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

