package CodeJdbcTemplete.controller;

import CodeJdbcTemplete.model.Collage;
import CodeJdbcTemplete.service.CollageService;
import CodeJdbcTemplete.utill.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1")
public class CollageController {
    private final CollageService collageService;

    public CollageController(CollageService collageService) {
        this.collageService = collageService;
    }

    @PostMapping("/registerCollage")
    public ResponseEntity<String> registerCollage(@RequestBody Collage collage) {
        try {
            collage.setCreatedBy(LocalDateTime.now()); // Set creation time
            collage.setUpdatedBy(LocalDateTime.now());
            collageService.registerCollage(collage);
            return ResponseEntity.status(HttpStatus.CREATED).body(collage.toString());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Constant.INVALID_INPUT_PAYLOAD);
        }
    }

    @GetMapping("getCollageById/{collageId}")
    public ResponseEntity<String> getCollageById(@PathVariable long collageId) {
        try{
            Collage collage=collageService.findByCollageId(collageId);
            if (collage!=null) {
                return ResponseEntity.status(HttpStatus.OK).body(Constant.COLLAGE_ID);
            }
            return ResponseEntity.status(HttpStatus.OK).body(collage.toString());
        }catch (Exception e) {

        }
        return null;
    }


}
