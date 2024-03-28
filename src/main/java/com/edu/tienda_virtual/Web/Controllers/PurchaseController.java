package com.edu.tienda_virtual.Web.Controllers;

import com.edu.tienda_virtual.Domain.Purchase;
import com.edu.tienda_virtual.Domain.Services.PurchaseService;
import com.edu.tienda_virtual.Persistence.Entities.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idClient") String idClient) {
        return purchaseService.getByClient(idClient)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }


}
