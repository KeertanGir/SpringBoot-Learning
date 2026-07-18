package org.learnspringframework.jobboard.entities;

import jakarta.persistence.*;
import org.learnspringframework.jobboard.entities.enums.Status;

import java.time.LocalDateTime;

@Entity
public class Applications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_id",nullable = false)
    private Long job_id;

    @Column(name = "candidate_id", nullable = false)
    private Long candidate_id;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private LocalDateTime appliedDate;

    @Column(nullable = false)
    private String resumeUrl;

    public Applications(Long job_id, Long candidate_id, Status status, LocalDateTime appliedDate, String resumeUrl) {
        this.job_id = job_id;
        this.candidate_id = candidate_id;
        this.status = status;
        this.appliedDate = appliedDate;
        this.resumeUrl = resumeUrl;
    }

    public Applications() {
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
