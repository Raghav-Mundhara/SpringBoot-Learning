package com.jobapp.jobapp.repo;

import org.springframework.stereotype.Repository;

import com.jobapp.jobapp.model.JobPost;

import java.util.*;
@Repository
public class JobRepo {

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Software Engineer", "Develop and maintain software applications.", 3, Arrays.asList("Java", "Spring Boot")),
            new JobPost(2, "Data Analyst", "Analyze and interpret complex data sets.", 2, Arrays.asList("Python", "SQL")),
            new JobPost(3, "Project Manager", "Oversee project planning and execution.", 5, Arrays.asList("Agile", "Scrum"))
    ));

    public void addJob(JobPost jobPost) {
        jobs.add(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public JobPost getJobById(int id){
        for(JobPost job : jobs){
            if(job.getPostId() == id){
                return job;
            }
        }
        return null;
    }
    public void  deleteJobById(int id){
        jobs.removeIf(job->job.getPostId()==id);
    }
    public void  updateJobPost(int id,JobPost updatedJob){
        jobs.replaceAll(job -> job.getPostId() == id ? updatedJob : job);
    }
}

//Sample JSON for JobPost
/*
{
    "postId": 4,
    "postProfile": "UI/UX Designer",
    "postDesc": "Design user interfaces and improve user experience.",
    "requiredExp": 4,
    "postTechStack": ["Figma", "Adobe XD"]
}
*/