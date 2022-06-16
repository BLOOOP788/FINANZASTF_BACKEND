package tf.finanzas_backend.UserBoundendContext.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
public class UpdateCarteraDeBonoResource {
    private Long id;
    @NotNull
    private  Long userId;
    @NotNull
    private  Float valorNominal;
    @NotNull

    private  Float tasaCupon;
    @NotNull

    private  Float periodoDePago;
    @NotNull

    private  Float vencimiento;
    @NotNull

    private  Float tasaNegociacion;
    @NotNull

    private  Float tipoMetodo;
    @NotNull

    private  Float tipoMoneda;

}
