package application;

/**
 * File name: Employee.java
 * Author: [Cathal Fahy]
 * Description of class: Manages employee details and ensures constraints for training course eligibility.
 */
public class Employee {
    private int employeeNumber;
    private String name;
    private int yearsInOrg;
    private String courseName;

    // Constructor without parameters for flexibility
    public Employee() {}

    // Constructor with parameters to initialise the fields
    public Employee(int employeeNumber, String name, int yearsInOrg, String courseName) {
        setEmployeeNumber(employeeNumber);
        setName(name);
        setYearsInOrg(yearsInOrg);
        setCourseName(courseName);
    }


    public int getEmployeeNumber() { 
        return employeeNumber; 
    }

    public void setEmployeeNumber(int employeeNumber) {
        if (employeeNumber <= 0) {
            this.employeeNumber = 1; // Set to a default value if invalid
            System.out.println("Invalid employee number. Setting to default value (1).");
        } else {
            this.employeeNumber = employeeNumber;
        }
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unknown"; // Default name if invalid
            System.out.println("Invalid name. Setting to default value (Unknown).");
        } else {
            this.name = name;
        }
    }

    public int getYearsInOrg() { 
        return yearsInOrg; 
    }

    public void setYearsInOrg(int yearsInOrg) {
        if (yearsInOrg < 5) {
            this.yearsInOrg = 5; // Default to 5 if invalid
            System.out.println("Years in organization must be 5 or more. Setting to 5.");
        } else {
            this.yearsInOrg = yearsInOrg;
        }
    }

    public String getCourseName() { 
        return courseName; 
    }

    public void setCourseName(String courseName) {
        if (!isValidCourseName(courseName)) {
            this.courseName = "ERROR"; // Default to "ERROR" if invalid
            System.out.println("Invalid course name. Setting course name to ERROR.");
        } else {
            this.courseName = courseName;
        }
    }

    // Helper method for validating course name
    private boolean isValidCourseName(String courseName) {
        return courseName != null && courseName.startsWith("FOOD");
    }

    
    public String toString() {
        return "Employee [Number=" + employeeNumber + ", Name=" + name + 
               ", Years=" + yearsInOrg + ", Course=" + courseName + "]";
    }

    // Displays employee details
    public void displayDetails() {
        System.out.println("Employee Number: " + employeeNumber);
        System.out.println("Name: " + name);
        System.out.println("Years in Organization: " + yearsInOrg);
        System.out.println("Course Name: " + courseName);
    }

    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;
        return employeeNumber == employee.employeeNumber;
    }

    
    public int hashCode() {
        return Integer.hashCode(employeeNumber);
    }
}
