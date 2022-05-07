package kcm.project.manager.repository;

import kcm.project.manager.domain.Manager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ManagerRepositoryTest {

    ManagerRepository managerRepository = new ManagerRepository();

    @Test
    void join() {

        //given
        Manager manager = new Manager();
        manager.setEmail("noel6707@gmail.com");
        manager.setPassword("123");

        //when
        Manager joinManager = managerRepository.join(manager);


        //then
        Manager findManager = managerRepository.findById(joinManager.getId());
        Assertions.assertThat(joinManager).isEqualTo(findManager);

    }
}