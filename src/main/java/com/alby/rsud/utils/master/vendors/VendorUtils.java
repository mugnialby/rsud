package com.alby.rsud.utils.master.vendors;

import com.alby.rsud.dto.master.vendor.request.VendorAddRequest;
import com.alby.rsud.dto.master.vendor.request.VendorUpdateRequest;
import com.alby.rsud.dto.master.vendor.response.VendorAddResponse;
import com.alby.rsud.dto.master.vendor.response.VendorResponse;
import com.alby.rsud.entity.Vendor;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VendorUtils {

    private static final String DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm:ss";

    public static List<VendorResponse> mapVendorsToVendorsResponse(List<Vendor> vendors) {
        List<VendorResponse> vendorResponse = new ArrayList<>();

        for (Vendor vendor : vendors) {
            vendorResponse.add(VendorResponse.builder()
                    .id(vendor.getId())
                    .vendorName(vendor.getVendorName())
                    .createdBy(vendor.getCreatedBy())
                    .createdAt(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
                            .format(vendor.getCreatedAt()))
                    .modifiedBy(vendor.getModifiedBy())
                            .modifiedAt(null != vendor.getModifiedAt()
                                    ? DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
                                        .format(vendor.getModifiedAt()) : null)
                    .build());
        }

        return vendorResponse;
    }

    public static Vendor mapVendorAddRequestToVendor(VendorAddRequest request) {
        return Vendor.builder()
                .vendorName(request.getVendorName())
                .build();
    }

    public static VendorResponse mapVendorToVendorResponse(Vendor vendor) {
        return VendorResponse.builder()
                .vendorName(vendor.getVendorName())
                .createdBy(vendor.getCreatedBy())
                .createdAt(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
                        .format(vendor.getCreatedAt()))
                .build();
    }

    public static Vendor mapVendorUpdateRequestToVendor(VendorUpdateRequest request) {
        return Vendor.builder()
                .id(request.getId())
                .vendorName(request.getVendorName())
                .build();
    }
}
