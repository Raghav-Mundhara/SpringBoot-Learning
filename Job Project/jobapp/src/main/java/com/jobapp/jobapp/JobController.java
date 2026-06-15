package com.jobapp.jobapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jobapp.jobapp.model.JobPost;
import com.jobapp.jobapp.service.JobService;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping("/addjob")
    @ResponseBody
    public String addJobPost(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return "Job post added successfully!";
    }

    @GetMapping("/jobposts")
    @ResponseBody
    public List<JobPost> getAllJobPosts(Model model) {
        System.out.println("Fetching all job posts...");
        return jobService.getAllJobs();
    }


}
