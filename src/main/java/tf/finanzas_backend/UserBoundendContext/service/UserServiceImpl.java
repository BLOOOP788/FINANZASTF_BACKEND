package tf.finanzas_backend.UserBoundendContext.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tf.finanzas_backend.UserBoundendContext.domain.entity.User;
import tf.finanzas_backend.UserBoundendContext.domain.persistence.UserRepository;
import tf.finanzas_backend.UserBoundendContext.domain.service.UserService;
import tf.finanzas_backend.UserBoundendContext.resource.AuthenticateRequest;
import tf.finanzas_backend.shared.exception.ResourceNotFoundException;
import tf.finanzas_backend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
@Service
public class UserServiceImpl implements UserService {

    private static final  String ENTITY="usuario";
    private final UserRepository userRepository;
    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException(ENTITY,userId));
    }

    @Override
    public User create(User user) {
        Set<ConstraintViolation<User>> violations =validator.validate(user);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);
        User driverWithEmail=userRepository.findByEmail(user.getEmail());

        if(driverWithEmail!=null){
            throw new ResourceValidationException(ENTITY,"A user with the same Email already exist");
        }
        return userRepository.save(user);
    }

    @Override
    public User update(Long userId, User request) {
        Set<ConstraintViolation<User>> violations =validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);
        // Uniquessnes Validation
        User driverRepositoryByEmail=userRepository.findByEmail(request.getEmail());
        if(driverRepositoryByEmail!=null&& !driverRepositoryByEmail.getId().equals(userId)){
            throw new ResourceValidationException(ENTITY,"A post with the same email  already exist");
        }
        return userRepository.findById(userId).map(post->userRepository.save(post.withName(
                request
                        .getName())
                        .withEmail(request.getEmail())
                        .withPassword(request.getPassword())
                ))
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,userId));
    }

    @Override
    public ResponseEntity<?> delete(Long userId) {
        return userRepository.findById(userId).map(driver->{
            userRepository.delete(driver);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY,userId));
    }

    @Override
    public User authenticate(AuthenticateRequest request) {
        User h=userRepository.findByEmail(request.getEmail());
        return userRepository.findById(h.getId()).orElseThrow(()->new ResourceNotFoundException(ENTITY,h.getId()));
    }
}
