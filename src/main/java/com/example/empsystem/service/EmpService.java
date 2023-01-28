package com.example.empsystem.service;

import com.example.empsystem.entity.Employee;
import com.example.empsystem.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepo repo;

    public void addEmp(Employee e) {
        repo.save(e);
    }

    public void updateEmp(int id, String name, String address, String email, String phno, int salary) {
        Employee e = getEMpById(id);
        e.setName(name);
        e.setAddress(address);
        e.setEmail(email);
        e.setPhno(phno);
        e.setSalary(salary);
        repo.save(e);
    }

    public List<Employee> getAllEmp() {
        return repo.findAll();
    }

    public Employee getEMpById(int id) {
        Optional<Employee> e = repo.findById(id);
        if (e.isPresent()) {
            return e.get();
        }
        return null;
    }

    public void deleteEMp(int id) {
        repo.deleteById(id);
    }

    public List<Employee> getEMpByPaginate() {
        return repo.findAll();
    }

}
