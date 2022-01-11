package com.example.jobprofile;

import java.util.ArrayList;

public class JobResponses {

    ArrayList<Job> jobs;

    public JobResponses(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "JobResponses{" +
                "jobs=" + jobs +
                '}';
    }
}
