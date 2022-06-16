package tf.finanzas_backend.UserBoundendContext.mapping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import tf.finanzas_backend.UserBoundendContext.domain.entity.CarteraDeBono;
import tf.finanzas_backend.UserBoundendContext.resource.CarteraDeBonoResource;
import tf.finanzas_backend.UserBoundendContext.resource.CarteraDeBonos;
import tf.finanzas_backend.UserBoundendContext.resource.CreateCarteraDeBonoResource;
import tf.finanzas_backend.UserBoundendContext.resource.UpdateCarteraDeBonoResource;
import tf.finanzas_backend.shared.mapping.EnhancedModelMapper;

import java.util.List;

public class CarteraDeBonoMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public CarteraDeBonoResource toResource(CarteraDeBono model){
        return mapper.map(model,CarteraDeBonoResource.class);

    }
    public CarteraDeBonos toResourceList(CarteraDeBono model){
        return mapper.map(model,CarteraDeBonos.class);
    }

    public Page<CarteraDeBonoResource> modelToListToPage(List<CarteraDeBono> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,CarteraDeBonoResource.class),pageable,modelList.size());
    }
    public Page<CarteraDeBonos> modelToListToPage2(List<CarteraDeBono> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,CarteraDeBonos.class),pageable,modelList.size());
    }
    public CarteraDeBono toModel(CreateCarteraDeBonoResource resource){
        return  mapper.map(resource,CarteraDeBono.class);
    }
    public CarteraDeBono toModel(UpdateCarteraDeBonoResource resource){
        return  mapper.map(resource,CarteraDeBono.class);
    }
}

