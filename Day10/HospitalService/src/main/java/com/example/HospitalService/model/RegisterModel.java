package com.example.HospitalService.model;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterModel {
    private String patientName;
    private String patientEmail;
    private String patientAddress;
    private String patientMobile;
    private String patientPassword;
    private String wardNo;
    private String admittedDate;

    public String toJasonString() throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}
