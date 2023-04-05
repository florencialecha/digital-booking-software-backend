package com.digitalbooking.back.bookStayApp.policies.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PolicyToCreateDTO {
    private String rules;
    private String security;
    private String cancellation;

}
