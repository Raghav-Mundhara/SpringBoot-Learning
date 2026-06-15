package com.jobapp.jobapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapp.jobapp.model.JobPost;
import com.jobapp.jobapp.repo.JobRepo;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost) {
        jobRepo.addJob(jobPost);
    }
    
    public List<JobPost> getAllJobs() {
        // Logic to retrieve all job posts using jobRepo
        return jobRepo.getAllJobs();
    }
}
