package com.example.jobtrackr.api;

import com.example.jobtrackr.domain.Application;
import com.example.jobtrackr.domain.ApplicationStatus;
import com.example.jobtrackr.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applications")
public class ApplicationController {
    private final ApplicationService svc;
    public ApplicationController(ApplicationService svc){ this.svc = svc; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Application create(@RequestBody @Valid Application a){ return svc.create(a); }

    @GetMapping
    public List<Application> all(@RequestParam(required = false) ApplicationStatus status){
        return status == null ? svc.all() : svc.byStatus(status);
    }

    @GetMapping("/{id}")
    public Application one(@PathVariable Long id){ return svc.get(id); }

    @PutMapping("/{id}")
    public Application update(@PathVariable Long id, @RequestBody @Valid Application a){ return svc.update(id, a); }

    @PatchMapping("/{id}/status")
    public Application patchStatus(@PathVariable Long id, @RequestParam ApplicationStatus status){
        return svc.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ svc.delete(id); }
}
