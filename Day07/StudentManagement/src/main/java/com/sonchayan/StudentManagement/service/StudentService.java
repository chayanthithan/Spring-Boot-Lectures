package com.sonchayan.StudentManagement.service;

import com.sonchayan.StudentManagement.model.RequestModel;

public interface StudentService {
    Boolean storeRegisteredStudentsDetails(RequestModel requestModel);

    boolean checkStudent(String studentEmail, String studentPassword);
}
