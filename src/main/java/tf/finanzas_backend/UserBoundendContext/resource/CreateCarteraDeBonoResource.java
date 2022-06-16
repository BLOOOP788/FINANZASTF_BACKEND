package tf.finanzas_backend.UserBoundendContext.resource;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarteraDeBonoResource {
    @NotNull
    private  Long userId;
    @NotNull
    private  Float valorNominal;
    @NotNull

    private  Float tasaCupon;
    @NotNull

    private  Long periodoDePago;
    @NotNull

    private  Float vencimiento;
    @NotNull

    private  Float tasaNegociacion;
    @NotNull

    private  Long tipoMetodo;
    @NotNull

    private  Long tipoMoneda;
}
