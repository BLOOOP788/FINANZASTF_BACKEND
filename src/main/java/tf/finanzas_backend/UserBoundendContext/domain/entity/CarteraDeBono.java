package tf.finanzas_backend.UserBoundendContext.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name="cartera_de_bonos")
public class CarteraDeBono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToOne(fetch =FetchType.LAZY,optional = false)
    @JoinColumn(name = "usuario_id",nullable = false)
    @JsonIgnore
    private User usuario;
}
