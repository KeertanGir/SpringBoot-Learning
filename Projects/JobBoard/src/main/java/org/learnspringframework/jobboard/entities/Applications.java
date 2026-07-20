package org.learnspringframework.jobboard.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.learnspringframework.jobboard.entities.enums.Status;

import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
public class Applications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "job_id",nullable = false)
//    private Long job_id;   // Replaced By the Jobs...

//    @Column(name = "candidate_id", nullable = false)
//    private Long candidate_id;   // Replaced By the Jobs...   Users..

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "applied_date",nullable = false)
    private LocalDateTime appliedDate;

    @Column(name = "resume_url",nullable = false, length = 500)
    private String resumeUrl;


//    Relationships

    @ManyToOne
    @JoinColumn(
            name = "job_id", nullable = false
    )
    private JobsPostings job;


    @ManyToOne
    @JoinColumn(name = "candidate_id" , nullable = false)
    private Users candidate;

//
//    public Applications(Long job_id, Long candidate_id, Status status, LocalDateTime appliedDate, String resumeUrl) {
//        this.job_id = job_id;
//        this.candidate_id = candidate_id;
//        this.status = status;
//        this.appliedDate = appliedDate;
//        this.resumeUrl = resumeUrl;
//    }


    public Applications(Long id, Status status, LocalDateTime appliedDate, String resumeUrl, JobsPostings job, Users candidate) {
        this.id = id;
        this.status = status;
        this.appliedDate = appliedDate;
        this.resumeUrl = resumeUrl;
        this.job = job;
        this.candidate = candidate;
    }

    public Applications() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getJob_id() {
//        return job_id;
//    }
//
//    public void setJob_id(Long job_id) {
//        this.job_id = job_id;
//    }
//
//    public Long getCandidate_id() {
//        return candidate_id;
//    }
//
//    public void setCandidate_id(Long candidate_id) {
//        this.candidate_id = candidate_id;
//    }


    public JobsPostings getJob() {
        return job;
    }

    public void setJob(JobsPostings job) {
        this.job = job;
    }

    public Users getCandidate() {
        return candidate;
    }

    public void setCandidate(Users candidate) {
        this.candidate = candidate;
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
