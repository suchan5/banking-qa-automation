package com.suchan.qa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.text.DateFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteUserResponse {
    private Integer id;
    private String firstName;
    private Integer age;
    private Boolean isDeleted;
    private String deletedOn;
}
