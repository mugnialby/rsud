package com.alby.rsud.entity.master;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "mst_vendor")
public class Vendor {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(
            name = "vendor_name",
            nullable = false
    )
    private String vendorName;

    @ManyToOne
    @JoinColumn(
            name = "bank_id"
    )
    private Bank bank;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    private String status;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_at")
    private Instant modifiedAt;
}
