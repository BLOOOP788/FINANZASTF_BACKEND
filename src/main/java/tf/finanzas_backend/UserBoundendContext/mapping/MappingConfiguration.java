package tf.finanzas_backend.UserBoundendContext.mapping;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("UsersMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }
}
