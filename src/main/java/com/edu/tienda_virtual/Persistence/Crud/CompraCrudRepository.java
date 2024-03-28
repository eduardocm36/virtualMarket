package com.edu.tienda_virtual.Persistence.Crud;

import com.edu.tienda_virtual.Persistence.Entities.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

    Optional<List<Compra>> findByIdCliente(String idClient);

}
