package CodeJdbcTemplete.controller;

import CodeJdbcTemplete.CustomException.GlobleExceptionHandle;
import CodeJdbcTemplete.model.Collage;
import CodeJdbcTemplete.service.CollageService;
import CodeJdbcTemplete.utill.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
            Optional<Collage> collage=collageService.findByCollageId(collageId);
            if (collage.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constant.COLLAGE_ID);
            }
            return ResponseEntity.status(HttpStatus.OK).body(collage.toString());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constant.COLLAGE_ID);
        }
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Collage>> findAllCollage() {
        try {
            List<Collage> collage=collageService.findAll();
            if (collage.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }catch (Exception e) {
            throw new GlobleExceptionHandle(Constant.NOT_FOUND);
        }
        return new ResponseEntity<>(this.collageService.findAll(),HttpStatus.OK);
    }


}
