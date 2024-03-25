package org.example.thejobseeking.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.example.thejobseeking.Api.ApiResponse;
import org.example.thejobseeking.Model.JobApplication;
import org.example.thejobseeking.Service.JobApplicationService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jobApplication")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity getAllJobApplication(){
        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApplications());
    }

    @PostMapping("/add")
    public ResponseEntity aplyyForJob(@RequestBody @Valid JobApplication jobApplication, Errors errors){
        String E= jobApplicationService.applyForJob(jobApplication);
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (E.equalsIgnoreCase("not found")) {
            return ResponseEntity.status(400).body(new ApiResponse("not found"));
        } else if (E.equalsIgnoreCase("not found")) {
            return ResponseEntity.status(400).body(new ApiResponse("not found"));
        }
        jobApplicationService.applyForJob(jobApplication);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobApplication(@PathVariable Integer id){
        Boolean isDelete= jobApplicationService.deleteJobApplication(id);
        if(isDelete){
            return ResponseEntity.status(200).body(new ApiResponse("deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("wrong id"));
    }



}


