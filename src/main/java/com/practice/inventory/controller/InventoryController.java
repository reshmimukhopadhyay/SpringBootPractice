package com.practice.inventory.controller;

import com.practice.inventory.entities.InventoryEntity;
import com.practice.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;


    @PostMapping("/saveProduct")
    public ResponseEntity<InventoryEntity> addProduct(@RequestBody InventoryEntity product) {
        try {
            InventoryEntity inventoryProduct = inventoryRepository.save(product);
            return new ResponseEntity<>(inventoryProduct, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<InventoryEntity>> getAllProduct() {
        try {
            List<InventoryEntity> productList = new ArrayList<>();
            inventoryRepository.findAll().forEach(productList::add);

            if (productList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<InventoryEntity> getProductById(@PathVariable Integer productId) {
        try {
            Optional<InventoryEntity> product = inventoryRepository.findById(productId);
            if (product.isPresent()) {
                return new ResponseEntity<>(product.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}

