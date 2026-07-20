package org.learnspringframework.jobboard.service;

import jakarta.validation.Valid;
import org.learnspringframework.jobboard.dtos.ApplicationResponseDto;
import org.learnspringframework.jobboard.dtos.ApplicationsRequestDto;
import org.learnspringframework.jobboard.entities.Applications;
import org.learnspringframework.jobboard.entities.JobsPostings;
import org.learnspringframework.jobboard.entities.Users;
import org.learnspringframework.jobboard.exceptions.ApplicationNotFoundException;
import org.learnspringframework.jobboard.exceptions.JobNotFoundException;
import org.learnspringframework.jobboard.exceptions.UserNotFoundException;
import org.learnspringframework.jobboard.repository.ApplicationRepository;
import org.learnspringframework.jobboard.repository.JobRepository;
import org.learnspringframework.jobboard.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

     private final ApplicationRepository applicationRepository;
     private final UserRepository userRepository;
     private final JobRepository jobRepository;

//    public ApplicationService(ApplicationRepository applicationRepository) {
//        this.applicationRepository = applicationRepository;
//    }


    public ApplicationService(ApplicationRepository applicationRepository, UserRepository userRepository, JobRepository jobRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }


    public List<ApplicationResponseDto> getAllApplications() {
        List<Applications> applicationsList = applicationRepository.findAll();
        if(applicationsList.isEmpty()){
            throw new ApplicationNotFoundException("No Any Application Found Here");
        }
        return applicationsList.stream().map(this::mapToApplicationDto).toList();
    }


    public ApplicationResponseDto getById(Long id) {
        Applications applications = applicationRepository.findById(id).orElseThrow(
                () -> new ApplicationNotFoundException("Application Not Found By Id : " + id));
        return mapToApplicationDto(applications);
    }


    public ApplicationResponseDto  mapToApplicationDto(Applications applications){
        return new ApplicationResponseDto(
                applications.getId(),
                applications.getStatus(),
                applications.getAppliedDate(),
                applications.getResumeUrl(),
                applications.getJob().getId(),
                applications.getJob().getTitle(),
                applications.getJob().getJobType(),
                applications.getCandidate().getId(),
                applications.getCandidate().getFullName(),
                applications.getCandidate().getEmail()
        );
    }

    private Applications mapToEntity(ApplicationsRequestDto applicationsRequestDto, JobsPostings jobs, Users user ){
        return new Applications(
                null,
                applicationsRequestDto.getStatus(),
                applicationsRequestDto.getAppliedDate(),
                applicationsRequestDto.getResumeUrl(),
                jobs,
                user
        );
    }

    public Applications createApplication(ApplicationsRequestDto applicationsRequestDto) {

        JobsPostings jobsPostings = jobRepository.findById(applicationsRequestDto.getJob_id()).orElseThrow(() -> new JobNotFoundException("User Not Found by Id  : " + applicationsRequestDto.getJob_id()));
        Users user = userRepository.findById(applicationsRequestDto.getCandidate_id()).orElseThrow(() -> new UserNotFoundException("User not Found By id : " + applicationsRequestDto.getCandidate_id()));

        Applications applications = mapToEntity(applicationsRequestDto, jobsPostings , user);
        return applicationRepository.save(applications);
    }


    public void deleteApplicationById(Long id) {
        applicationRepository.findById(id).orElseThrow(
                () -> new ApplicationNotFoundException("Application Not Found By Id : " + id));
        applicationRepository.deleteById(id);
    }

    public void updateApplication(Long id, @Valid ApplicationsRequestDto applicationsRequestDto) {
        Applications applications = applicationRepository.findById(id).orElseThrow(
                () -> new ApplicationNotFoundException("Application Not Found By Id : " + id));

        JobsPostings jobsPostings = jobRepository.findById(applicationsRequestDto.getJob_id()).orElseThrow(() -> new JobNotFoundException("User Not Found by Id  : " + applicationsRequestDto.getJob_id()));
        Users user = userRepository.findById(applicationsRequestDto.getCandidate_id()).orElseThrow(() -> new UserNotFoundException("User not Found By id : " + applicationsRequestDto.getCandidate_id()));


        applications.setJob(jobsPostings);
        applications.setCandidate(user);
        applications.setStatus(applicationsRequestDto.getStatus());
        applications.setAppliedDate(applicationsRequestDto.getAppliedDate());
        applications.setResumeUrl(applicationsRequestDto.getResumeUrl());

        applicationRepository.save(applications);
    }
}
