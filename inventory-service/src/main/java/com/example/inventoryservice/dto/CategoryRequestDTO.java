package com.example.inventoryservice.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class CategoryRequestDTO {

    private String name;
    private String description;

}
