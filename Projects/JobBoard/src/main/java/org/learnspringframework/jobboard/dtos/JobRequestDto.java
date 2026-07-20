package org.learnspringframework.jobboard.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class JobRequestDto {

    @NotBlank(message = "title Field is Required")
    @Size(min = 2, message = "Title length Should be Greater Than 2")
    private String title;

    @NotBlank(message = "Job Description Field is Required")
    @Size(min = 2, message = "Job Description length Should be Greater Than 2")
    private String jobDescription;

    @NotBlank(message = "Location is Required")
    @Size(min = 2, message = "Location length Should be Greater Than 2")
    private String location;

    @NotBlank(message = "Salary Range is Required")
    @Size(min = 2, message = "Salary Range Should be Greater than 2")
    private String salaryRange;

    @NotBlank(message = "Job Type is Required")
    @Size(min = 2, message = "Job Type length Should be Greater Than 2")
    private String jobType;

//    @NotBlank(message = "Posted Date Is Required") -- is wjah se error aaye gha Yeh sirf Strings per use hota hy
    @PastOrPresent(message = "Posting date Cannot be The Future date Please add Past Or Present Date In this Field")
    private LocalDate postedDate;

    private Boolean isActive;

    @NotNull(message = "Company Id is Required")
    private Long company_id;  // from job.getCompany().getName() / .getId()


    @NotNull(message = "Company Id is Required")
    private Long postedBy_id; // from job.getPostedBy().getFullName() / .getId()

    private int applications_Count; // from job.getApplications().size()


    public JobRequestDto(String title, String jobDescription, String location, String salaryRange, String jobType, LocalDate postedDate, Boolean isActive, Long company_id, Long postedBy_id) {
        this.title = title;
        this.jobDescription = jobDescription;
        this.location = location;
        this.salaryRange = salaryRange;
        this.jobType = jobType;
        this.postedDate = postedDate;
        this.isActive = isActive;
        this.company_id = company_id;
        this.postedBy_id = postedBy_id;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getCompanyId() {
        return company_id;
    }

    public void setCompanyId(Long company_id) {
        this.company_id = company_id;
    }

    public Long getPostedById() {
        return postedBy_id;
    }

    public void setPostedById(Long postedBy_id) {
        this.postedBy_id = postedBy_id;
    }

    public int getApplicationsCount() {
        return applications_Count;
    }

    public void setApplicationsCount(int applications_Count) {
        this.applications_Count = applications_Count;
    }
}
