package tf.finanzas_backend.UserBoundendContext.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthenticateRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
