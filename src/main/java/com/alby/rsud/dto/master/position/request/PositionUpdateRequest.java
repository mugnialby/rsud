package com.alby.rsud.dto.master.position.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionUpdateRequest {
    private Long id;

    private String name;

    private String createdBy;

    private String modifiedBy;
}
