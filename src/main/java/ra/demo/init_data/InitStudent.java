package ra.demo.init_data;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ra.demo.model.entity.Student;
import ra.demo.repository.StudentRepository;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitStudent implements CommandLineRunner{
    private final StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Student> students = List.of(
                new Student(null,"Nguyễn Văn Cường",true, LocalDate.of(2000, 1, 1),"Hoa Lư - Ninh Bình","CNTT1"),
                new Student(null,"Nguyễn Mạnh Đức",true, LocalDate.of(2000, 11, 21),"Ý Yên - Ninh Bình","CNTT1"),
                new Student(null,"Lê Thành Nam",true, LocalDate.of(2000, 10, 12),"Nam Trực - Ninh Bình","CNTT2"),
                new Student(null,"Trần Quốc Tuấn",true, LocalDate.of(2000, 7, 25),"Đồng Đăng - Lạng Sơn","CNTT2")
        );

        studentRepository.saveAll(students);
    }
}
