package org.learnspringframework.jobboard.Data;

import java.time.LocalDate;

public class JobsPostings {

//    id           Long
//    title        String
//    companyName  String
//    location     String
//    salaryRange  String     (e.g. "80k-120k")
//    jobType      String     (Full-time / Part-time / Remote)
//    postedDate   LocalDate
//    isActive     boolean

    private Long id;
    private String title;
    private String jobDescription;
    private String companyName;
    private String location;
    private String salaryRange;
    private String jobType;
    private LocalDate postedDate;
    private Boolean isActive;


    public JobsPostings(Long id, String title, String jobDescription, String companyName, String location, String salaryRange, String jobType, LocalDate postedDate, Boolean isActive) {
        this.id = id;
        this.title = title;
        this.jobDescription = jobDescription;
        this.companyName = companyName;
        this.location = location;
        this.salaryRange = salaryRange;
        this.jobType = jobType;
        this.postedDate = postedDate;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
