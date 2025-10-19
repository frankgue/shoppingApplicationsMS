package com.gkfcsolution.inventoryservice;

import com.gkfcsolution.inventoryservice.entity.Inventory;
import com.gkfcsolution.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository){
        return args -> {
            Inventory inventory = Inventory.builder()
                    .skuCode("Iphone17")
                    .quantity(100)
                    .build();

            Inventory inventory1 = Inventory.builder()
                    .skuCode("Iphone17_red")
                    .quantity(0)
                    .build();
//            inventoryRepository.saveAll(List.of(inventory, inventory1));
        };
    }

}
