package CodeJdbcTemplete.CustomException;


import lombok.Getter;
import lombok.Setter;

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
