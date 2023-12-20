package com.alby.rsud.serviceimpl.master;

import com.alby.rsud.dto.master.vendor.request.VendorAddRequest;
import com.alby.rsud.dto.master.vendor.request.VendorUpdateRequest;
import com.alby.rsud.dto.master.vendor.response.VendorResponse;
import com.alby.rsud.entity.master.Vendor;
import com.alby.rsud.repository.master.VendorRepository;
import com.alby.rsud.service.master.VendorService;
import com.alby.rsud.utils.master.VendorUtils;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    private final Validator validator;

    @Override
    public List<VendorResponse> findAll() {
        return VendorUtils.mapVendorsToVendorsResponse(vendorRepository.findAll());
    }

    @Override
    public Boolean submit(VendorAddRequest request) {
        validator.validate(request);

        Vendor vendor = VendorUtils.mapVendorAddRequestToVendor(request);
        vendorRepository.save(vendor);

        return null != vendor.getId();
    }

    @Override
    public VendorResponse findById(Long id) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        return vendor.map(VendorUtils::mapVendorToVendorResponse).orElse(null);
    }

    @Override
    public Boolean update(VendorUpdateRequest request) {
        validator.validate(request);
        vendorRepository.save(VendorUtils.mapVendorUpdateRequestToVendor(request));
        return true;
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if (vendor.isPresent()) {
            vendorRepository.delete(vendor.get());
            return true;
        }

        return false;
    }
}
