package ra.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.demo.model.dto.response.ApiResponse;
import ra.demo.model.entity.Student;
import ra.demo.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getStudents() {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy danh sách sinh viên thành công",
                studentService.getStudents(),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @GetMapping("/{stuId}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable Long stuId) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy thông tin sinh viên có mã " + stuId + " thành công",
                studentService.getStudentById(stuId),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> insertStudent(@RequestBody Student student) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Thêm mới sinh viên " + student.getFullName() + " thành công",
                studentService.insertStudent(student),
                null,
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @PutMapping("/{stuId}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(@PathVariable Long stuId, @RequestBody Student student) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Cập nhật sinh viên " + student.getFullName() + " thành công",
                studentService.updateStudent(stuId, student),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @DeleteMapping("/{stuId}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable Long stuId) {
        studentService.deleteStudent(stuId);
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Xóa sinh viên có mã " + stuId + " thành công",
                null,
                null,
                HttpStatus.NO_CONTENT
        ), HttpStatus.NO_CONTENT);
    }
}
