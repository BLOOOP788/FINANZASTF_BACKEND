package tf.finanzas_backend.UserBoundendContext.mapping2;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tf.finanzas_backend.UserBoundendContext.mapping.CarteraDeBonoMapper;
import tf.finanzas_backend.UserBoundendContext.mapping.UserMapper;

@Configuration("CarteraDeBonosMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public CarteraDeBonoMapper TravelEventMapper(){
        return new CarteraDeBonoMapper();
    }
}
