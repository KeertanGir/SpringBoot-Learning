package org.learnspringframework.jobboard.entities;

import jakarta.persistence.*;
import org.learnspringframework.jobboard.entities.enums.Role;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "postedBy" , cascade = CascadeType.ALL)
    private List<JobsPostings> postedJobs = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Applications> applications = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "user_skills",
            joinColumns = @JoinColumn( name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skills> skills = new HashSet<>();


    protected Users(){}

    public Users(String fullName, String email, String password, Role role, LocalDateTime createdAt) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
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

    public List<JobsPostings> getPostedJobs() {
        return postedJobs;
    }

    public void setPostedJobs(List<JobsPostings> postedJobs) {
        this.postedJobs = postedJobs;
    }

    public List<Applications> getApplications() {
        return applications;
    }

    public void setApplications(List<Applications> applications) {
        this.applications = applications;
    }

    public Set<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }
}
