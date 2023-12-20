package com.alby.rsud.service.medsupport;

import com.alby.rsud.dto.master.position.request.PositionAddRequest;
import com.alby.rsud.dto.master.position.request.PositionUpdateRequest;
import com.alby.rsud.dto.master.position.response.PositionResponse;
import com.alby.rsud.dto.medsupport.request.MedSupportAddRequest;
import com.alby.rsud.dto.medsupport.request.MedSupportUpdateRequest;
import com.alby.rsud.dto.medsupport.response.MedSupportHeaderResponse;

import java.util.List;

public interface MedSupportService {

    List<MedSupportHeaderResponse> findAll();

    Boolean submit(MedSupportAddRequest request);

    MedSupportHeaderResponse findById(Long id);

    Boolean update(MedSupportUpdateRequest request);

    Boolean delete(Long id);
}
