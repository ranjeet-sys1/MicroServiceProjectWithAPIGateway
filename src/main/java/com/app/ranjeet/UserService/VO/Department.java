package com.app.ranjeet.UserService.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Long departmentId;

    private String departmentName;

    private String departmentAddress;

    private String departmentCode;
}
