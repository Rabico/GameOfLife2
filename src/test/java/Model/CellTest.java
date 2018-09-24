package Model;

import Contract.Status;
import Model.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//Done

class CellTest {

    Manager manager;
    Cell cell;

    @BeforeEach

    public void BeforeTest() {
        manager = mock(Manager.class);

    }


    @Test
    void checkStatusAliveCellWithZeroAliveNeighbors() {
        Mockito.doCallRealMethod().when(cell).checkStatus();

        cell = new Cell(2, 2, 3, 3);
        cell.numberOfAliveCell = 0;
        cell.status = Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals(cell.hasItChanged, true);

    }

    @Test
    void checkStatusAliveCellWithOneAliveNeighbor() {
        Mockito.doCallRealMethod().when(cell).checkStatus();

        cell = new Cell(2, 2, 3, 3);
        cell.numberOfAliveCell = 1;
        cell.status = Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals(cell.hasItChanged, true);

    }

    @Test
    void checkStatusAliveCellWithTwoAliveNeighbors() {


        cell = new Cell(2, 2, 3, 3);
        cell.numberOfAliveCell = 2;
        cell.status = Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status, Status.ALIVE);
        assertEquals(cell.hasItChanged, false);

    }

    @Test
    void checkStatusAliveCellWithThreeAliveNeighbors() {
        cell = new Cell(2, 2, 3, 3);

        cell.numberOfAliveCell = 3;
        cell.status = Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status, Status.ALIVE);
        assertEquals(cell.hasItChanged, false);
    }

    @Test
    void checkStatusAliveCellWithFourAliveNeighbors() {

        cell = new Cell(2, 2, 3, 3);
        cell.numberOfAliveCell = 4;
        cell.status = Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals(cell.hasItChanged, true);
    }

    @Test
    void checkStatusAliveCellWithFiveAliveNeighbors() {

        cell = new Cell(2, 2, 3, 3);

        cell.numberOfAliveCell = 5;
        cell.status = Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals(cell.hasItChanged, true);

    }

    @Test
    void checkStatusAliveCellWithNineAliveNeighbors() {
        cell = new Cell(2, 2, 3, 3);

        cell.numberOfAliveCell = 9;
        cell.status = Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals(cell.hasItChanged, true);

    }

    @Test
    void checkStatusDeadCellWithZeroAliveNeighbors() {
        cell = new Cell(2, 2, 3, 3);

        cell.numberOfAliveCell = 0;
        cell.status = Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals(cell.hasItChanged, false);
    }

    @Test
    void checkStatusDeadCellWithOneAliveNeighbors() {
        cell = new Cell(2, 2, 3, 3);

        cell.numberOfAliveCell = 1;
        cell.status = Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals(cell.hasItChanged, false);

    }

    @Test
    void checkStatusDeadCellWithTwoAliveNeighbors() {
        cell = new Cell(2, 2, 3, 3);

        cell.numberOfAliveCell = 2;
        cell.status = Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals(cell.hasItChanged, false);

    }

    @Test
    void checkStatusDeadCellWithThreeAliveNeighbors() {
        cell = new Cell(2, 2, 3, 3);

        cell.numberOfAliveCell = 3;
        cell.status = Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status, Status.ALIVE);
        assertEquals(cell.hasItChanged, true);
    }


    @Test
    void checkStatusDeadCellWithFourAliveNeighbors() {
        cell = new Cell(2, 2, 3, 3);

        cell.numberOfAliveCell = 4;
        cell.status = Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals(cell.hasItChanged, false);


    }

    @Test
    void checkStatusDeadCellWithNineAliveNeighbors() {
        cell = new Cell(2, 2, 3, 3);

        cell.numberOfAliveCell = 9;
        cell.status = Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals(cell.hasItChanged, false);

    }

    @Test
    void checkAliveCellWhenAllAreAliveForCenterCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(1, 1)).thenReturn(Status.ALIVE);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.ALIVE);
        when(manager.get(1, 3)).thenReturn(Status.ALIVE);
        when(manager.get(2, 3)).thenReturn(Status.ALIVE);
        when(manager.get(3, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 2)).thenReturn(Status.ALIVE);
        when(manager.get(3, 3)).thenReturn(Status.ALIVE);

        cell.checkAliveCell(manager);

        assertEquals(8, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenHalfCellsIsAliveForCenterCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(1, 1)).thenReturn(Status.ALIVE);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.ALIVE);
        when(manager.get(1, 3)).thenReturn(Status.DEAD);
        when(manager.get(2, 3)).thenReturn(Status.DEAD);
        when(manager.get(3, 1)).thenReturn(Status.DEAD);
        when(manager.get(3, 2)).thenReturn(Status.DEAD);
        when(manager.get(3, 3)).thenReturn(Status.ALIVE);

        cell.checkAliveCell(manager);

        assertEquals(4, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreDeadForCenterCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(1, 1)).thenReturn(Status.DEAD);
        when(manager.get(2, 1)).thenReturn(Status.DEAD);
        when(manager.get(1, 2)).thenReturn(Status.DEAD);
        when(manager.get(1, 3)).thenReturn(Status.DEAD);
        when(manager.get(2, 3)).thenReturn(Status.DEAD);
        when(manager.get(3, 1)).thenReturn(Status.DEAD);
        when(manager.get(3, 2)).thenReturn(Status.DEAD);
        when(manager.get(3, 3)).thenReturn(Status.DEAD);

        cell.checkAliveCell(manager);

        assertEquals(0, cell.getNumberOfAliveCell());


    }

    @Test
    void checkAliveCellWhenAllAreAliveForDownCell() {
        cell = new Cell(2, 2, 2, 3);
        when(manager.get(1, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.ALIVE);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 2)).thenReturn(Status.ALIVE);

        cell.checkAliveCell(manager);

        assertEquals(5, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenHalfCellsIsAliveForDownCell() {
        cell = new Cell(2, 2, 2, 3);
        when(manager.get(1, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.ALIVE);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 1)).thenReturn(Status.DEAD);
        when(manager.get(3, 2)).thenReturn(Status.DEAD);

        cell.checkAliveCell(manager);

        assertEquals(3, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreDeadForDownCell() {
        cell = new Cell(2, 2, 2, 3);
        when(manager.get(1, 1)).thenReturn(Status.DEAD);
        when(manager.get(1, 2)).thenReturn(Status.DEAD);
        when(manager.get(2, 1)).thenReturn(Status.DEAD);
        when(manager.get(3, 1)).thenReturn(Status.DEAD);
        when(manager.get(3, 2)).thenReturn(Status.DEAD);

        cell.checkAliveCell(manager);

        assertEquals(0, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreAliveForLeftCell() {
        cell = new Cell(2, 0, 3, 3);
        when(manager.get(1, 1)).thenReturn(Status.ALIVE);
        when(manager.get(0, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.ALIVE);
        when(manager.get(0, 3)).thenReturn(Status.ALIVE);
        when(manager.get(1, 3)).thenReturn(Status.ALIVE);

        cell.checkAliveCell(manager);

        assertEquals(5, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenHalfCellsIsAliveForLeftCell() {
        cell = new Cell(2, 0, 3, 3);
        when(manager.get(1, 1)).thenReturn(Status.ALIVE);
        when(manager.get(0, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.ALIVE);
        when(manager.get(0, 3)).thenReturn(Status.DEAD);
        when(manager.get(1, 3)).thenReturn(Status.DEAD);
        cell.checkAliveCell(manager);

        assertEquals(3, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreDeadForLeftCell() {
        cell = new Cell(2, 0, 3, 3);
        when(manager.get(1, 1)).thenReturn(Status.DEAD);
        when(manager.get(0, 1)).thenReturn(Status.DEAD);
        when(manager.get(1, 2)).thenReturn(Status.DEAD);
        when(manager.get(0, 3)).thenReturn(Status.DEAD);
        when(manager.get(1, 3)).thenReturn(Status.DEAD);
        cell.checkAliveCell(manager);

        assertEquals(0, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreAliveForLeftDownCell() {
        cell = new Cell(2, 0, 3, 3);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 2)).thenReturn(Status.ALIVE);

        cell.LeftDownCellCount(manager);

        assertEquals(3, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenHalfCellsIsAliveForLeftDownCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 2)).thenReturn(Status.DEAD);
        cell.LeftDownCellCount(manager);

        assertEquals(2, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreDeadForLeftDownCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(2, 1)).thenReturn(Status.DEAD);
        when(manager.get(3, 1)).thenReturn(Status.DEAD);
        when(manager.get(3, 2)).thenReturn(Status.DEAD);
        cell.LeftDownCellCount(manager);

        assertEquals(0, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreAliveForLeftTopCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(2, 3)).thenReturn(Status.ALIVE);
        when(manager.get(3, 3)).thenReturn(Status.ALIVE);
        when(manager.get(3, 2)).thenReturn(Status.ALIVE);

        cell.LeftTopCellCount(manager);

        assertEquals(3, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenHalfCellsIsAliveForLeftTopCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(2, 3)).thenReturn(Status.ALIVE);
        when(manager.get(3, 3)).thenReturn(Status.ALIVE);
        when(manager.get(3, 2)).thenReturn(Status.DEAD);

        cell.LeftTopCellCount(manager);

        assertEquals(2, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreDeadForLeftTopCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(2, 3)).thenReturn(Status.DEAD);
        when(manager.get(3, 3)).thenReturn(Status.DEAD);
        when(manager.get(3, 2)).thenReturn(Status.DEAD);
        cell.LeftTopCellCount(manager);

        assertEquals(0, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreAliveForRightCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(1, 1)).thenReturn(Status.ALIVE);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.ALIVE);
        when(manager.get(1, 3)).thenReturn(Status.ALIVE);
        when(manager.get(2, 3)).thenReturn(Status.ALIVE);

        cell.RightCellCount(manager);

        assertEquals(5, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenHalfCellsIsAliveForRightCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(1, 1)).thenReturn(Status.ALIVE);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.ALIVE);
        when(manager.get(1, 3)).thenReturn(Status.DEAD);
        when(manager.get(2, 3)).thenReturn(Status.DEAD);

        cell.RightCellCount(manager);

        assertEquals(3, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreDeadForRightCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(1, 1)).thenReturn(Status.DEAD);
        when(manager.get(2, 1)).thenReturn(Status.DEAD);
        when(manager.get(1, 2)).thenReturn(Status.DEAD);
        when(manager.get(1, 3)).thenReturn(Status.DEAD);
        when(manager.get(2, 3)).thenReturn(Status.DEAD);

        cell.RightCellCount(manager);

        assertEquals(0, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreAliveForRightDownCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.ALIVE);

        cell.RightDownCellCount(manager);

        assertEquals(3, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenHalfCellsIsAliveForRightDownCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.DEAD);

        cell.RightDownCellCount(manager);

        assertEquals(2, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreDeadForRightDownCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(2, 1)).thenReturn(Status.DEAD);
        when(manager.get(1, 1)).thenReturn(Status.DEAD);
        when(manager.get(1, 2)).thenReturn(Status.DEAD);

        cell.RightDownCellCount(manager);

        assertEquals(0, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreAliveForRightTopCell() {
        cell = new Cell(2, 2, 3, 3);

        when(manager.get(2, 3)).thenReturn(Status.ALIVE);
        when(manager.get(1, 3)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.ALIVE);

        cell.RightTopCellCount(manager);

        assertEquals(3, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreAliveForTopCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(1,3)).thenReturn(Status.ALIVE);
        when(manager.get(1,2)).thenReturn(Status.ALIVE);
        when(manager.get(2,3)).thenReturn(Status.ALIVE);
        when(manager.get(3,3)).thenReturn(Status.ALIVE);
        when(manager.get(3,2)).thenReturn(Status.ALIVE);

        cell.TopCellCount(manager);

        assertEquals(5, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenHalfCellsIsAliveForTopCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(1,3)).thenReturn(Status.ALIVE);
        when(manager.get(1,2)).thenReturn(Status.ALIVE);
        when(manager.get(2,3)).thenReturn(Status.ALIVE);
        when(manager.get(3,3)).thenReturn(Status.DEAD);
        when(manager.get(3,2)).thenReturn(Status.DEAD);

        cell.TopCellCount(manager);

        assertEquals(3, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreDeadForTopCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(1,3)).thenReturn(Status.DEAD);
        when(manager.get(1,2)).thenReturn(Status.DEAD);
        when(manager.get(2,3)).thenReturn(Status.DEAD);
        when(manager.get(3,3)).thenReturn(Status.DEAD);
        when(manager.get(3,2)).thenReturn(Status.DEAD);

        cell.TopCellCount(manager);
        
        assertEquals(0, cell.getNumberOfAliveCell());

    }
}
