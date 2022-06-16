package tf.finanzas_backend.UserBoundendContext.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tf.finanzas_backend.UserBoundendContext.domain.entity.CarteraDeBono;
import tf.finanzas_backend.UserBoundendContext.domain.service.CarteraDeBonoService;
import tf.finanzas_backend.UserBoundendContext.mapping.CarteraDeBonoMapper;
import tf.finanzas_backend.UserBoundendContext.resource.CarteraDeBonoResource;
import tf.finanzas_backend.UserBoundendContext.resource.CarteraDeBonos;
import tf.finanzas_backend.UserBoundendContext.resource.CreateCarteraDeBonoResource;
import tf.finanzas_backend.UserBoundendContext.resource.UpdateCarteraDeBonoResource;

@Tag(name="historial")
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CarteraDeBonosController {
    private final CarteraDeBonoService carteraDeBonoService;
    private final CarteraDeBonoMapper mapper;

    public CarteraDeBonosController(CarteraDeBonoService carteraDeBonoService, CarteraDeBonoMapper mapper) {
        this.carteraDeBonoService = carteraDeBonoService;
        this.mapper = mapper;
    }
    @GetMapping("historial/{carteraId}")
    public CarteraDeBonoResource getPostById(@PathVariable Long carteraId){
        return mapper.toResource(carteraDeBonoService.getById(carteraId));
    }

    @GetMapping("user/{userId}/historial")
    public Page<CarteraDeBonos> getAllTravelEventsByPostId(@PathVariable Long userId, Pageable pageable){
        return mapper.modelToListToPage2(carteraDeBonoService.getAllByUserId(userId),pageable);
    }
    @PostMapping("user/{userId}/historial")
    public CarteraDeBonoResource createTravelEvent(@PathVariable Long userId, @RequestBody CreateCarteraDeBonoResource request){
        return mapper.toResource(carteraDeBonoService.create(userId,mapper.toModel(request)));
    }
    @PutMapping("user/{userId}/historial/{carteraId}")
    public CarteraDeBonoResource updateComment(@PathVariable Long userId,@PathVariable Long carteraId, @RequestBody UpdateCarteraDeBonoResource request){
        return mapper.toResource(carteraDeBonoService.update(userId,carteraId,mapper.toModel(request)));
    }
    @DeleteMapping("user/{userId}/historial/{carteraId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long userId, @PathVariable Long carteraId){
        return carteraDeBonoService.delete(userId,carteraId);
    }
}
