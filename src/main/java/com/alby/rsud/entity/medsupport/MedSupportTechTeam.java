package com.alby.rsud.entity.medsupport;

import com.alby.rsud.entity.master.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tr_med_support_tech_team")
public class MedSupportTechTeam {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "med_support_header_id")
    private MedSupportHeader medSupportHeader;

    @ManyToOne
    @JoinColumn(name = "tech_team_member_id")
    private Employee techTeamMember;

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
