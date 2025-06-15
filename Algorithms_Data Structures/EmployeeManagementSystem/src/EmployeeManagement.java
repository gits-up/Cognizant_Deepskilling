class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return employeeId + " - " + name + " - " + position + " - Rs. " + salary;
    }
}

public class EmployeeManagement {
    static final int MAX = 100;
    static Employee[] employees = new Employee[MAX];
    static int count = 0;

    public static void addEmployee(int id, String name, String position, double salary) {
        if (count >= MAX) {
            System.out.println("Array full, cant add more employees.");
            return;
        }
        employees[count++] = new Employee(id, name, position, salary);
    }

    public static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee found: " + employees[i]);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees in the system.");
            return;
        }
        System.out.println("Employee List:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) {
        addEmployee(1, "Ram", "Manager", 85000);
        addEmployee(2, "Rahul", "Developer", 55000);
        addEmployee(3, "Mohan", "HR", 50000);

        System.out.println("\nTraversing employees:");
        traverseEmployees();

        System.out.println("\nSearching for employee with ID 2:");
        searchEmployee(2);

        System.out.println("\nDeleting employee with ID 1:");
        deleteEmployee(1);

        System.out.println("\nTraversing after deletion:");
        traverseEmployees();
    }
}