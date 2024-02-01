package com.edu.tienda_virtual.Domain.Repositories;

import com.edu.tienda_virtual.Domain.Product;
import com.edu.tienda_virtual.Persistence.Entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAll();

    Optional<List<Product>> getByCategory(int idCategory);

    Optional<List<Product>> getScarseProduct(int quantity);

    Optional<Product> getProduct(int idProduct);

    Product saveProduct(Product product);

    void deleteProduct(int idProduct);
}
