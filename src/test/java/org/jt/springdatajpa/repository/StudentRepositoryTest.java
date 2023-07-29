package org.jt.springdatajpa.repository;

import org.jt.springdatajpa.entity.Guardian;
import org.jt.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Guard;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("swainabinash36@gmail.com")
                .firstName("Abinash")
                .lastName("Swain")
//                .guardianName("Anath ch Swain")
//                .guardianEmail("swainanath1975@gmail.com")
//                .guardianMobile("6370083077")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("rashmi@gmail.com")
                .name("Rashmi")
                .mobile("123456789")
                .build();
        Student student = Student.builder()
                .firstName("Shivam")
                .emailId("shivam@gmail.com")
                .lastName("kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }


    @Test
    public void printAllStudent(){
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("Shivam");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("Sh");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBaseOnGuardianName(){

        List<Student> students =
                studentRepository.findByGuardianName("Rashmi");

        System.out.println("students = " + students);
    }

}