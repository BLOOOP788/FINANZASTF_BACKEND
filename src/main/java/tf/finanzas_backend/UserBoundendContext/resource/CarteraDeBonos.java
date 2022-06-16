package tf.finanzas_backend.UserBoundendContext.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CarteraDeBonos {
    private Long id;
    private  Long userId;
    private  Float valorNominal;
    private  Float tasaCupon;
    private  Long periodoDePago;
    private  Float vencimiento;
    private  Float tasaNegociacion;
    private  Long tipoMetodo;
    private  Long tipoMoneda;
}
