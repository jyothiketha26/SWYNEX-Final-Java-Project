import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("ID must be a number.");
                        sc.nextLine();
                        break;
                    }
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();

                    System.out.print("Enter Age: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Age must be a number.");
                        sc.nextLine();
                        break;
                    }
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine().trim();

                    if (id <= 0 || name.isEmpty()
                            || age <= 0 || course.isEmpty()) {
                        System.out.println("Please enter valid student details.");
                        break;
                    }

                    manager.addStudent(
                            new Student(id, name, age, course));
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("ID must be a number.");
                        sc.nextLine();
                        break;
                    }
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine().trim();

                    System.out.print("Enter New Age: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Age must be a number.");
                        sc.nextLine();
                        break;
                    }
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine().trim();

                    if (updateId <= 0 || newName.isEmpty()
                            || newAge <= 0 || newCourse.isEmpty()) {
                        System.out.println("Please enter valid details.");
                        break;
                    }

                    manager.updateStudent(
                            updateId, newName, newAge, newCourse);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("ID must be a number.");
                        sc.nextLine();
                        break;
                    }
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    if (deleteId <= 0) {
                        System.out.println("ID must be positive.");
                        break;
                    }
                    manager.deleteStudent(deleteId);
                    break;
                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

