package com.edu.tienda_virtual.Persistence.Mapper;

import com.edu.tienda_virtual.Domain.Product;
import com.edu.tienda_virtual.Persistence.Entities.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "idCategory"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category")
    })
    Product toProduct (Producto producto);
    //No hacemos el mapping como el anterior porque spring automaticamente asume que hara esa operacion
    List<Product> toProducts (List<Producto> productos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "codigoBarras", ignore = true),
    })
    Producto toProducto (Product product);


}
