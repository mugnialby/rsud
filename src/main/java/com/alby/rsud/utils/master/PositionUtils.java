package com.alby.rsud.utils.master;

import com.alby.rsud.dto.master.bank.request.BankAddRequest;
import com.alby.rsud.dto.master.bank.request.BankUpdateRequest;
import com.alby.rsud.dto.master.bank.response.BankResponse;
import com.alby.rsud.dto.master.position.request.PositionAddRequest;
import com.alby.rsud.dto.master.position.request.PositionUpdateRequest;
import com.alby.rsud.dto.master.position.response.PositionResponse;
import com.alby.rsud.entity.master.Bank;
import com.alby.rsud.entity.master.Position;

import java.util.ArrayList;
import java.util.List;

public class PositionUtils {

    private static final String DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm:ss";
    public static List<PositionResponse> mapPositionsToPositionsResponse(List<Position> positions) {
        List<PositionResponse> positionResponse = new ArrayList<>();

        for (Position position : positions) {
            positionResponse.add(PositionResponse.builder()
                    .id(position.getId())
                    .name(position.getName())
                    .createdBy(position.getCreatedBy())
//                    .createdAt(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
//                            .format(vendor.getCreatedAt()))
//                    .modifiedBy(vendor.getModifiedBy())
//                            .modifiedAt(null != vendor.getModifiedAt()
//                                    ? DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
//                                        .format(vendor.getModifiedAt()) : null)
                    .build());
        }

        return positionResponse;
    }

    public static Position mapPositionAddRequestToPosition(PositionAddRequest request) {
        return Position.builder()
                .name(request.getName())
                .build();
    }

    public static PositionResponse mapPositionToPositionResponse(Position position) {
        return PositionResponse.builder()
                .id(position.getId())
                .name(position.getName())
//                .createdBy(vendor.getCreatedBy())
//                .createdAt(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
//                        .format(vendor.getCreatedAt()))
                .build();
    }

    public static Position mapPositionUpdateRequestToPosition(PositionUpdateRequest request) {
        return Position.builder()
                .id(request.getId())
                .name(request.getName())
                .build();
    }
}
