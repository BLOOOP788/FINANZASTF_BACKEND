package tf.finanzas_backend.UserBoundendContext.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tf.finanzas_backend.UserBoundendContext.domain.entity.CarteraDeBono;
import tf.finanzas_backend.UserBoundendContext.domain.persistence.CarteraDeBonoRepository;
import tf.finanzas_backend.UserBoundendContext.domain.persistence.UserRepository;
import tf.finanzas_backend.UserBoundendContext.domain.service.CarteraDeBonoService;
import tf.finanzas_backend.shared.exception.ResourceNotFoundException;
import tf.finanzas_backend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class CarteraDeBonosServiceImpl implements CarteraDeBonoService {

    private static final  String ENTITY="cartera_de_bonos";
    private final CarteraDeBonoRepository carteraDeBonoRepository;
    private final UserRepository userRepository;
    //validator de tipo JAVAX
    private final Validator validator;

    public CarteraDeBonosServiceImpl(CarteraDeBonoRepository carteraDeBonoRepository, UserRepository userRepository, Validator validator) {
        this.carteraDeBonoRepository = carteraDeBonoRepository;
        this.userRepository = userRepository;
        this.validator = validator;
    }


    @Override
    public List<CarteraDeBono> getAll() {
        return null;
    }

    @Override
    public List<CarteraDeBono> getAllByUserId(Long userId) {
        return  carteraDeBonoRepository.findByUserId(userId);
    }

    @Override
    public Page<CarteraDeBono> getAllByUserId(Long userId, Pageable pageable) {
        return  carteraDeBonoRepository.findByUserId(userId,pageable);
    }

    @Override
    public CarteraDeBono getById(Long carteraDeBonoId) {
        return carteraDeBonoRepository.findById(carteraDeBonoId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, carteraDeBonoId));
    }

    @Override
    public CarteraDeBono create(Long userId, CarteraDeBono request) {
        Set<ConstraintViolation<CarteraDeBono>> violations=validator.validate(request);
        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY,violations);
        }

        return userRepository.findById(userId).map(nuevito -> {
            request.setUsuario(nuevito);
            return carteraDeBonoRepository.save(request);
        }).orElseThrow(()-> new ResourceNotFoundException("User",userId));
    }

    @Override
    public CarteraDeBono update(Long userId, Long CarteraDeBonoId, CarteraDeBono request) {
        Set<ConstraintViolation<CarteraDeBono>> violations = validator.validate(request);
        //Set<Traveler> travelers = request.getPassengers().stream().collect(Collectors.toSet());
        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY,violations);
        }

        if (!userRepository.existsById(userId))
            throw new ResourceNotFoundException("Post",userId);
        return carteraDeBonoRepository.findById(CarteraDeBonoId).map(comment ->
                        carteraDeBonoRepository.save(
                                comment.withUserId(request.getUserId())
                                .withValorNominal(request.getValorNominal())
                                .withTasaCupon(request.getTasaCupon())
                                .withPeriodoDePago(request.getPeriodoDePago())
                                .withVencimiento(request.getVencimiento())
                                .withTasaNegociacion(request.getTasaNegociacion())
                                .withTipoMetodo(request.getTipoMetodo())
                                .withTipoMoneda(request.getTipoMoneda())
                        ))
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,userId));
    }

    @Override
    public ResponseEntity<?> delete(Long userId, Long CarteraDeBonoId) {
        return carteraDeBonoRepository.findByIdAndUserId(userId,CarteraDeBonoId).map(comment ->
        {
            carteraDeBonoRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY,CarteraDeBonoId));

    }
}
