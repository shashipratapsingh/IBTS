package CodeJdbcTemplete.controller;

import CodeJdbcTemplete.CustomException.GlobleExceptionHandle;
import CodeJdbcTemplete.model.University;
import CodeJdbcTemplete.service.UniversityService;
import CodeJdbcTemplete.utill.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("/saveUniversity")
    public ResponseEntity<String> saveUniversity(@RequestBody University university) {
        // Check if a university with the given email already exists
        University existingUniversityResponse = universityService.getUniversityByEmailOnly(university.getUniversityEmail());

        if (existingUniversityResponse != null) {
            // Return a 409 Conflict response if the email already exists
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Constant.EMAIL_ALREADY_EXIST);
        }
        try {
            // Set timestamps before saving
            university.setCreateBy(LocalDateTime.now()); // Set creation time
            university.setUpdateBy(LocalDateTime.now()); // Set update time (same as create for new entries)
            // Save the new university as no conflict was found
            universityService.saveUniversity(university);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("University saved successfully!");
        } catch (Exception e) {
            // Handle any other exceptions that occur during saving
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Constant.INVALID_INPUT_PAYLOAD);
        }
    }
    @GetMapping("/getUniversityById/{id}")
    public ResponseEntity<?> getUniversityById(@PathVariable int id) {
        try {
            University university = universityService.getUniversityById(id);
            if (university != null)
                return ResponseEntity.ok(university);
            else
                return ResponseEntity.noContent().build();

        }catch (GlobleExceptionHandle e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No university found with ID: " + id);
        }
    }

    @GetMapping("/getUniversityByEmailId/{universityEmail}")
    public ResponseEntity<?> getUniversityByEmail(@PathVariable String universityEmail) {
        try {
            University university = universityService.findByEmail(universityEmail);
            if (university != null)
                return ResponseEntity.ok(university);
            else
                return ResponseEntity.noContent().build();
        }catch (GlobleExceptionHandle e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No university found with Email ID: " + universityEmail);
        }
    }


}
