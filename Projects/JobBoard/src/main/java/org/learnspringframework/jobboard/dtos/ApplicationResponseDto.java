package org.learnspringframework.jobboard.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.learnspringframework.jobboard.entities.enums.Status;

import java.time.LocalDateTime;

public class ApplicationResponseDto {

    private Long id;
    private Long job_id;
    private Long candidate_id;
    private Status status;
    private LocalDateTime appliedDate;
    private String resumeUrl;

    public ApplicationResponseDto(Long id, Long job_id, Long candidate_id, Status status, LocalDateTime appliedDate, String resumeUrl) {
        this.id = id;
        this.job_id = job_id;
        this.candidate_id = candidate_id;
        this.status = status;
        this.appliedDate = appliedDate;
        this.resumeUrl = resumeUrl;
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
}
