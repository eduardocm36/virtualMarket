package com.edu.tienda_virtual.Domain.Repositories;

import com.edu.tienda_virtual.Domain.Purchase;
import org.springframework.boot.autoconfigure.pulsar.PulsarConnectionDetails;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();

    Optional<List<Purchase>> getByClient(String idClient);

    Purchase save (Purchase purchase);

}
