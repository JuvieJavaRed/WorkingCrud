/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.ac.nust.erp.test.crudjpatest.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import zw.ac.nust.erp.test.crudjpatest.dao.StudentJpaController;
import zw.ac.nust.erp.test.crudjpatest.entities.Course;
import zw.ac.nust.erp.test.crudjpatest.entities.Student;

/**
 *
 * @author Hp
 */
public class TestCrud {

    public static void main(String[] args) {
        try {
            Student s = new Student();
            StudentJpaController sjc = new StudentJpaController();
            s.setFname("Gugu");
            s.setLname("Ngwenya");
            s.setSex("Female");
            s.setDob(new Date());
            Course c1 = new Course();
            c1.setCode("SCS4201");
            c1.setName("Simulation");
            c1.setProgramme("SCS");
            c1.setStudentid(s);
            Course c2 = new Course();
            c2.setCode("SMA4201");
            c2.setName("Calculas");
            c2.setProgramme("SMA");
            c2.setStudentid(s);
            List<Course> c = new ArrayList<>();
            c.add(c1);
            c.add(c2);
            s.setCourseList(c);
            sjc.create(s);
            System.out.println("Student ID: " + s.getId() + " has been created");
            List<Student> st = sjc.findStudentEntities();
            for (Student stu : st) {
                System.out.println("Student name:" + stu.getFname() + " " + stu.getLname());
                System.out.println("Student ID: " + stu.getId() + " has been retrieved");
                System.out.println("Courses for Student ID: " + stu.getId() + " are: ");
                for (Course cs : stu.getCourseList()) {
                    System.out.println("Course Code:" + cs.getCode());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TestCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
