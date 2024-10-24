package CodeJdbcTemplete.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "Collage")
public class Collage {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private Long collageId;
    private String collageName;
    private String collageType;
    private String collageDescription;
    private String collageStatus;
    private String collageCity;
    private Date collageDate;
    private String collageLocation;
    private String collageContact;
    private String collageContactEmail;
    private LocalDateTime createdBy;
    private LocalDateTime updatedBy;
}
