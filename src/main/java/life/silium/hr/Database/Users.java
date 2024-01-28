package life.silium.hr.Database;

import jakarta.persistence.*;

@Entity
@Table
public class Users {
    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getSalary() {
        return salary;
    }

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String gender;

    public Users(int id, String name, int age, String gender, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public Users() {

    }

    @Column(nullable = false)
    private int salary;

    @Override
    public String toString() {
        return "{" +
                "'id':" + id +
                ", 'name':'" + name + '\'' +
                ", 'age':" + age +
                ", 'gender':'" + gender + '\'' +
                ", 'salary':" + salary +
                '}';
    }
}
