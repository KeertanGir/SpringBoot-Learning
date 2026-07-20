package org.learnspringframework.jobboard.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Jobs")
public class JobsPostings {

//    id           Long
//    title        String
//    companyName  String ---- Changed to Real Entity
//    location     String
//    salaryRange  String     (e.g. "80k-120k")
//    jobType      String     (Full-time / Part-time / Remote)
//    postedDate   LocalDate
//    isActive     boolean

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Job_title" , nullable = false)
    private String title;

    @Column(name = "Job_Description" , nullable = false, length = 1000)
    private String jobDescription;


    @Column(name = "Location")
    private String location;

    @Column(name = "Salary_Range")
    private String salaryRange;

    @Column(name = "Job_Type")
    private String jobType;

    @Column(name = "Posted_Date")
    private LocalDate postedDate;

    @Column(name = "is_Active")
    private Boolean isActive;

//    RelationShips

    @ManyToOne
    @JoinColumn(name = "company_Id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "posted_By_id", nullable = false)
    private Users postedBy;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Applications> applications = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "jobs_skills",
            joinColumns = @JoinColumn( name = "Job_id" ),
            inverseJoinColumns = @JoinColumn( name = "skill_id" )
    )
    private Set<Skills> requiredSkills = new HashSet<>();


    public JobsPostings(Long id, String title, String jobDescription, String location, String salaryRange, String jobType, LocalDate postedDate, Boolean isActive, Company company, Users postedBy) {
        this.id = id;
        this.title = title;
        this.jobDescription = jobDescription;
        this.location = location;
        this.salaryRange = salaryRange;
        this.jobType = jobType;
        this.postedDate = postedDate;
        this.isActive = isActive;
        this.company = company;
        this.postedBy = postedBy;
    }

    public JobsPostings() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Users getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(Users postedBy) {
        this.postedBy = postedBy;
    }

    public List<Applications> getApplications() {
        return applications;
    }

    public void setApplications(List<Applications> applications) {
        this.applications = applications;
    }

    public Set<Skills> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(Set<Skills> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
}
