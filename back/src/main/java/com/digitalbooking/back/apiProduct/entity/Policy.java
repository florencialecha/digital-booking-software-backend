package com.digitalbooking.back.apiProduct.entity;

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
    @Column(name = "RULES_DESCRIPTION")
    private String rulesDescription;
    @Column(name = "SECURITY_DESCRIPTION")
    private String securityDescription;
    @Column(name = "CANCELLATION_DESCRIPTION")
    private String cancellationDescription;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

}
