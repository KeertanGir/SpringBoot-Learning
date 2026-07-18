package org.learnspringframework.jobboard.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.learnspringframework.jobboard.entities.enums.Status;

import java.time.LocalDateTime;

public class ApplicationsRequestDto {

    @NotNull(message = "Job_id is must Requires")
    private Long job_id;

    @NotNull(message = "Candidate_Id is must Required")
    private Long candidate_id;

    @NotNull(message = "Status is Required")
//    @Pattern(regexp = "PENDING|SHORTLISTED|REJECTED|ACCEPTED",
//            message = "Status must be PENDING, SHORTLISTED, REJECTED, or ACCEPTED")
    private Status status;

    private LocalDateTime appliedDate;

    private String resumeUrl;

    public ApplicationsRequestDto(Long job_id, Long candidate_id, Status status, LocalDateTime appliedDate, String resumeUrl) {
        this.job_id = job_id;
        this.candidate_id = candidate_id;
        this.status = status;
        this.appliedDate = appliedDate;
        this.resumeUrl = resumeUrl;
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
