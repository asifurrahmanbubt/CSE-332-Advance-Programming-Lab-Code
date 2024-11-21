import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private char grade;

    public Student(String name, int age, char grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, int age, char grade) {
        students.add(new Student(name, age, grade));
    }

    public void removeStudentByIndex(int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
        }
    }

    public void removeStudentByName(String name) {
        students.removeIf(student -> student.getName().equals(name));
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void updateStudent(int index, String name, int age, char grade) {
        if (index >= 0 && index < students.size()) {
            Student student = students.get(index);
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
        }
    }

    public void sortStudentsByAge() {
        students.sort(Comparator.comparingInt(Student::getAge));
    }

    public void checkIfStudentExists(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                System.out.println("Student exists.");
                return;
            }
        }
        System.out.println("Student does not exist.");
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student by Index");
            System.out.println("3. Remove Student by Name");
            System.out.println("4. Display All Students");
            System.out.println("5. Find Student by Name");
            System.out.println("6. Update Student Details");
            System.out.println("7. Sort Students by Age");
            System.out.println("8. Check if Student Exists");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    char grade = scanner.next().charAt(0);
                    system.addStudent(name, age, grade);
                    break;

                case 2:
                    System.out.print("Enter index to remove: ");
                    int index = scanner.nextInt();
                    system.removeStudentByIndex(index);
                    break;

                case 3:
                    System.out.print("Enter name to remove: ");
                    String removeName = scanner.nextLine();
                    system.removeStudentByName(removeName);
                    break;

                case 4:
                    system.displayAllStudents();
                    break;

                case 5:
                    System.out.print("Enter name to find: ");
                    String findName = scanner.nextLine();
                    system.findStudentByName(findName);
                    break;

                case 6:
                    System.out.print("Enter index to update: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    char newGrade = scanner.next().charAt(0);
                    system.updateStudent(updateIndex, newName, newAge, newGrade);
                    break;

                case 7:
                    system.sortStudentsByAge();
                    break;

                case 8:
                    System.out.print("Enter name to check: ");
                    String checkName = scanner.nextLine();
                    system.checkIfStudentExists(checkName);
                    break;

                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
