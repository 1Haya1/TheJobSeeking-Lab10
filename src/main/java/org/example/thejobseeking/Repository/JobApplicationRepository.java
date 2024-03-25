package org.example.thejobseeking.Repository;

import org.example.thejobseeking.Model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication,Integer> {

    boolean jobApplicationExists(Integer jobApplicationId);
}
