package com.edu.tienda_virtual.Persistence;

import com.edu.tienda_virtual.Domain.Purchase;
import com.edu.tienda_virtual.Domain.Repositories.PurchaseRepository;
import com.edu.tienda_virtual.Persistence.Crud.CompraCrudRepository;
import com.edu.tienda_virtual.Persistence.Entities.Compra;
import com.edu.tienda_virtual.Persistence.Mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        List<Compra> compras = (List<Compra>) compraCrudRepository.findAll();
        return mapper.toPurchases(compras);
    }

    @Override
    public Optional<List<Purchase>> getByClient(String idClient) {
        Optional<List<Compra>> compras = compraCrudRepository.findByIdCliente(idClient);
        return compras.map(compra -> mapper.toPurchases(compra));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getCompraProducto().forEach(compraProducto -> compraProducto.setCompra(compra));
        //Compra compra = compraCrudRepository.save(mapper.toCompra(purchase));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
