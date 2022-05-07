package kcm.project.manager.repository;

import kcm.project.manager.domain.Manager;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ManagerRepository {

    private static Map<Long, Manager> store = new HashMap<>(); //동시성 이슈가 발생할 수 있음

    private static long sequence = 0L;

    public Manager join(Manager manager){
        manager.setId(++sequence);
        store.put(manager.getId(), manager);
        return manager;
    }

    public Manager findById(Long id){
        return store.get(id);
    }
}
