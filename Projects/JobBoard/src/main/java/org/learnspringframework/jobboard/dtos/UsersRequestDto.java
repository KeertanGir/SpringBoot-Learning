package org.learnspringframework.jobboard.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.learnspringframework.jobboard.entities.enums.Role;

import java.time.LocalDateTime;

public class UsersRequestDto {

    @NotBlank(message = "Full Name is Required")
    @Size(min = 2, message = "Name Should Have More Than 2 Latters")
    private String fullName;

    @NotBlank(message = "Email is Requires")
    @Email(message = "must be valid")
    private String email;

    @NotBlank(message = "Password Is Required")
    @Size(min = 6, message = "Password must be At-least 6 character")
    private String password;

    @NotBlank(message = "Role is Required")
    @Pattern(regexp = "RECRUITER|CANDIDATE", message = "Role Should be RECRUITER Or CANDIDATE")
    private Role role;

    private LocalDateTime createdAt;

    public UsersRequestDto(String fullName, String email, String password, Role role, LocalDateTime createdAt) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
