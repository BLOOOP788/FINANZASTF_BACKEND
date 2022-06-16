package tf.finanzas_backend.UserBoundendContext.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tf.finanzas_backend.UserBoundendContext.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByPassword(String dni);
    User findByEmail(String dni);

}
