package org.learnspringframework.jobboard.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "skill")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skill_name", nullable = false, unique = true)
    private String skillName;

    @ManyToMany(mappedBy = "requiredSkills" )
    private Set<JobsPostings> jobs = new HashSet<>();

    @ManyToMany(mappedBy = "skills")
    private Set<Users> users = new HashSet<>();


    public Skills(Long id, String skillName) {
        this.id = id;
        this.skillName = skillName;
    }

    public Skills() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Set<JobsPostings> getJobs() {
        return jobs;
    }

    public void setJobs(Set<JobsPostings> jobs) {
        this.jobs = jobs;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}
