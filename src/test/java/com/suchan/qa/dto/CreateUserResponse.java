package com.suchan.qa.dto;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
}
