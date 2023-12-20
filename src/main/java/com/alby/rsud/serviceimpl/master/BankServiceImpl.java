package com.alby.rsud.serviceimpl.master;

import com.alby.rsud.dto.master.bank.request.BankAddRequest;
import com.alby.rsud.dto.master.bank.request.BankUpdateRequest;
import com.alby.rsud.dto.master.bank.response.BankResponse;
import com.alby.rsud.entity.master.Bank;
import com.alby.rsud.repository.master.BankRepository;
import com.alby.rsud.service.master.BankService;
import com.alby.rsud.utils.master.BankUtils;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    private final Validator validator;

    @Override
    public List<BankResponse> findAll() {
        return BankUtils.mapBanksToBanksResponse(bankRepository.findAll());
    }

    @Override
    public Boolean submit(BankAddRequest request) {
        validator.validate(request);

        Bank bank = BankUtils.mapBankAddRequestToBank(request);
        bankRepository.save(bank);

        return null != bank.getId();
    }

    @Override
    public BankResponse findById(Long id) {
        Optional<Bank> bank = bankRepository.findById(id);
        return bank.map(BankUtils::mapBankToBankResponse).orElse(null);
    }

    @Override
    public Boolean update(BankUpdateRequest request) {
        validator.validate(request);
        bankRepository.save(BankUtils.mapBankUpdateRequestToBank(request));
        return true;
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Bank> bank = bankRepository.findById(id);
        if (bank.isPresent()) {
            bankRepository.delete(bank.get());
            return true;
        }

        return false;
    }
}
