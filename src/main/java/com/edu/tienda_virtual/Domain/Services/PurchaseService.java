package com.edu.tienda_virtual.Domain.Services;

import com.edu.tienda_virtual.Domain.Purchase;
import com.edu.tienda_virtual.Domain.Repositories.PurchaseRepository;
import com.edu.tienda_virtual.Persistence.Entities.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String idClient) {
        return purchaseRepository.getByClient(idClient);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

}
