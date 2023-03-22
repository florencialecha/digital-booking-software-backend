package com.digitalbooking.back.bookStayApp.policies;

import com.digitalbooking.back.bookStayApp.products.domain.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "POLICY")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POLICY_ID")
    private Long id;
    @Column(name = "RULES")
    private String rules;
    @Column(name = "SECURITY")
    private String security;
    @Column(name = "CANCELLATION")
    private String cancellation;

    @JsonIgnore
    @OneToOne(mappedBy = "policy")
    private Product product;
}
