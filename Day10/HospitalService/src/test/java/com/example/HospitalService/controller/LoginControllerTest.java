package com.example.HospitalService.controller;


import com.example.HospitalService.model.TestRequestModel;
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

@WebMvcTest(LoginController.class)
public class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientServiceImpl patientServiceimpl;
@Test
@WithMockUser(username = "chayan", password = "chayan",roles = "USER")//to pass basic authentication security
    public void testLoginInSuccess() throws Exception{
        TestRequestModel rm=new TestRequestModel();
        rm.setPatientEmail("dummy@gmail");
        rm.setPatientPassword("dummy");
//to converting an object into its corresponding JSON (JavaScript Object Notation) string representation.
    String requestString = rm.toJSONString();
    when(patientServiceimpl.loginByPatient(any(),any())).thenReturn(true);
//    when(patientServiceimpl.loginByPatient("dummy@gmail","dummy")).thenReturn(true);

    mockMvc.perform(MockMvcRequestBuilders.get("/hospitalservice/login")
                    .param("patientEmail", "dummy@gmail")
                    .param("patientPassword", "dummy") //we have to give param because in controller we have give request through requestparam so
                    .with(SecurityMockMvcRequestPostProcessors.csrf())
                    .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestString))
            .andExpect(MockMvcResultMatchers.status().isCreated());
//            .andExpect(MockMvcResultMatchers.content().string("success"));

}
}
