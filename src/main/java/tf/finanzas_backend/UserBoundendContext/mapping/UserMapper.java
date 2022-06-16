package tf.finanzas_backend.UserBoundendContext.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import tf.finanzas_backend.UserBoundendContext.domain.entity.User;
import tf.finanzas_backend.UserBoundendContext.resource.CreateUserResource;
import tf.finanzas_backend.UserBoundendContext.resource.UpdateUserResource;
import tf.finanzas_backend.UserBoundendContext.resource.UserResource;
import tf.finanzas_backend.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    //Object Mapping
    public UserResource toResource(User model){
        return  mapper.map(model,UserResource.class);
    }
    public Page<UserResource> modelListToPage(List<User> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,UserResource.class),pageable, modelList.size());
    }

    public User toModel(CreateUserResource resource){
        return mapper.map(resource,User.class);
    }

    public User toModel(UpdateUserResource resource){
        return mapper.map(resource,User.class);
    }

}
