package com.digitalbooking.back.bookStayApp.policies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PolicyToCreateDTO {
    private String rules;
    private String security;
    private String cancellation;

}
