package tf.finanzas_backend.UserBoundendContext.api;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tf.finanzas_backend.UserBoundendContext.domain.service.UserService;
import tf.finanzas_backend.UserBoundendContext.mapping.UserMapper;
import tf.finanzas_backend.UserBoundendContext.resource.AuthenticateRequest;
import tf.finanzas_backend.UserBoundendContext.resource.CreateUserResource;
import tf.finanzas_backend.UserBoundendContext.resource.UpdateUserResource;
import tf.finanzas_backend.UserBoundendContext.resource.UserResource;

@Tag(name="user")
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }
    @GetMapping()
    public Page<UserResource> getAllDriver(Pageable pageable){

        return mapper.modelListToPage(userService.getAll(),pageable);
    }
    @GetMapping("{userId}")
    public UserResource getDriverById(@PathVariable Long userId){
        return mapper.toResource(userService.getById(userId));
    }
    @PostMapping
    public UserResource createDriver(@RequestBody CreateUserResource request){
        return mapper.toResource(userService.create(mapper.toModel(request)));
    }
    @PutMapping("{userId}")
    public UserResource updateDriver(@PathVariable Long userId, @RequestBody UpdateUserResource request){
        return mapper.toResource(userService.update(userId,mapper.toModel(request)));
    }
    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteDriver(@PathVariable Long userId){
        return  userService.delete(userId);
    }
    @PostMapping("/auth/log-in")
    public UserResource authenticate(@RequestBody AuthenticateRequest request){
        return mapper.toResource(userService.authenticate(request));
    }
}
