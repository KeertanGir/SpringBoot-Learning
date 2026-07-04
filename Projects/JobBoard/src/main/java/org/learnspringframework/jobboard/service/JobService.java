package org.learnspringframework.jobboard.service;

import org.learnspringframework.jobboard.Data.JobsPostings;
import org.learnspringframework.jobboard.exceptions.InvalidJobDataException;
import org.learnspringframework.jobboard.exceptions.JobNotFoundException;
import org.learnspringframework.jobboard.storage.JobStorage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class JobService {

    private JobStorage jobStorage;

    public JobService(JobStorage jobStorage) {
        this.jobStorage = jobStorage;
    }


    public JobsPostings save(JobsPostings newJob) {
        validator(newJob);
        jobStorage.save(newJob);
        return newJob;
    }


    public List<JobsPostings> getAllJobs() {
        return jobStorage.getAllJobs();
    }


    public JobsPostings getById(Long id) {
        JobsPostings jobsPostings = jobStorage.getById(id).orElse(null);
        chackJobIfNull(id ,jobsPostings);
        return jobsPostings;
    }


    public List<JobsPostings> getJobsByLocation(String location) {
       return jobStorage.getAllJobs()
                .stream()
                .filter(job -> job.getLocation().equalsIgnoreCase(location))
                .toList();
    }


    public List<JobsPostings> getJobsByType(String type) {
        return jobStorage.getAllJobs()
                .stream()
                .filter(job -> job.getJobType().equalsIgnoreCase(type))
                .toList();
    }

    public List<JobsPostings> getOnlyActiveJobs() {
        return jobStorage.getAllJobs()
                .stream()
                .filter(job -> job.isActive())
                .toList();
    }

    public List<JobsPostings> getJobSorted(String sortBy) {

        if (sortBy.equalsIgnoreCase("postedDate")) {
            return jobStorage.getAllJobs()
                    .stream()
                    .sorted(Comparator.comparing(JobsPostings::getPostedDate).reversed())
                    .toList();
        }

        if(sortBy.equalsIgnoreCase("salary")){
            return jobStorage.getAllJobs()
                    .stream()
                    .sorted(Comparator.comparing( job ->  exactMinsalary(job.getSalaryRange())))
                    .toList();
        }

        if(sortBy.equalsIgnoreCase("salaryHighToLow")){
            return jobStorage.getAllJobs()
                    .stream()
                    .sorted(Comparator.comparing(  (JobsPostings job) ->  exactMinsalary(job.getSalaryRange())).reversed()                    )
                    .toList();
        }
        return jobStorage.getAllJobs();
    }



    public List<JobsPostings> getJobsByLocationAndType(String location, String jobType) {
        return JobStorage.getAllJobs()
                .stream()
                .filter(job -> job.getLocation().equalsIgnoreCase(location)
                                    && job.getJobType().equalsIgnoreCase(jobType))
                .toList();
    }

    public void updateJob(long id, JobsPostings newJob) {
        validator(newJob);
        JobsPostings jobsPostings1 = jobStorage.getById(id).orElse(null);
        chackJobIfNull(id ,jobsPostings1);
        jobStorage.updateJob(id, newJob);
    }


    public void deleteJob(Long id) {
        JobsPostings jobsPostings = jobStorage.getById(id).orElse(null);
        chackJobIfNull(id ,jobsPostings);
        jobStorage.delete(jobsPostings);
    }


//    Extra Logics
    private int exactMinsalary(String salaryRange) {
        if(salaryRange == null || salaryRange.isBlank()){
            return 0;
        }
        String minSalary = salaryRange.split("-")[0]
                .replace("k", "")
                .replace("K", "")
                .trim();
        return Integer.parseInt(minSalary);
    }


//    Validate the Object manually
    private void validator(JobsPostings newJob) {
        if(         (newJob.getTitle() == null || newJob.getTitle().trim().isBlank())
                || (newJob.getJobType() == null || newJob.getJobType().trim().isBlank())
                || (newJob.getJobDescription() == null || newJob.getJobDescription().trim().isBlank())
                || (newJob.getLocation() == null || newJob.getLocation().trim().isBlank())
                || (newJob.getSalaryRange() == null || newJob.getSalaryRange().trim().isBlank())
                || (newJob.getCompanyName() == null || newJob.getCompanyName().trim().isBlank())
                || (newJob.getPostedDate().isBefore(LocalDate.now().minusDays(7)))){
            throw new InvalidJobDataException( "Please Enter All The Fields must!" );
        }
    }

//    check the job is null or not
    private void chackJobIfNull( Long id , JobsPostings jobsPostings) {
        if(jobsPostings == null){
            throw new JobNotFoundException("This Job with id : " +  id + " is not Found");
        }
    }

}
