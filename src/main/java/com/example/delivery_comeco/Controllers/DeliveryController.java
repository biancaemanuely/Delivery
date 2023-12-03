package com.example.delivery_comeco.Controllers;

import com.example.delivery_comeco.domain.delivery.Delivery;
import com.example.delivery_comeco.domain.delivery.DeliveryRepository;

import com.example.delivery_comeco.domain.delivery.RequestDelivery;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/delivery")
public class DeliveryController { 
    @Autowired
    private DeliveryRepository repository;
    @GetMapping
    public ResponseEntity<List<Delivery>> getAllDelivery(){
        var allDelivery = repository.findAll();
        return ResponseEntity.ok(allDelivery);
    }

    @PostMapping
    public ResponseEntity registerDelivery(@RequestBody @Valid RequestDelivery data){
        Delivery newDelivery = new Delivery(data);
        repository.save(newDelivery);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateDelivery (@RequestBody @Valid RequestDelivery data){
        Optional<Delivery> optionalDelivery = repository.findById(data.id());
        if(optionalDelivery.isPresent()){
            Delivery delivery = optionalDelivery.get();
            delivery.setName(data.name());
            delivery.setCpf(data.cpf());
            delivery.setCapacidadedoveiculo(data.capacidadedoveiculo());
            return ResponseEntity.ok(delivery);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDelivery(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
