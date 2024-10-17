package CodeJdbcTemplete.model;

import lombok.*;

import java.time.LocalDate;
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
    private String createBy;
    private String updateBy;
}
