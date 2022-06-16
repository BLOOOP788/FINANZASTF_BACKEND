package tf.finanzas_backend.UserBoundendContext.resource;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResource {

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;

}
