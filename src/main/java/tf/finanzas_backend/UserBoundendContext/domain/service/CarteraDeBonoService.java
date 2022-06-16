package tf.finanzas_backend.UserBoundendContext.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import tf.finanzas_backend.UserBoundendContext.domain.entity.CarteraDeBono;

import java.util.List;

public interface CarteraDeBonoService {
    List<CarteraDeBono> getAll();
    List<CarteraDeBono> getAllByUserId(Long userId);
    Page<CarteraDeBono> getAllByUserId(Long userId, Pageable pageable);
    CarteraDeBono getById(Long carteraDeBonoId);
    CarteraDeBono create(Long userId, CarteraDeBono request);
    CarteraDeBono update(Long userId, Long CarteraDeBonoId, CarteraDeBono request);
    ResponseEntity<?> delete(Long userId, Long CarteraDeBonoId);
}
