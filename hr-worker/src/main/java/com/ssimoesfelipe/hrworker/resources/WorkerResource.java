package com.ssimoesfelipe.hrworker.resources;

import com.ssimoesfelipe.hrworker.entities.Worker;
import com.ssimoesfelipe.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAllWorkers() {
        List<Worker> allWorkers = workerRepository.findAll();
        return ResponseEntity.ok(allWorkers);
    }

    @GetMapping("/configs")
    public ResponseEntity<Void> config(){
        logger.info("config = " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{workerId}")
    public ResponseEntity<Worker> findById(@PathVariable Long workerId) {
        Worker worker = workerRepository.findById(workerId).get();
        return ResponseEntity.ok(worker);
    }
}
