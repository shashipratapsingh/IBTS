package CodeJdbcTemplete.model;

import lombok.*;

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
}
