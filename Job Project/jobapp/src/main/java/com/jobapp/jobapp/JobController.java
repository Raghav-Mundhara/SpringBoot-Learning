package com.jobapp.jobapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.jobapp.model.JobPost;
import com.jobapp.jobapp.service.JobService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping("/addjob")
    public String addJobPost(@RequestBody JobPost jobPost) {
        System.out.println("Received job post: " + jobPost);
        jobService.addJob(jobPost);
        return "Job post added successfully!";
    }

    @GetMapping("/jobposts")
    public List<JobPost> getAllJobPosts(Model model) {
        System.out.println("Fetching all job posts...");
        return jobService.getAllJobs();
    }


}
