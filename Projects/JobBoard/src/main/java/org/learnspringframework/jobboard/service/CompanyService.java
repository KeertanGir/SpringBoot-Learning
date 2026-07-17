package org.learnspringframework.jobboard.service;

import jakarta.validation.Valid;
import org.learnspringframework.jobboard.dtos.CompanyRequestDto;
import org.learnspringframework.jobboard.dtos.CompanyResponseDto;
import org.learnspringframework.jobboard.entities.Company;
import org.learnspringframework.jobboard.exceptions.CompanyNotFoundException;
import org.learnspringframework.jobboard.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyResponseDto> getAllCompanies() {
        List<CompanyResponseDto> companyList = companyRepository.findAll().stream().map(this::mapToCompanyDto).toList();
        if(companyList.isEmpty()){
            throw new CompanyNotFoundException("No any Company Found");
        }
        return companyList;
    }

    public CompanyResponseDto getCompanyById(Long id) {
        Company byId = companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException("No any Company Found By Id : "+ id));
        CompanyResponseDto company = mapToCompanyDto(byId);
        return company;

    }

    public Company createCompany(CompanyRequestDto companyRequestDto) {
        Company company = mapToCompany(companyRequestDto);
        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() ->
            new CompanyNotFoundException("Company Not Found by id : " + id));
        companyRepository.deleteById(id);
    }

    public void updateCompany(Long id, @Valid CompanyRequestDto companyRequestDto) {
        Company byId = companyRepository.findById(id).orElseThrow(() ->
                new CompanyNotFoundException("Company Not Found by id : " + id));
        Company company = mapToCompany(companyRequestDto);
        companyRepository.save(company);
    }



    private CompanyResponseDto mapToCompanyDto(Company company){
        return new CompanyResponseDto(
            company.getName(),
            company.getDescription(),
            company.getCompanySite()
        );
    }

    private Company mapToCompany(CompanyRequestDto companyRequestDto){
        return new Company(
                companyRequestDto.getName(),
                companyRequestDto.getDescription(),
                companyRequestDto.getCompanySite()
        );
    }



}
