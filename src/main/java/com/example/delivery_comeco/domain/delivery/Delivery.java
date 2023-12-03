package com.example.delivery_comeco.domain.delivery;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "delivery")
@Entity(name = "/delivery")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer cpf;

    private Integer capacidadedoveiculo;

    public Delivery(RequestDelivery requestDelyvery){
        this.name = requestDelyvery.name();
        this.cpf = requestDelyvery.cpf();
        this.capacidadedoveiculo = requestDelyvery.capacidadedoveiculo();
    }
}
