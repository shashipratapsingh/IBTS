package CodeJdbcTemplete.model;

import lombok.*;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class University {
    private Long id;
    private String universityName;
    private String universityCity;
    private String universityAddress;
    private String universityContact;
    private String universityEmail;
    private String universityZipCode;
    private String remark;
    private LocalDateTime createBy; // Change to LocalDateTime
    private LocalDateTime updateBy; // Change to LocalDateTime
}
