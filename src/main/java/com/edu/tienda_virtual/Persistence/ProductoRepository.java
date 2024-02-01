package com.edu.tienda_virtual.Persistence;

import com.edu.tienda_virtual.Domain.Product;
import com.edu.tienda_virtual.Domain.Repositories.ProductRepository;
import com.edu.tienda_virtual.Persistence.Crud.ProductoCrudRepository;
import com.edu.tienda_virtual.Persistence.Entities.Producto;
import com.edu.tienda_virtual.Persistence.Mapper.ProductMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        List<Product> products = mapper.toProducts(productos);
        return products;
    }

    @Override
    public Optional<List<Product>> getByCategory(int idCategoria) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
        List<Product> products = mapper.toProducts(productos);
        return Optional.of(products);
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int cantidad){
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int idProduct){
        Optional<Producto> producto = productoCrudRepository.findById(idProduct);
        return producto.map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product saveProduct(Product product){
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void deleteProduct(int idProduct){
        productoCrudRepository.deleteById(idProduct);
    }

}
