package ra.demo.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse <T>{
    private boolean success;
    private String message;
    private T data;
    private ApiError<T> errors;
    private HttpStatus httpStatus;
}
