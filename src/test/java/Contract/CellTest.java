package Contract;

import Model.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

//Done

class CellTest {

    Cell cell;

    @BeforeEach

    public void BeforeTest(){
        cell = Mockito.mock(Cell.class);
    }


    @Test
    void checkStatusAliveCellWithZeroAliveNeighbors() {
        Mockito.doCallRealMethod().when(cell).checkStatus();

        cell.numberOfAliveCell=0;
        cell.status=Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status,Status.DEAD);
        assertEquals(cell.hasItChanged,true);

    }

    @Test
    void checkStatusAliveCellWithOneAliveNeighbor() {
        Mockito.doCallRealMethod().when(cell).checkStatus();

        cell.numberOfAliveCell=1;
        cell.status=Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status,Status.DEAD);
        assertEquals(cell.hasItChanged,true);

    }

    @Test
    void checkStatusAliveCellWithTwoAliveNeighbors() {
    Mockito.doCallRealMethod().when(cell).checkStatus();

    cell.numberOfAliveCell=2;
    cell.status=Status.ALIVE;

    cell.checkStatus();

    assertEquals(cell.status,Status.ALIVE);
    assertEquals(cell.hasItChanged,false);

    }

    @Test
    void checkStatusAliveCellWithThreeAliveNeighbors() {
        Mockito.doCallRealMethod().when(cell).checkStatus();

        cell.numberOfAliveCell=3;
        cell.status=Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status,Status.ALIVE);
        assertEquals(cell.hasItChanged,false);
    }

    @Test
    void checkStatusAliveCellWithFourAliveNeighbors() {
        Mockito.doCallRealMethod().when(cell).checkStatus();

        cell.numberOfAliveCell=4;
        cell.status=Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status,Status.DEAD);
        assertEquals(cell.hasItChanged,true);
    }

    @Test
    void checkStatusAliveCellWithFiveAliveNeighbors() {
        Mockito.doCallRealMethod().when(cell).checkStatus();

        cell.numberOfAliveCell=5;
        cell.status=Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status,Status.DEAD);
        assertEquals(cell.hasItChanged,true);

    }

    @Test
    void checkStatusAliveCellWithNineAliveNeighbors() {
        Mockito.doCallRealMethod().when(cell).checkStatus();

        cell.numberOfAliveCell=9;
        cell.status=Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status,Status.DEAD);
        assertEquals(cell.hasItChanged,true);

    }

    @Test
    void checkStatusDeadCellWithZeroAliveNeighbors() {
        Mockito.doCallRealMethod().when(cell).checkStatus();

        cell.numberOfAliveCell=0;
        cell.status=Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status,Status.DEAD);
        assertEquals(cell.hasItChanged,false);
    }

    @Test
    void checkStatusDeadCellWithOneAliveNeighbors() {
        Mockito.doCallRealMethod().when(cell).checkStatus();

        cell.numberOfAliveCell=1;
        cell.status=Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status,Status.DEAD);
        assertEquals(cell.hasItChanged,false);

    }

    @Test
    void checkStatusDeadCellWithTwoAliveNeighbors() {
        Mockito.doCallRealMethod().when(cell).checkStatus();

        cell.numberOfAliveCell=2;
        cell.status=Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status,Status.DEAD);
        assertEquals(cell.hasItChanged,false);

    }

    @Test
    void checkStatusDeadCellWithThreeAliveNeighbors() {
        Mockito.doCallRealMethod().when(cell).checkStatus();

        cell.numberOfAliveCell=3;
        cell.status=Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status,Status.ALIVE);
        assertEquals(cell.hasItChanged,true);
    }


    @Test
    void checkStatusDeadCellWithFourAliveNeighbors() {
        Mockito.doCallRealMethod().when(cell).checkStatus();

        cell.numberOfAliveCell=4;
        cell.status=Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status,Status.DEAD);
        assertEquals(cell.hasItChanged,false);


    }

    @Test
    void checkStatusDeadCellWithNineAliveNeighbors() {
        Mockito.doCallRealMethod().when(cell).checkStatus();

        cell.numberOfAliveCell=9;
        cell.status=Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status,Status.DEAD);
        assertEquals(cell.hasItChanged,false);

    }


}