package com.ssimoesfelipe.hrworker.resources;

import com.ssimoesfelipe.hrworker.entities.Worker;
import com.ssimoesfelipe.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAllWorkers(){
        List<Worker> allWorkers = workerRepository.findAll();
        return ResponseEntity.ok(allWorkers);
    }

    @GetMapping("/{workerId}")
    public ResponseEntity<Worker> findById(@PathVariable Long workerId){
        Worker worker = workerRepository.findById(workerId).get();
        return ResponseEntity.ok(worker);
    }
}
