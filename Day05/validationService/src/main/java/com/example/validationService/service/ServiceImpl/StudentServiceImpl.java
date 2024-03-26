package com.example.validationService.service.ServiceImpl;

import com.example.validationService.ExceptionHandler.CredentialNotFound;
import com.example.validationService.ExceptionHandler.UserNotFoundException;
import com.example.validationService.entity.RegisterStudentEntity;
import com.example.validationService.model.RegisterRequestModel;
import com.example.validationService.model.RequestModel;
import com.example.validationService.repository.StudentRepository;
import com.example.validationService.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialNotFoundException;
import javax.swing.undo.CannotRedoException;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Boolean saveStudentDetails(RegisterRequestModel registerRequestModel) {
        RegisterStudentEntity registerStudentEntity=new RegisterStudentEntity();
        registerStudentEntity.setStudent_name(registerRequestModel.getStudent_name());
        registerStudentEntity.setEmail(registerRequestModel.getEmail());
        registerStudentEntity.setPassword(registerRequestModel.getPassword());
        registerStudentEntity.setCourse_name(registerRequestModel.getCourse_name());
        registerStudentEntity.setFaculty_name(registerRequestModel.getFaculty_name());
        registerStudentEntity.setDepartment_name(registerRequestModel.getDepartment_name());

        RegisterStudentEntity getStudentResult=studentRepository.save(registerStudentEntity);
        if(!getStudentResult.getStudent_name().isEmpty()){
            return true;
        }else{
            return false;
        }


    }

    @Override
    public boolean findLogedStudent(RequestModel requestModel) throws Exception{
        Optional<RegisterStudentEntity> registerStudentEntity=studentRepository.findById(requestModel.getStudent_id());
        //check whether it is null
        if(registerStudentEntity.isPresent()){
            if(registerStudentEntity.get().getStudent_name().equals(requestModel.getStudent_name())&&
                    registerStudentEntity.get().getPassword().equals(requestModel.getPassword()))
                return true;
            else
                throw new CredentialNotFound("Either username or password is incorrect");
        }else{
            throw new UserNotFoundException("user is not found at this moment");
        }

//        if(registerStudentEntity.get().getStudent_name().equals(requestModel.getStudent_name())&&
//                registerStudentEntity.get().getPassword().equals(requestModel.getPassword()))
//            return true;
//        else
//            throw new UserNotFoundException();

    }

    @Override
    public boolean loginUser() throws Exception{
        throw new UserNotFoundException();
    }
}
