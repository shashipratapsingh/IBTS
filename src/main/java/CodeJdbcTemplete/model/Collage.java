package CodeJdbcTemplete.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Collage {
    private int id;
    private Long collageId;
    private String collageName;
    private String collageType;
    private String collageDescription;
    private String collageStatus;
    private String collageCity;
    private String collageDate;
    private String collageLocation;
    private String collageContact;
    private String collageContactEmail;
    private LocalDateTime createdBy;
    private LocalDateTime updatedBy;
}