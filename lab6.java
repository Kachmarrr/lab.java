package org.example;

import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введіть кількість робітників: ");
        int n = input.nextInt();
        Map<String, Employee> employeesMap = new HashMap<>();

        // Введення даних про робітників
        for (int i = 0; i < n; i++) {
            input.nextLine(); // Очистка
            System.out.println("Введіть інформацію про робітника #" + (i + 1) + ":");
            System.out.print("П.І.Б робітника: ");
            String fullName = input.nextLine();
            System.out.print("Код цеху: ");
            int departmentCode = input.nextInt();
            System.out.print("Норма випуску за планом: ");
            int plannedProduction = input.nextInt();
            System.out.print("Кількість фактично виробленої продукції: ");
            int actualProduction = input.nextInt();

            Employee employee = new Employee(fullName, departmentCode, plannedProduction, actualProduction);
            employeesMap.put(fullName, employee);//додаємо тіпів в мапу
        }

        // сортування/виведення інформації про робітників
        System.out.println("Інформація про всіх робітників:");
        employeesMap.forEach((fullName, employee) -> {
            System.out.println(employee);
        });

        // Виведення інформації про тіпів які перевиконали план
        System.out.println("Робітники, які перевиконали план:");
        employeesMap.forEach((fullName, employee) -> {
            if (employee.actualProduction > employee.plannedProduction) {
                System.out.println(employee);
            }
        });
    }
}
