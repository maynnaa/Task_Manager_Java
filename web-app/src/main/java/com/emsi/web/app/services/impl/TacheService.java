package com.emsi.web.app.services.impl;

import com.emsi.web.app.models.tache;
import com.emsi.web.app.repository.tache_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TacheService {

    @Autowired
    private tache_repository tacheRepository;
    @Autowired
    public TacheService(tache_repository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }

    public void deleteTacheById(Integer id) {
        tacheRepository.deleteById(id);
    }



    public void updateTaskStatus(Integer taskId, String status) {
        Optional<tache> optionalTask = tacheRepository.findByIdtache(taskId);
        if (optionalTask.isPresent()) {
            tache task = optionalTask.get();
            task.setStatus(status);
            tacheRepository.save(task);
        }
    }

    public void saveTache(tache tache) {
        tacheRepository.save(tache);
    }
}

