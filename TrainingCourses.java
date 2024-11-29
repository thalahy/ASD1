package application;

import util.LinkedList;
import java.util.Scanner;

/**
 * File name: TrainingCourses.java
 * Author: [Cathal Fahy]
 * Description of class: This is the driver class for the TrainingCourses project.
 * It performs various operations like adding, removing, and displaying employees in a linked list.
 */
public class TrainingCourses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Employee> employeeList = new LinkedList<>();

        System.out.println("Welcome to FoodCo Training Courses Management!");

        // 1. Ask the user how many employees to input (1-10)
        int numEmployees = getValidIntInput(scanner, "Enter the number of employees to add (1-10): ", 1, 10);

        // 2. Add employees
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\nEnter details for employee " + (i + 1) + ":");
            
            int empNum = getValidIntInput(scanner, "Employee Number (positive integer): ");
            scanner.nextLine(); // Clear input buffer

            System.out.print("Name: ");
            String name = scanner.nextLine();
            
            int years = getValidIntInput(scanner, "Years in Organization (at least 5): ", 5, Integer.MAX_VALUE);
            scanner.nextLine(); // Clear input buffer again
            
            System.out.print("Course Name (must start with 'FOOD'): ");
            String course = scanner.nextLine();

            // Validate the course name
            if (!isValidCourseName(course)) {
                course = "ERROR"; // Assign default value if invalid
                System.out.println("Invalid course name. Assigned 'ERROR' as a placeholder.");
            }

            Employee emp = new Employee(empNum, name, years, course);
            if (!employeeList.contains(emp)) {
                employeeList.add(emp); // Add employee to the list
            } else {
                System.out.println("Error: Employee with this number already exists.");
            }
        }

        // 3. Display all employees
        System.out.println("\nCurrent Employees on Training Courses:");
        employeeList.displayAll();

        // 4. Remove an employee by employee number
        int removeEmpNum = getValidIntInput(scanner, "\nEnter Employee Number to remove: ");
        Employee toRemove = null;

        // Traverse the list to find the employee to remove
        for (int i = 0; i < employeeList.size(); i++) {
            Employee emp = employeeList.get(i);
            if (emp.getEmployeeNumber() == removeEmpNum) {
                toRemove = emp;
                break;
            }
        }

        if (toRemove != null) {
            employeeList.delete(toRemove);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Error: No employee found with that number.");
        }

        System.out.println("\nUpdated Employee List:");
        employeeList.displayAll();

        // 5. Delete all employees from a specified course
        System.out.print("\nEnter Course Name to remove all employees from: ");
        scanner.nextLine(); // Clear input buffer
        String courseToRemove = scanner.nextLine();

        // Traverse the list and remove employees who match the course name
        for (int i = 0; i < employeeList.size(); i++) {
            Employee emp = employeeList.get(i);
            if (emp.getCourseName().equals(courseToRemove)) {
                employeeList.delete(emp);
            }
        }

        System.out.println("\nUpdated Employee List After Course Removal:");
        employeeList.displayAll();

        // 6. Personalised Functions
        personalisedFunction(employeeList);  // Display employees with > 10 years of experience
        findEmployeesWithoutCourses(employeeList);  // Display employees without assigned courses

        scanner.close();
    }

    // Helper function for validated integer input
    private static int getValidIntInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    // Helper function for bounded integer input
    private static int getValidIntInput(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            int value = getValidIntInput(scanner, prompt);
            if (value >= min && value <= max) {
                return value;
            } else {
                System.out.println("Input must be between " + min + " and " + max + ".");
            }
        }
    }

    // Personalised Function 1: Display employees with over 10 years of experience & Find employees without assigned courses
    private static void personalisedFunction(LinkedList<Employee> employeeList) {
        System.out.println("\n--- Employees with > 10 Years of Experience ---");
        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            Employee emp = employeeList.get(i);
            if (emp.getYearsInOrg() > 10) {
                emp.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found with more than 10 years of experience.");
        }
    }

    
    private static void findEmployeesWithoutCourses(LinkedList<Employee> employeeList) {
        System.out.println("\n--- Employees Without Assigned Courses ---");
        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            Employee emp = employeeList.get(i);
            if (emp.getCourseName() == null || emp.getCourseName().isBlank() || emp.getCourseName().equals("ERROR")) {
                emp.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("All employees have assigned valid courses.");
        }
    }

    // Helper method: Validate course names
    private static boolean isValidCourseName(String courseName) {
        return courseName != null && courseName.startsWith("FOOD");
    }
}
