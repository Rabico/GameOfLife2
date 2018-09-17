package Model;

import Contract.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Manager manager;

    @BeforeEach
    void BeforeTest() {
        manager = new Manager(3, 3);
    }

    @Test
    void setAliveStatusTestForSecondCell() {
        manager.setStatus(Status.ALIVE, 1, 0);
        assertEquals(manager.get(1,0), Status.ALIVE);

    }

    @Test
    void setAliveStatusTestForThirdCell() {
        manager.setStatus(Status.ALIVE, 2, 0);
        assertEquals(manager.get(2,0), Status.ALIVE);

    }

    @Test
    void setAliveStatusTestForFourthCell() {
        manager.setStatus(Status.ALIVE, 0, 1);
        assertEquals(manager.get(0,1), Status.ALIVE);

    }

    @Test
    void setAliveStatusTestForFifthCell() {
        manager.setStatus(Status.ALIVE, 1, 1);
        assertEquals(manager.get(1,1), Status.ALIVE);

    }

    @Test
    void setAliveStatusTestForSixthCell() {
        manager.setStatus(Status.ALIVE, 2, 1);
        assertEquals(manager.get(2,1), Status.ALIVE);

    }

    @Test
    void setAliveStatusTestForSeventhCell() {
        manager.setStatus(Status.ALIVE, 0, 2);
        assertEquals(manager.get(0,2), Status.ALIVE);

    }

    @Test
    void setAliveStatusTestForEightCell() {
        manager.setStatus(Status.ALIVE, 1, 2);
        assertEquals(manager.get(1,2), Status.ALIVE);

    }

    @Test
    void setAliveStatusTestForNinthCell() {
        manager.setStatus(Status.ALIVE, 2, 2);
        assertEquals(manager.get(2,2), Status.ALIVE);

    }

    @Test
    void setDeadStatusTestForFirstCell() {
        manager.setStatus(Status.DEAD, 0, 0);
        assertEquals(manager.get(1,0), Status.DEAD);

    }

    @Test
    void setDeadStatusTestForSecondCell() {
        manager.setStatus(Status.DEAD, 1, 0);
        assertEquals(manager.get(1,0), Status.DEAD);

    }

    @Test
    void setDeadStatusTestForThirdCell() {
        manager.setStatus(Status.DEAD, 2, 0);
        assertEquals(manager.get(2,0), Status.DEAD);

    }

    @Test
    void setDeadStatusTestForFourthCell() {
        manager.setStatus(Status.DEAD, 0, 1);
        assertEquals(manager.get(0,1), Status.DEAD);

    }

    @Test
    void setDeadStatusTestForFifthCell() {
        manager.setStatus(Status.DEAD, 1, 1);
        assertEquals(manager.get(1,1), Status.DEAD);

    }

    @Test
    void setDeadStatusTestForSixthCell() {
        manager.setStatus(Status.DEAD, 2, 1);
        assertEquals(manager.get(2, 1), Status.DEAD);

    }

    @Test
    void setDeadStatusTestForSeventhCell() {
        manager.setStatus(Status.DEAD, 0, 2);
        assertEquals(manager.get(0, 2), Status.DEAD);

    }

    @Test
    void setDeadStatusTestForEightCell() {
        manager.setStatus(Status.DEAD, 1, 2);
        assertEquals(manager.get(1, 2), Status.DEAD);

    }

    @Test
    void setDeadStatusTestForNinthCell() {
        manager.setStatus(Status.DEAD, 2, 2);
        assertEquals(manager.get(2, 2), Status.DEAD);

    }

}

