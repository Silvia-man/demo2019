package java8.exercise1;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class School {
    private static List<Student> register() {
        Student s1 = new Student(1L, "GuoMan", Student.Gender.FEMALE, 800, LocalDate.of(1999, Month.FEBRUARY, 10), Student.Department.CS);//长整型+L
        Student s2 = new Student(2L, "ZhangSan", Student.Gender.MALE, 50, LocalDate.of(1999, Month.JULY, 10), Student.Department.EE);//长整型+L
        Student s3 = new Student(3L, "LiSi", Student.Gender.MALE, 30, LocalDate.of(2000, Month.DECEMBER, 3), Student.Department.EE);//长整型+L
        Student s4 = new Student(4L, "HeiSeHui", Student.Gender.FEMALE, 10, LocalDate.of(2001, Month.FEBRUARY, 12), Student.Department.AM);//长整型+L
        Student s5 = new Student(5L, "Xiaodi", Student.Gender.FEMALE, 70, LocalDate.of(2000, Month.MARCH, 2), Student.Department.CS);//长整型+L
        Student s6 = new Student(6L, "AMaZong", Student.Gender.FEMALE, 30, LocalDate.of(1999, Month.FEBRUARY, 3), Student.Department.CS);//长整型+L
        Student s7 = new Student(7L, "ZheBieJun", Student.Gender.MALE, 70, LocalDate.of(1999, Month.FEBRUARY, 3), Student.Department.CL);//长整型+L
        Student s8 = new Student(8L, "GuiyangPengYuyuan", Student.Gender.FEMALE, 70, LocalDate.of(1999, Month.FEBRUARY, 3), Student.Department.CS);//长整型+L
        Student s9 = new Student(9L, "HuaNongBrothers", Student.Gender.MALE, 100, LocalDate.of(1999, Month.FEBRUARY, 3), Student.Department.CS);//长整型+L

        return Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9);
    }

    private static void log(String prefix, Object content) {
        System.out.println(prefix + content);
    }

    public static void main(String[] args) {
        List<Student> students = register();
     //   log("", students);
        //total number
        long studentCount = students.stream().mapToLong(s -> 1L).sum();
        log ("Total of student is: ", studentCount);
        //total credit
        long totalCredit = students.stream().mapToLong(Student::getCredit).sum();
        log("Total credits is", totalCredit);

        Map<Student.Gender, Long> groupCountByGender = students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        log("Student totall by gender is: ", groupCountByGender);

        Optional<Student> maxCredit = students.stream().max(((s1, s2) ->s2.getCredit()-s1.getCredit()));

        maxCredit.ifPresent(student -> log("Max credit is: ", student.getName()));

        boolean allMale = students.stream().allMatch(Student::isMale);
        log("If all students Male ?" , allMale);

        LongSummaryStatistics studentsStats = students.stream().map(Student::getCredit)
                .collect(LongSummaryStatistics::new, LongSummaryStatistics::accept, LongSummaryStatistics::combine);
        log("Stats: ", studentsStats);


        Double creditAvg = students.stream().collect(Collectors.averagingDouble(Student::getCredit));
        log("Stats average: ", creditAvg);

        Map<String, Integer> studentMap = students.stream().collect(Collectors.toMap(Student::getName, Student::getCredit));
        log("Students with credit: " ,studentMap);

        String names = students.stream().filter(Student::isMale).map(Student::getName)
                .collect(Collectors.joining(" ", "Congratulations!", "Welcome Java Club"));
        log("", names);

    }
}
