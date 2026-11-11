package ra.demo.service;

import ra.demo.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student getStudentById(Long stuId);
    Student insertStudent(Student student);
    Student updateStudent(Long stuId, Student student);
    void deleteStudent(Long stuId);
}
