package tf.finanzas_backend.UserBoundendContext.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import tf.finanzas_backend.UserBoundendContext.domain.entity.User;
import tf.finanzas_backend.UserBoundendContext.resource.AuthenticateRequest;

import java.util.List;

public interface UserService {
    List<User> getAll();
    Page<User> getAll(Pageable pageable);
    User getById(Long userId);
    User create(User user);
    User update(Long userId, User request);
    ResponseEntity<?> delete(Long userId);
    User authenticate (AuthenticateRequest request);
}
