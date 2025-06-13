import java.util.*;

public class Main {
    static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add Employee\n2. Display All\n3. Search by ID\n4. Delete by ID\n5. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> addEmployee(sc);
                case 2 -> displayEmployees();
                case 3 -> searchById(sc);
                case 4 -> deleteById(sc);
            }
        } while (choice != 5);
        sc.close();
    }

    static void addEmployee(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        employees.add(new Employee(id, name, dept));
        System.out.println("Employee added!");
    }

    static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee e : employees) {
                e.display();
            }
        }
    }

    static void searchById(Scanner sc) {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        for (Employee e : employees) {
            if (e.getId() == id) {
                e.display();
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    static void deleteById(Scanner sc) {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        Iterator<Employee> itr = employees.iterator();
        while (itr.hasNext()) {
            if (itr.next().getId() == id) {
                itr.remove();
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}