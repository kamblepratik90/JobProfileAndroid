package com.example.jobprofile;

public class Job {
    String _id;
    String company;
    String position;
    String status;
    String jobtype;
    String createdBy;
    String createdAt;
    String updatedAt;

    public String getId() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    public Job(String id, String company, String position, String status, String jobtype, String createdBy, String createdAt,String updatedAt) {

        this._id = id;
        this.company = company;
        this.position = position;
        this.status = status;
        this.jobtype = jobtype;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "Job{" +
                "id='" + _id + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", status='" + status + '\'' +
                ", jobtype='" + jobtype + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
