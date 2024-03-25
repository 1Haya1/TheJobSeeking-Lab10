package org.example.thejobseeking.Service;

import lombok.RequiredArgsConstructor;
import org.example.thejobseeking.Model.JobApplication;
import org.example.thejobseeking.Model.JobPost;
import org.example.thejobseeking.Model.User;
import org.example.thejobseeking.Repository.JobApplicationRepository;
import org.example.thejobseeking.Repository.JobPostRepository;
import org.example.thejobseeking.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobPostRepository jobPostRepository ;
    private final UserRepository userRepository ;
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }


    public String applyForJob(JobApplication jobApplication) {
        Integer user_Id = jobApplication.getUser_id();
        Integer jobPost_Id = jobApplication.getJobPost_id();

        if (!userRepository.existsById(user_Id)) {
            return "User not found";
        }

        if (!jobPostRepository.existsById(jobPost_Id)) {
            return "Job post not found";
        }

        jobApplicationRepository.save(jobApplication);
        return "Job application added";
    }


    public Boolean deleteJobApplication(Integer id){
        if (jobApplicationRepository.existsById(id)) {
            jobApplicationRepository.deleteById(id);
            return true;
        }
        return false ;
    }






}
