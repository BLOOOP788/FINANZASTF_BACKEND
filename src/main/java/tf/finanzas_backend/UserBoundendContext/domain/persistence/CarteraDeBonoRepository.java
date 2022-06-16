package tf.finanzas_backend.UserBoundendContext.domain.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tf.finanzas_backend.UserBoundendContext.domain.entity.CarteraDeBono;
import tf.finanzas_backend.UserBoundendContext.domain.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarteraDeBonoRepository extends JpaRepository<CarteraDeBono, Long> {
    List<CarteraDeBono> findByUserId(Long userId);
    Page<CarteraDeBono> findByUserId(Long userId, Pageable pageable);
    Optional<CarteraDeBono> findByIdAndUserId(Long id, Long userId);
    Optional<CarteraDeBono>findById(Long id);
}
