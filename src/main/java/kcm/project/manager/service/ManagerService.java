package kcm.project.manager.service;

import kcm.project.manager.domain.Manager;
import kcm.project.manager.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager join(Manager manager){
        Manager joinManager = managerRepository.join(manager);
        return joinManager;
    }

    public Manager findById(Long id){
        Manager findManager = managerRepository.findById(id);
        return findManager;
    }
}
