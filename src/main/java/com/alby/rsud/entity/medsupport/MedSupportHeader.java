package com.alby.rsud.entity.medsupport;

import com.alby.rsud.entity.master.Contract;
import com.alby.rsud.entity.master.Employee;
import com.alby.rsud.entity.master.Vendor;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tr_med_support_header")
public class MedSupportHeader {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @Column(name = "sp_number")
    private String spNumber;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "bphp_number")
    private String bphpNumber;

    @Column(name = "bastp_number")
    private String bastpNumber;

    @ManyToOne
    @JoinColumn(name = "first_ppk_id")
    private Employee firstPpk;

    @ManyToOne
    @JoinColumn(name = "second_ppk_id")
    private Employee secondPpk;

    @ManyToOne
    @JoinColumn(name = "pa_id")
    private Employee pa;

    @ManyToOne
    @JoinColumn(name = "pptk_id")
    private Employee pptk;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @Column(name = "job_description")
    private String jobDescription;

    private String activity;

    @Column(name = "job_start")
    private LocalDate jobStart;

    @Column(name = "job_finish")
    private LocalDate jobFinish;

    @Column(name = "sk_tech_team_number")
    private String skTechTeamNumber;

    @Column(name = "sk_ppk_number")
    private String skPpkNumber;

    @OneToMany(mappedBy = "medSupportHeader")
    private List<MedSupportTechTeam> techTeams = new ArrayList<>();

    private BigDecimal contractValue;

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
