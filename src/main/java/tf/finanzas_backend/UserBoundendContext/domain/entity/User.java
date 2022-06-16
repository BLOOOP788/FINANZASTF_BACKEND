package tf.finanzas_backend.UserBoundendContext.domain.entity;

import lombok.*;
import tf.finanzas_backend.shared.domain.model.AuditModel;

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
@Table(name="usuario")
public class User extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private  String name;

    @NotNull
    @NotBlank
    @Size(max=100)
    @Column(unique = true)
    private  String email;

    @NotNull
    @NotBlank
    @Column()
    private  String password;
}
