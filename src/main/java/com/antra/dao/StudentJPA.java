package com.antra.dao;

import com.antra.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentJPA {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("mySQL");

    public static void main(String[] args) {
//        insertStudent();
//        queryStudent();
        updateStudent();
    }

    public static void insertStudent() {
        EntityManager manager = factory.createEntityManager();
        //开始插入数据
        //1. 声明事务开始了
        manager.getTransaction().begin();
        //添加数据
        Student student = new Student();
        student.setStudentName("Alex");
        student.setSex("M");

        Student student2 = new Student();
        student2.setStudentName("Kris");
        student2.setSex("M");

        Student student3 = new Student();
        student3.setStudentName("Christina");
        student3.setSex("F");

        //把创建的数据添加到持久层
        //提交事务
        manager.persist(student2);
        manager.persist(student3);

        manager.getTransaction().commit();

        manager.close();
    }

    public static void queryStudent() {
        EntityManager manager = factory.createEntityManager();
        Student student = manager.find(Student.class, 1);

        System.out.println(student.getStudentId());
        System.out.println(student.getStudentName());
        System.out.println(student.getSex());

    }
    //Hibernate JPA update
    public static void updateStudent() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Student student = manager.find(Student.class, 1);
        student.setStudentName("Alex King II");

        manager.getTransaction().commit();
    }

    public static void deleteStudent() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Student student = manager.find(Student.class, 1);
        manager.remove(student);
        manager.getTransaction().commit();
    }
}
