package com.edu.tienda_virtual.Persistence.Crud;

import com.edu.tienda_virtual.Persistence.Entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    // Ambas expresiones son iguales, pero si usamos notacion query no necesitamos usar el metodo de
    // las query methods (NOMBRES DE LOS METODOS)
    // @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);


}
