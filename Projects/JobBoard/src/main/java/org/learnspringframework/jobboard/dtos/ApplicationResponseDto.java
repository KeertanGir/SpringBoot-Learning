package org.learnspringframework.jobboard.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.learnspringframework.jobboard.entities.enums.Status;

import java.time.LocalDateTime;

public class ApplicationResponseDto {

    private Long id;
    private Status status;
    private LocalDateTime appliedDate;
    private String resumeUrl;


    private Long job_id;
    private String Job_name;
    private String Job_Type;

    private Long candidate_id;
    private String candidate_name;
    private String candidate_email;



//    public ApplicationResponseDto(Long id, Long job_id, Long candidate_id, Status status, LocalDateTime appliedDate, String resumeUrl) {
//        this.id = id;
//        this.job_id = job_id;
//        this.candidate_id = candidate_id;
//        this.status = status;
//        this.appliedDate = appliedDate;
//        this.resumeUrl = resumeUrl;
//    }

//    Replaced By This Updated DTO


    public ApplicationResponseDto(Long id, Status status, LocalDateTime appliedDate, String resumeUrl, Long job_id, String job_name, String job_Type, Long candidate_id, String candidate_name, String candidate_email) {
        this.id = id;
        this.status = status;
        this.appliedDate = appliedDate;
        this.resumeUrl = resumeUrl;
        this.job_id = job_id;
        Job_name = job_name;
        Job_Type = job_Type;
        this.candidate_id = candidate_id;
        this.candidate_name = candidate_name;
        this.candidate_email = candidate_email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public Long getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(Long candidate_id) {
        this.candidate_id = candidate_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDateTime appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getJob_name() {
        return Job_name;
    }

    public void setJob_name(String job_name) {
        Job_name = job_name;
    }

    public String getJob_Type() {
        return Job_Type;
    }

    public void setJob_Type(String job_Type) {
        Job_Type = job_Type;
    }

    public String getCandidate_name() {
        return candidate_name;
    }

    public void setCandidate_name(String candidate_name) {
        this.candidate_name = candidate_name;
    }

    public String getCandidate_email() {
        return candidate_email;
    }

    public void setCandidate_email(String candidate_email) {
        this.candidate_email = candidate_email;
    }
}
