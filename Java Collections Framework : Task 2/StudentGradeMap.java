import java.util.*;

public class StudentGradeMap {

    public static void main(String[] args) {
        Map<String, Integer> studentGrades = new HashMap<>();

        addStudent(studentGrades, "Alice", 90);
        addStudent(studentGrades, "Bob", 85);
        addStudent(studentGrades, "Charlie", 92);
        System.out.println("Added students: " + studentGrades);

        updateGrade(studentGrades, "Bob", 88);
        System.out.println("Updated grade for Bob: " + studentGrades.get("Bob"));

        deleteStudent(studentGrades, "Bob");
        System.out.println("After removal: " + studentGrades);

        int aliceGrade = retrieveGrade(studentGrades, "Alice");
        System.out.println("Grade of Alice: " + aliceGrade);

        displayAllStudents(studentGrades);

        findHighestAndLowestGrade(studentGrades);
    }

    private static void addStudent(Map<String, Integer> map, String name, int grade) {
        map.put(name, grade);
    }

    private static void updateGrade(Map<String, Integer> map, String name, int newGrade) {
        if (map.containsKey(name)) {
            map.put(name, newGrade);
        } else {
            System.out.println("Student " + name + " not found!");
        }
    }

    private static void deleteStudent(Map<String, Integer> map, String name) {
        if (map.containsKey(name)) {
            map.remove(name);
        } else {
            System.out.println("Student " + name + " not found!");
        }
    }

    private static int retrieveGrade(Map<String, Integer> map, String name) {
        return map.getOrDefault(name, -1); // Returns -1 if the student is not found
    }

    private static void displayAllStudents(Map<String, Integer> map) {
        System.out.println("All students:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    private static void findHighestAndLowestGrade(Map<String, Integer> map) {
        if (map.isEmpty()) {
            System.out.println("No students to evaluate!");
            return;
        }

        String highestStudent = null, lowestStudent = null;
        int highestGrade = Integer.MIN_VALUE, lowestGrade = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String name = entry.getKey();
            int grade = entry.getValue();

            if (grade > highestGrade) {
                highestGrade = grade;
                highestStudent = name;
            }

            if (grade < lowestGrade) {
                lowestGrade = grade;
                lowestStudent = name;
            }
        }

        System.out.println("Highest grade: " + highestStudent + " with " + highestGrade);
        System.out.println("Lowest grade: " + lowestStudent + " with " + lowestGrade);
    }
}
