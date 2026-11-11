package ra.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.demo.model.entity.Student;
import ra.demo.repository.StudentRepository;
import ra.demo.service.StudentService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long stuId) {
        return studentRepository.findById(stuId).orElseThrow(()-> new NoSuchElementException("Không tồn tại sinh viên có mã: "+stuId));
    }

    @Override
    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long stuId, Student student) {
        studentRepository.findById(stuId).orElseThrow(()-> new NoSuchElementException("Không tồn tại sinh viên có mã: "+stuId));
        student.setStuId(stuId);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long stuId) {
        studentRepository.findById(stuId).orElseThrow(()-> new NoSuchElementException("Không tồn tại sinh viên có mã: "+stuId));
        studentRepository.deleteById(stuId);
    }
}
