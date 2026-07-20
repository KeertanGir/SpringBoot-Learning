package org.learnspringframework.jobboard.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.learnspringframework.jobboard.entities.Applications;

import java.time.LocalDate;
import java.util.List;

public class JobResponseDTO {


    private Long id;

    private String title;
    private String jobDescription;
    private String location;
    private String salaryRange;
    private String jobType;
    private LocalDate postedDate;
    private Boolean isActive;


    private Long companyId;
    private String companyName;

    private Long postedById;
    private String postedByName;
    private String postedByEmail;

    private Integer totalApplications;

//    @JsonIgnore
    private List<ApplicationResponseDto> applications;

    // Default Constructor
    public JobResponseDTO() {
    }

    // Parameterized Constructor


    public JobResponseDTO(Long id, String title, String jobDescription, String location, String salaryRange, String jobType, LocalDate postedDate, Boolean isActive, Long companyId, String companyName, Long postedById, String postedByName, String postedByEmail, Integer totalApplications , List<ApplicationResponseDto> applications) {
        this.id = id;
        this.title = title;
        this.jobDescription = jobDescription;
        this.location = location;
        this.salaryRange = salaryRange;
        this.jobType = jobType;
        this.postedDate = postedDate;
        this.isActive = isActive;
        this.companyId = companyId;
        this.companyName = companyName;
        this.postedById = postedById;
        this.postedByName = postedByName;
        this.postedByEmail = postedByEmail;
        this.totalApplications = totalApplications;
        this.applications = applications;
    }

    public List<ApplicationResponseDto> getApplications() {
        return applications;
    }

    public void setApplications(List<ApplicationResponseDto> applications) {
        this.applications = applications;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getPostedById() {
        return postedById;
    }

    public void setPostedById(Long postedById) {
        this.postedById = postedById;
    }

    public String getPostedByName() {
        return postedByName;
    }

    public void setPostedByName(String postedByName) {
        this.postedByName = postedByName;
    }

    public String getPostedByEmail() {
        return postedByEmail;
    }

    public void setPostedByEmail(String postedByEmail) {
        this.postedByEmail = postedByEmail;
    }

    public Integer getTotalApplications() {
        return totalApplications;
    }

    public void setTotalApplications(Integer totalApplications) {
        this.totalApplications = totalApplications;
    }
}