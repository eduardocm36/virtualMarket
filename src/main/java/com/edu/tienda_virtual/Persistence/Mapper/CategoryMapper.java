package com.edu.tienda_virtual.Persistence.Mapper;

import com.edu.tienda_virtual.Domain.Category;
import com.edu.tienda_virtual.Persistence.Entities.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategoria", target = "idCategory"),
            @Mapping(source = "descripcionCategoria", target = "nameCategory"),
            @Mapping(source = "estadoCategoria", target = "statusCategory")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration //hace la operacion inversa a la anterior
    @Mapping(target = "productos", ignore = true)
    Categoria toCategory(Category category);

}
