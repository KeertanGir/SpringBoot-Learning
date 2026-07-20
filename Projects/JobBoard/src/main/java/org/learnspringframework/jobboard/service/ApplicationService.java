package org.learnspringframework.jobboard.service;

import jakarta.validation.Valid;
import org.learnspringframework.jobboard.dtos.ApplicationResponseDto;
import org.learnspringframework.jobboard.dtos.ApplicationsRequestDto;
import org.learnspringframework.jobboard.entities.Applications;
import org.learnspringframework.jobboard.exceptions.ApplicationNotFoundException;
import org.learnspringframework.jobboard.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

     private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
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


    private ApplicationResponseDto  mapToApplicationDto(Applications applications){
        return new ApplicationResponseDto(
                applications.getId(),
                applications.getJob_id(),
                applications.getCandidate_id(),
                applications.getStatus(),
                applications.getAppliedDate(),
                applications.getResumeUrl()
        );
    }

    private Applications mapToEntity(ApplicationsRequestDto applicationsRequestDto){
        return new Applications(
                applicationsRequestDto.getJob_id(),
                applicationsRequestDto.getCandidate_id(),
                applicationsRequestDto.getStatus(),
                applicationsRequestDto.getAppliedDate(),
                applicationsRequestDto.getResumeUrl()
        );
    }

    public Applications createApplication(ApplicationsRequestDto applicationsRequestDto) {
        Applications applications = mapToEntity(applicationsRequestDto);
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

        applications.setJob_id(applicationsRequestDto.getJob_id());
        applications.setCandidate_id(applicationsRequestDto.getCandidate_id());
        applications.setStatus(applicationsRequestDto.getStatus());
        applications.setAppliedDate(applicationsRequestDto.getAppliedDate());
        applications.setResumeUrl(applicationsRequestDto.getResumeUrl());

        applicationRepository.save(applications);
    }
}
