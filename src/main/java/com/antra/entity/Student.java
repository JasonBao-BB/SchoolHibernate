package com.antra.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id")
    @GenericGenerator(strategy = "increment", name = "inc")
    @GeneratedValue(generator = "inc")
    private Integer studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_sex")
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer tusentId) {
        this.studentId = tusentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
