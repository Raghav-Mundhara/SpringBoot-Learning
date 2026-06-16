package com.jobapp.jobapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.jobapp.model.JobPost;
import com.jobapp.jobapp.service.JobService;
import org.springframework.web.bind.annotation.PutMapping;


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

    @GetMapping("/jobposts/{id}")
    public JobPost getJobById(@PathVariable int id) {
        return jobService.getJobById(id);
    }

    @DeleteMapping("/jobposts/{id}")
    public String deleteJobById(@PathVariable int id){
        jobService.deleteJobById(id);
        return "Job Deleted Successfully";
    }

    @PutMapping("jobposts/{id}")
    public JobPost updateJobPost(@PathVariable int id,@RequestBody JobPost job) {
        jobService.updateJobPost(id,job);
        return jobService.getJobById(id);
    }
}
