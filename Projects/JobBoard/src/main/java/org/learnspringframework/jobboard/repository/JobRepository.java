package org.learnspringframework.jobboard.repository;

import org.learnspringframework.jobboard.entities.JobsPostings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<JobsPostings, Long> {

//    Custom Methods
    List<JobsPostings> findByTitleIgnoreCase(String title);

//    List<JobsPostings> findByCompanyName(String companyName); -- That is changes because the Field name is also changed

    // company_name string search is replaced with:
    List<JobsPostings> findByCompany_NameContainingIgnoreCase(String companyName);

    // find all jobs posted by a specific recruiter:
    List<JobsPostings> findByPostedBy_Id(Long UserId);

    // find all jobs under a specific company:
    List<JobsPostings> findByCompany_Id(Long companyId);

    List<JobsPostings> findByJobType(String jobType);

    List<JobsPostings> findByIsActiveTrue();


    List<JobsPostings> findByLocationIgnoreCase(String Location);

}
