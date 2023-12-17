package com.alby.rsud.service;

import com.alby.rsud.dto.master.vendor.request.VendorAddRequest;
import com.alby.rsud.dto.master.vendor.request.VendorUpdateRequest;
import com.alby.rsud.dto.master.vendor.response.VendorResponse;

import java.util.List;

public interface VendorService {

    List<VendorResponse> findAll();

    Boolean submit(VendorAddRequest request);

    VendorResponse findById(Long id);

    Boolean update(VendorUpdateRequest request);

    Boolean delete(Long id);
}
