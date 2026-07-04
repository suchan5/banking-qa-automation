package com.suchan.qa.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private Integer age;
}
