package com.example.companies.controller;

import com.example.companies.entity.Company;
import com.example.companies.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080" )
public class companyController {

    @Autowired
    private CompanyService service;

    @PostMapping("/company")
    public Company addProduct(@RequestBody Company company) {
      if (company.getName() != null) {
          return service.saveCompany(company);
      }  else {
          return null;
      }
    }

    @GetMapping("/company/{id}")
    public Company gindCompanyById(@PathVariable int id) {
        return service.getCompany(id);
    }

    @GetMapping("/companies")
    public List<Company> getCompanies() {
        return service.getCompanies();
    }

    @DeleteMapping("/companyDelete/{id}")
    public String deleteCompany(@PathVariable int id) {
        service.delCompany(id);
        return "Company sucessfully deleted: " + id;
    }

}
