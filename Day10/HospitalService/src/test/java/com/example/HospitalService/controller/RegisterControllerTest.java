package com.example.HospitalService.controller;

import com.example.HospitalService.model.RegisterModel;
import com.example.HospitalService.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(RegisterController.class)
public class RegisterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean    //bean =object
    private PatientServiceImpl patientServiceimpl;

    @Test
    @WithMockUser(username = "chayan",password = "chayan",roles = "USER")
    public void testInregisterPatientSuccess() throws Exception{
        RegisterModel registerModel=new RegisterModel();
        registerModel.setPatientName("dummy");
        registerModel.setPatientEmail("dummy@gmail.com");
        registerModel.setPatientPassword("dummy@123");
        registerModel.setPatientAddress("dummypuram");
        registerModel.setPatientMobile("0777777777");
        registerModel.setWardNo("1");
        registerModel.setAdmittedDate("2024/04/04");

        String requestString=registerModel.toJasonString();
        when(patientServiceimpl.registerPatientDetails(any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/hospitalservice/register") //calling login url like postman
        .with(SecurityMockMvcRequestPostProcessors.csrf())// if security enable for springboot then csrf is mandetory
        .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestString))//setting content type
        .andExpect(MockMvcResultMatchers.status().isCreated());//if request sent is success then we expect Created status 201

    }
}
