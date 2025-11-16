package org.pm.springjpamongodb.dto;

import lombok.*;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String name;
    private String city;
    private int price;
}
