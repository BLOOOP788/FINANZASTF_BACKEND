package tf.finanzas_backend.UserBoundendContext.resource;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CarteraDeBonoResource {
    private Long id;
    private Long userId;
    private Float valorNominal;
    private Float tasaCupon;
    private Long periodoDePago;
    private Float vencimiento;
    private Float tasaNegociacion;
    private Long tipoMetodo;
    private Long tipoMoneda;
}
