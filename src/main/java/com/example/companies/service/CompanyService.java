package com.example.companies.service;

import com.example.companies.entity.Company;
import com.example.companies.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository repository;

    public Company saveCompany(Company company) {
        return repository.save(company);
    }

    public List<Company> getCompanies() {
        return repository.findAll();
    }

    public Company getCompany(int id) {
        return repository.findById(id).orElse(null);
    }

    public String delCompany(int id) {
        repository.deleteById(id);
        return "Company deleted id " + id;
    }

    public Company updateCompany(Company company) {
        Company existingCompany = repository.findById(company.getId()).orElse(null);
        if (existingCompany != null ) {
            existingCompany.setName(company.getName());
            existingCompany.setAddress1(company.getAddress1());
            existingCompany.setAddress2(company.getAddress2());
            existingCompany.setCity(company.getCity());
            existingCompany.setZipcode(company.getZipcode());
            existingCompany.setContact(company.getContact());
            existingCompany.setIndustry(company.getIndustry());
            existingCompany.setContact(company.getContact());
            existingCompany.setPhoneNumber(company.getPhoneNumber());
            existingCompany.setIndustry(company.getIndustry());
        }
        return repository.save(existingCompany);
    }

}
