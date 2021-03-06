package Model;

import Contract.Cell;
import Contract.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CenterCellTest {

    Manager manager;
    Cell cell;

    @BeforeEach
    void BeforeTest(){
        manager=mock(Manager.class);
        cell=new CenterCell(2,2);
    }
    @Test
    void checkAliveCellWhenAllAreAlive() {

        when(manager.get(1,1)).thenReturn(Status.ALIVE);
        when(manager.get(2,1)).thenReturn(Status.ALIVE);
        when(manager.get(1,2)).thenReturn(Status.ALIVE);
        when(manager.get(1,3)).thenReturn(Status.ALIVE);
        when(manager.get(2,3)).thenReturn(Status.ALIVE);
        when(manager.get(3,1)).thenReturn(Status.ALIVE);
        when(manager.get(3,2)).thenReturn(Status.ALIVE);
        when(manager.get(3,3)).thenReturn(Status.ALIVE);

        cell.checkAliveCell(manager);

        assertEquals(8, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenHalfCellsIsAlive() {

        when(manager.get(1,1)).thenReturn(Status.ALIVE);
        when(manager.get(2,1)).thenReturn(Status.ALIVE);
        when(manager.get(1,2)).thenReturn(Status.ALIVE);
        when(manager.get(1,3)).thenReturn(Status.DEAD);
        when(manager.get(2,3)).thenReturn(Status.DEAD);
        when(manager.get(3,1)).thenReturn(Status.DEAD);
        when(manager.get(3,2)).thenReturn(Status.DEAD);
        when(manager.get(3,3)).thenReturn(Status.ALIVE);

        cell.checkAliveCell(manager);

        assertEquals(4, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreDead() {

        when(manager.get(1,1)).thenReturn(Status.DEAD);
        when(manager.get(2,1)).thenReturn(Status.DEAD);
        when(manager.get(1,2)).thenReturn(Status.DEAD);
        when(manager.get(1,3)).thenReturn(Status.DEAD);
        when(manager.get(2,3)).thenReturn(Status.DEAD);
        when(manager.get(3,1)).thenReturn(Status.DEAD);
        when(manager.get(3,2)).thenReturn(Status.DEAD);
        when(manager.get(3,3)).thenReturn(Status.DEAD);

        cell.checkAliveCell(manager);

        assertEquals(0, cell.getNumberOfAliveCell());

    }

}