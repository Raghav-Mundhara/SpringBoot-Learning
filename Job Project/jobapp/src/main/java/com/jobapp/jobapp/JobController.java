package com.jobapp.jobapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jobapp.jobapp.model.JobPost;
import com.jobapp.jobapp.service.JobService;

public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping({"/","/home"})
    public String home() {
        return "home";
    }

    @GetMapping("addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost) {
        jobService.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model m){
        List<JobPost> jobs= jobService.getAllJobs();
        m.addAttribute("jobs", jobs);
        return "viewalljobs";
    }
}
