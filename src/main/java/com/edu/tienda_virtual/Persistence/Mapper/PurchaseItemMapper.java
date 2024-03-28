package com.edu.tienda_virtual.Persistence.Mapper;

import com.edu.tienda_virtual.Domain.PurchaseItem;
import com.edu.tienda_virtual.Persistence.Entities.CompraProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "idProduct"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "estado", target = "status"),
    })
    PurchaseItem toPurchaseItem (CompraProducto compraProducto);

     @InheritInverseConfiguration
     @Mappings({
             @Mapping(target = "compra", ignore = true),
             @Mapping(target = "producto", ignore = true),
             @Mapping(target = "id.idCompra", ignore = true)
     })
    CompraProducto toCompraProducto (PurchaseItem purchaseItem);

}
