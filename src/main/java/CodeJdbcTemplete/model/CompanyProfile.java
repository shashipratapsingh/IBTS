package CodeJdbcTemplete.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "company_profiles")
public class CompanyProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true, nullable = false, length = 50)
    private String registerNumber; // Unique company registration number

    @Column(nullable = false, length = 100)
    private String companyName; // Company name

    @Column(nullable = false, length = 255)
    private String address; // Full address

    @Column(nullable = false, length = 15)
    private String phone; // Company phone number

    @Column(nullable = false, length = 100)
    private String email; // Company email

    @Column(length = 100)
    private String website; // Optional company website URL

    @Column(length = 100)
    private String ceoName; // CEO or head of the company

    @Column(length = 50)
    private String industryType; // Type of industry (e.g., IT, Finance, Manufacturing)

    @Column(length = 20)
    private String companySize; // Number of employees or size category (Small, Medium, Large)

    @Column(length = 50)
    private String country; // Country where the company is located

    @Column(length = 50)
    private String city; // City where the company is based

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // Auto-generated creation timestamp

    @Column(nullable = false)
    private LocalDateTime updatedAt; // Auto-generated last update timestamp

    @Column(nullable = false, length = 50)
    private String createdBy; // The user or system that created the record

    @Column(nullable = false, length = 50)
    private String updatedBy; // The user or system that last updated the record

    // Optionally, you can add audit fields
    @Column(length = 255)
    private String remarks; // General remarks or notes about the company

    // PrePersist and PreUpdate annotations to handle automatic timestamping
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
