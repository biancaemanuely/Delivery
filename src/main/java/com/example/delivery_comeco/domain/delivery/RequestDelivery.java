package com.example.delivery_comeco.domain.delivery;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestDelivery(
        String id,

        @NotBlank
        String name,

        @NotNull
        Integer cpf,

        @NotNull
        Integer capacidadedoveiculo){
}
