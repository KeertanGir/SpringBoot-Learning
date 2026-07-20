package org.learnspringframework.jobboard.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.learnspringframework.jobboard.entities.enums.Role;

import java.time.LocalDateTime;

public class UsersResponseDto {

    private Long id;
    private String fullName;
    private String email;
    private Role role;
    private LocalDateTime createdAt;

    private Integer postedJobsCount;

    private Integer postedApplicationCount;

//    public UsersResponseDto(Long id, String fullName, String email, Role role, LocalDateTime createdAt) {
//        this.id = id;
//        this.fullName = fullName;
//        this.email = email;
//        this.role = role;
//        this.createdAt = createdAt;
//    }


    public UsersResponseDto(Long id, String fullName, String email, Role role, LocalDateTime createdAt, Integer postedJobsCount, Integer postedApplicationCount  ) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        this.postedJobsCount = postedJobsCount;
        this.postedApplicationCount = postedApplicationCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getPostedJobsCount() {
        return postedJobsCount;
    }

    public void setPostedJobsCount(Integer postedJobsCount) {
        this.postedJobsCount = postedJobsCount;
    }

    public Integer getPostedApplicationCount() {
        return postedApplicationCount;
    }

    public void setPostedApplicationCount(Integer postedApplicationCount) {
        this.postedApplicationCount = postedApplicationCount;
    }
}
