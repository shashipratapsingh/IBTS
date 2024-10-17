package CodeJdbcTemplete.CustomException;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Getter
@Setter
public class GlobleExceptionHandle extends RuntimeException{
    private String msg;
    private int code;
    public GlobleExceptionHandle(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }
    public GlobleExceptionHandle(String msg) {
        super(msg);
    }
}
