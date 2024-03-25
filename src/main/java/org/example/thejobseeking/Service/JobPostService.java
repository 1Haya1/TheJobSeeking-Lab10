package org.example.thejobseeking.Service;

import lombok.RequiredArgsConstructor;
import org.example.thejobseeking.Model.JobPost;
import org.example.thejobseeking.Repository.JobPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;


    public List<JobPost> getAllJobPosts() {
        return jobPostRepository.findAll();
    }

    public void addJobPost(JobPost jobPost) {
         jobPostRepository.save(jobPost);
    }

    public Boolean updateJobPost(Integer id,JobPost jobPost){
        JobPost c=jobPostRepository.getById(id);

        if(c==null){
            return false;
        }

        c.setTitle(jobPost.getTitle());
        c.setDescription(jobPost.getDescription());
        c.setLocation(jobPost.getLocation());
        c.setSalary(jobPost.getSalary());
        c.setPostingDate(jobPost.getPostingDate());
        jobPostRepository.save(c);

        return true;
    }

    public Boolean deleteJobPost(Integer id){
        if (jobPostRepository.existsById(id)) {
            jobPostRepository.deleteById(id);
            return true;
        }
        return false ;
    }



}
