package com.twistresources.MaintenanceProject.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private Integer code;
    private String status;
    private String message;
}