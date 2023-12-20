package com.alby.rsud.serviceimpl.master;

import com.alby.rsud.dto.master.bank.request.BankAddRequest;
import com.alby.rsud.dto.master.bank.request.BankUpdateRequest;
import com.alby.rsud.dto.master.bank.response.BankResponse;
import com.alby.rsud.dto.master.position.request.PositionAddRequest;
import com.alby.rsud.dto.master.position.request.PositionUpdateRequest;
import com.alby.rsud.dto.master.position.response.PositionResponse;
import com.alby.rsud.entity.master.Bank;
import com.alby.rsud.entity.master.Position;
import com.alby.rsud.repository.master.PositionRepository;
import com.alby.rsud.service.master.PositionService;
import com.alby.rsud.utils.master.BankUtils;
import com.alby.rsud.utils.master.PositionUtils;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    private final Validator validator;

    @Override
    public List<PositionResponse> findAll() {
        return PositionUtils.mapPositionsToPositionsResponse(positionRepository.findAll());
    }

    @Override
    public Boolean submit(PositionAddRequest request) {
        validator.validate(request);

        Position position = PositionUtils.mapPositionAddRequestToPosition(request);
        positionRepository.save(position);

        return null != position.getId();
    }

    @Override
    public PositionResponse findById(Long id) {
        Optional<Position> position = positionRepository.findById(id);
        return position.map(PositionUtils::mapPositionToPositionResponse).orElse(null);
    }

    @Override
    public Boolean update(PositionUpdateRequest request) {
        validator.validate(request);
        positionRepository.save(PositionUtils.mapPositionUpdateRequestToPosition(request));
        return true;
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Position> position = positionRepository.findById(id);
        if (position.isPresent()) {
            positionRepository.delete(position.get());
            return true;
        }

        return false;
    }
}
