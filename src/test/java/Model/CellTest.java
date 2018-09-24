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
        cell = new Cell(2, 2, 4, 4);

    }

// Test for checkStatus()

    @Test
    void checkStatusAliveCellWithZeroAliveNeighbors() {

        cell.numberOfAliveCell = 0;
        cell.status = Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals( true, cell.hasItChanged);

    }

    @Test
    void checkStatusAliveCellWithOneAliveNeighbor() {

        cell.numberOfAliveCell = 1;
        cell.status = Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals( true, cell.hasItChanged);

    }

    @Test
    void checkStatusAliveCellWithTwoAliveNeighbors() {

        cell.numberOfAliveCell = 2;
        cell.status = Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status, Status.ALIVE);
        assertEquals( false, cell.hasItChanged);

    }

    @Test
    void checkStatusAliveCellWithThreeAliveNeighbors() {

        cell.numberOfAliveCell = 3;
        cell.status = Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status, Status.ALIVE);
        assertEquals( false, cell.hasItChanged);
    }

    @Test
    void checkStatusAliveCellWithFourAliveNeighbors() {

        cell.numberOfAliveCell = 4;
        cell.status = Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals( true, cell.hasItChanged);
    }

    @Test
    void checkStatusAliveCellWithFiveAliveNeighbors() {

        cell.numberOfAliveCell = 5;
        cell.status = Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals( true, cell.hasItChanged);

    }

    @Test
    void checkStatusAliveCellWithNineAliveNeighbors() {

        cell.numberOfAliveCell = 9;
        cell.status = Status.ALIVE;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals( true, cell.hasItChanged);

    }

    @Test
    void checkStatusDeadCellWithZeroAliveNeighbors() {

        cell.numberOfAliveCell = 0;
        cell.status = Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals( false, cell.hasItChanged);
    }

    @Test
    void checkStatusDeadCellWithOneAliveNeighbors() {

        cell.numberOfAliveCell = 1;
        cell.status = Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals( false, cell.hasItChanged);

    }

    @Test
    void checkStatusDeadCellWithTwoAliveNeighbors() {

        cell.numberOfAliveCell = 2;
        cell.status = Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals( false, cell.hasItChanged);

    }

    @Test
    void checkStatusDeadCellWithThreeAliveNeighbors() {

        cell.numberOfAliveCell = 3;
        cell.status = Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status, Status.ALIVE);
        assertEquals(true, cell.hasItChanged);
    }


    @Test
    void checkStatusDeadCellWithFourAliveNeighbors() {

        cell.numberOfAliveCell = 4;
        cell.status = Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals( false, cell.hasItChanged);


    }

    @Test
    void checkStatusDeadCellWithNineAliveNeighbors() {

        cell.numberOfAliveCell = 9;
        cell.status = Status.DEAD;

        cell.checkStatus();

        assertEquals(cell.status, Status.DEAD);
        assertEquals( false, cell.hasItChanged);

    }

    //Test for counter of neighbors

    @Test
    void checkAliveCellWhenAllAreAliveForCenterCell() {

        when(manager.get(1, 1)).thenReturn(Status.ALIVE);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.ALIVE);
        when(manager.get(1, 3)).thenReturn(Status.ALIVE);
        when(manager.get(2, 3)).thenReturn(Status.ALIVE);
        when(manager.get(3, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 2)).thenReturn(Status.ALIVE);
        when(manager.get(3, 3)).thenReturn(Status.ALIVE);

        cell.CenterCellCount(manager);

        assertEquals(8, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenHalfCellsIsAliveForCenterCell() {

        when(manager.get(1, 1)).thenReturn(Status.ALIVE);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.ALIVE);
        when(manager.get(1, 3)).thenReturn(Status.DEAD);
        when(manager.get(2, 3)).thenReturn(Status.DEAD);
        when(manager.get(3, 1)).thenReturn(Status.DEAD);
        when(manager.get(3, 2)).thenReturn(Status.DEAD);
        when(manager.get(3, 3)).thenReturn(Status.ALIVE);

        cell.CenterCellCount(manager);

        assertEquals(4, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreDeadForCenterCell() {

        when(manager.get(1, 1)).thenReturn(Status.DEAD);
        when(manager.get(2, 1)).thenReturn(Status.DEAD);
        when(manager.get(1, 2)).thenReturn(Status.DEAD);
        when(manager.get(1, 3)).thenReturn(Status.DEAD);
        when(manager.get(2, 3)).thenReturn(Status.DEAD);
        when(manager.get(3, 1)).thenReturn(Status.DEAD);
        when(manager.get(3, 2)).thenReturn(Status.DEAD);
        when(manager.get(3, 3)).thenReturn(Status.DEAD);

        cell.CenterCellCount(manager);

        assertEquals(0, cell.getNumberOfAliveCell());


    }

    @Test
    void checkAliveCellWhenAllAreAliveForDownCell() {

        when(manager.get(1, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.ALIVE);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 2)).thenReturn(Status.ALIVE);

        cell.DownCellCount(manager);

        assertEquals(5, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenHalfCellsIsAliveForDownCell() {

        when(manager.get(1, 1)).thenReturn(Status.ALIVE);
        when(manager.get(1, 2)).thenReturn(Status.ALIVE);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 1)).thenReturn(Status.DEAD);
        when(manager.get(3, 2)).thenReturn(Status.DEAD);

        cell.DownCellCount(manager);

        assertEquals(3, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreDeadForDownCell() {

        when(manager.get(1, 1)).thenReturn(Status.DEAD);
        when(manager.get(1, 2)).thenReturn(Status.DEAD);
        when(manager.get(2, 1)).thenReturn(Status.DEAD);
        when(manager.get(3, 1)).thenReturn(Status.DEAD);
        when(manager.get(3, 2)).thenReturn(Status.DEAD);

        cell.DownCellCount(manager);

        assertEquals(0, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreAliveForLeftCell() {

        when(manager.get(3, 1)).thenReturn(Status.ALIVE);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 2)).thenReturn(Status.ALIVE);
        when(manager.get(2, 3)).thenReturn(Status.ALIVE);
        when(manager.get(3, 3)).thenReturn(Status.ALIVE);

        cell.LeftCellCount(manager);

        assertEquals(5, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenHalfCellsIsAliveForLeftCell() {

        when(manager.get(3, 1)).thenReturn(Status.ALIVE);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 2)).thenReturn(Status.ALIVE);
        when(manager.get(2, 3)).thenReturn(Status.DEAD);
        when(manager.get(3, 3)).thenReturn(Status.DEAD);
        cell.LeftCellCount(manager);

        assertEquals(3, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreDeadForLeftCell() {

        when(manager.get(3, 1)).thenReturn(Status.DEAD);
        when(manager.get(2, 1)).thenReturn(Status.DEAD);
        when(manager.get(3, 2)).thenReturn(Status.DEAD);
        when(manager.get(2, 3)).thenReturn(Status.DEAD);
        when(manager.get(3, 3)).thenReturn(Status.DEAD);
        cell.LeftCellCount(manager);

        assertEquals(0, cell.getNumberOfAliveCell());

    }

    @Test
    void checkAliveCellWhenAllAreAliveForLeftDownCell() {

        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 2)).thenReturn(Status.ALIVE);

        cell.LeftDownCellCount(manager);

        assertEquals(3,cell.getNumberOfAliveCell() );

    }

    @Test
    void checkAliveCellWhenHalfCellsIsAliveForLeftDownCell() {
        cell = new Cell(2, 2, 3, 3);
        when(manager.get(2, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 1)).thenReturn(Status.ALIVE);
        when(manager.get(3, 2)).thenReturn(Status.DEAD);
        cell.LeftDownCellCount(manager);

        assertEquals(2,cell.getNumberOfAliveCell() );

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
