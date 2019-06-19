package java8.exercise1;

import java.time.LocalDate;
import java.util.stream.Stream;

public class Student {
  //  public Student(Long l, String guoMan, Gender female, Integer i, LocalDate of, Department cs) {
    //}


    public Student(Long id, String name, Gender gender, Integer credit, LocalDate entryDate, Department department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.credit = credit;
        this.entryDate = entryDate;
        this.department = department;
    }

    public enum Gender {
        FEMALE, MALE
    }

    public enum Department {
        CS, CN, EE, AM, CL, EL
    }

    private Long id;
    private String name;
    private Gender gender;
    private Integer credit;
    private LocalDate entryDate;
    private Department department;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getCredit() {
        return credit;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }



    public boolean isMale() {
        return this.gender == Gender.MALE;
    }
    public boolean isFemale() {
        return this.gender == Gender.FEMALE;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name +'\''
                + ", gender=" + gender + ", credit=" + credit + ", entryDate" + entryDate
                + ", department=" + department + '}';
    }
}
