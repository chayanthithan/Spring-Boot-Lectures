package com.example.validationService.service;

import com.example.validationService.model.RegisterRequestModel;
import com.example.validationService.model.RequestModel;

public interface StudentService {
    Boolean saveStudentDetails(RegisterRequestModel registerRequestModel);

    boolean findLogedStudent(RequestModel requestModel) throws Exception;

    boolean loginUser() throws Exception;
}
