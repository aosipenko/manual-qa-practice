package org.prog.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonDto {
    private Long id;

    private String gender;

    private String nationatlity;

    private NameDto name;
}
