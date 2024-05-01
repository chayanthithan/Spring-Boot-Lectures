package com.example.HospitalService.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestRequestModel {
    private String patientEmail;
    private String patientPassword;

    public String toJSONString() throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}
