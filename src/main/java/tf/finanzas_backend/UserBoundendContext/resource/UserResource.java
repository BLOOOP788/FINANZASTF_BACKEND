package tf.finanzas_backend.UserBoundendContext.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UserResource {
    private Long id;
    private String name;
    private String email;
    private String password;
}


