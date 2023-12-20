package com.alby.rsud.serviceimpl.master;

import com.alby.rsud.dto.medsupport.request.MedSupportAddRequest;
import com.alby.rsud.dto.medsupport.request.MedSupportUpdateRequest;
import com.alby.rsud.dto.medsupport.response.MedSupportHeaderResponse;
import com.alby.rsud.service.medsupport.MedSupportService;

import java.util.List;

public class MedSupportServiceImpl implements MedSupportService {
    @Override
    public List<MedSupportHeaderResponse> findAll() {
        return null;
    }

    @Override
    public Boolean submit(MedSupportAddRequest request) {
        return null;
    }

    @Override
    public MedSupportHeaderResponse findById(Long id) {
        return null;
    }

    @Override
    public Boolean update(MedSupportUpdateRequest request) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
