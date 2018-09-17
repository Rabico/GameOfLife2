package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SystemTest {

    System system;
    Manager manager;

    @BeforeEach
    void BeforeTest(){
        system = new System(3,3);
        manager= Mockito.mock(Manager.class);
    }

    @Test
    public void checkFirstCell(){
        assertTrue(system.system[0][0] instanceof LeftTopCell);
    }

    @Test
    public void checkSecondCell(){
        assertTrue(system.system[1][0] instanceof TopCell);
    }

    @Test
    public void checkThirdCell(){
        assertTrue(system.system[2][0] instanceof RightTopCell);
    }

    @Test
    public void checkFourthCell(){
        assertTrue(system.system[0][1] instanceof LeftCell);
    }

    @Test
    public void checkFifthCell(){
        assertTrue(system.system[1][1] instanceof CenterCell);
    }

    @Test
    public void checkSixthCell(){
        assertTrue(system.system[2][1] instanceof RightCell);
    }

    @Test
    public void checkSeventhCell(){
        assertTrue(system.system[0][2] instanceof LeftDownCell);
    }

    @Test
    public void checkEightCell(){
        assertTrue(system.system[1][2] instanceof DownCell);
    }

    @Test
    public void checkNinthCell(){
        assertTrue(system.system[2][2] instanceof RightDownCell);
    }



    @Test
    void checkAliveCell() {
    }

    @Test
    void checkStatus() {
    }

    @Test
    void sendStatus() {
    }

    @Test
    void setStatusToBegin() {
    }
}