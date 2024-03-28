package com.edu.tienda_virtual.Domain.Services;

import com.edu.tienda_virtual.Domain.Product;
import com.edu.tienda_virtual.Domain.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<List<Product>> getByCategory(int idCategory){
        return productRepository.getByCategory(idCategory);
    }

    public Optional<List<Product>> getScarseProduct(int quantity){
        return productRepository.getScarseProduct(quantity);
    };

    public Optional<Product> getProduct(int idProduct){
        return productRepository.getProduct(idProduct);
    }

    public Product saveProduct(Product product){
        return productRepository.saveProduct(product);
    }

    public boolean deleteProduct(int idProduct){
        //AMBOS HACEN LO MISMO
        //return getProduct(idProduct).map(product -> {
        //    productRepository.deleteProduct(idProduct);
        //    return true;
        //}).orElse(false);
        if (getProduct(idProduct).isPresent()){
            productRepository.deleteProduct(idProduct);
            return true;
        }
        return false;

    }

}
