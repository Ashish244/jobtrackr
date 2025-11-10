package com.example.jobtrackr.service;

import com.example.jobtrackr.domain.Application;
import com.example.jobtrackr.domain.ApplicationStatus;
import com.example.jobtrackr.repo.ApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ApplicationService {
    private final ApplicationRepository repo;

    public ApplicationService(ApplicationRepository repo) {
        this.repo = repo;
    }

    public Application create(Application a) { return repo.save(a); }
    public List<Application> all() { return repo.findAll(); }
    public List<Application> byStatus(ApplicationStatus s) { return repo.findByStatus(s); }
    public Application get(Long id) { return repo.findById(id).orElseThrow(); }

    public Application update(Long id, Application x) {
        Application cur = get(id);
        cur.setCompany(x.getCompany());
        cur.setRole(x.getRole());
        cur.setSource(x.getSource());
        cur.setAppliedOn(x.getAppliedOn());
        cur.setStatus(x.getStatus());
        cur.setNotes(x.getNotes());
        return repo.save(cur);
    }

    public Application updateStatus(Long id, ApplicationStatus s){
        Application cur = get(id);
        cur.setStatus(s);
        return repo.save(cur);
    }

    public void delete(Long id) { repo.deleteById(id); }
}
