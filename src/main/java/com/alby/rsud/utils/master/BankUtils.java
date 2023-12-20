package com.alby.rsud.utils.master;

import com.alby.rsud.dto.master.bank.request.BankAddRequest;
import com.alby.rsud.dto.master.bank.request.BankUpdateRequest;
import com.alby.rsud.dto.master.bank.response.BankResponse;
import com.alby.rsud.entity.master.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankUtils {

    private static final String DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm:ss";

    public static List<BankResponse> mapBanksToBanksResponse(List<Bank> banks) {
        List<BankResponse> bankResponse = new ArrayList<>();

        for (Bank bank : banks) {
            bankResponse.add(BankResponse.builder()
                    .id(bank.getId())
                    .name(bank.getName())
                    .createdBy(bank.getCreatedBy())
//                    .createdAt(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
//                            .format(vendor.getCreatedAt()))
//                    .modifiedBy(vendor.getModifiedBy())
//                            .modifiedAt(null != vendor.getModifiedAt()
//                                    ? DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
//                                        .format(vendor.getModifiedAt()) : null)
                    .build());
        }

        return bankResponse;
    }

    public static Bank mapBankAddRequestToBank(BankAddRequest request) {
        return Bank.builder()
                .name(request.getName())
                .build();
    }

    public static BankResponse mapBankToBankResponse(Bank bank) {
        return BankResponse.builder()
                .id(bank.getId())
                .name(bank.getName())
//                .createdBy(vendor.getCreatedBy())
//                .createdAt(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
//                        .format(vendor.getCreatedAt()))
                .build();
    }

    public static Bank mapBankUpdateRequestToBank(BankUpdateRequest request) {
        return Bank.builder()
                .id(request.getId())
                .name(request.getName())
                .build();
    }
}
