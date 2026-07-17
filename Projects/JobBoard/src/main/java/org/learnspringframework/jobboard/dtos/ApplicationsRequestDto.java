package org.learnspringframework.jobboard.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.learnspringframework.jobboard.entities.enums.Status;

import java.time.LocalDateTime;

public class ApplicationsRequestDto {

    @NotBlank(message = "Job_id is must Requires")
    private Long job_id;

    @NotBlank(message = "Candidate_Id is must Required")
    private Long candidate_id;

    @NotBlank(message = "Status is Required")
    @Pattern(regexp = "PENDING|SHORTLISTED|REJECTED|ACCEPTED",
            message = "Status must be PENDING, SHORTLISTED, REJECTED, or ACCEPTED")
    private Status status;

    private LocalDateTime appliedDate;

    private String resumeUrl;

}
