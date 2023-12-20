package com.alby.rsud.dto.medsupport.request;

import com.alby.rsud.entity.master.Contract;
import com.alby.rsud.entity.master.Employee;
import com.alby.rsud.entity.master.Vendor;
import com.alby.rsud.entity.medsupport.MedSupportTechTeam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedSupportAddRequest {

    private Contract contract;

    private String spNumber;

    private String invoiceNumber;

    private String bphpNumber;

    private String bastpNumber;

    private Employee firstPpk;

    private Employee secondPpk;

    private Employee pa;

    private Employee pptk;

    private Vendor vendor;

    private String jobDescription;

    private String activity;

    private LocalDate jobStart;

    private LocalDate jobFinish;

    private String skTechTeamNumber;

    private String skPpkNumber;

    private List<MedSupportTechTeam> techTeams;

    private BigDecimal contractValue;
}
