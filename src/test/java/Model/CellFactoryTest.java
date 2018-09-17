package Model;

import Contract.CellType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Done

class CellFactoryTest {

    CellFactory cellFactoryTest;


    @BeforeEach
    public void beforeTest() {
         cellFactoryTest = CellFactory.getInstance();
    }

    @Test
    void checkCreateRightCell(){
        assertTrue(cellFactoryTest.createCell(CellType.RIGHT,1,1) instanceof  RightCell);
    }
    @Test
    void checkCreateLeftCell(){
        assertTrue(cellFactoryTest.createCell(CellType.LEFT,1,1) instanceof  LeftCell);
    }
    @Test
    void checkCreateTopCell(){
        assertTrue(cellFactoryTest.createCell(CellType.TOP,1,1) instanceof  TopCell);
    }
    @Test
    void checkCreateDownCell(){
        assertTrue(cellFactoryTest.createCell(CellType.DOWN,1,1) instanceof  DownCell);
    }
    @Test
    void checkCreateCenterCell(){
        assertTrue(cellFactoryTest.createCell(CellType.CENTER,1,1) instanceof  CenterCell);
    }
    @Test
    void checkCreateRightTopCell(){
        assertTrue(cellFactoryTest.createCell(CellType.RIGHTTOP,1,1) instanceof  RightTopCell); }
    @Test
    void checkCreateRightDownCell(){
        assertTrue(cellFactoryTest.createCell(CellType.RIGHTDOWN,1,1) instanceof  RightDownCell); }
    @Test
    void checkCreateLeftTopCell(){
        assertTrue(cellFactoryTest.createCell(CellType.LEFTTOP,1,1) instanceof  LeftTopCell); }
    @Test
    void checkCreateLeftDownCell(){
        assertTrue(cellFactoryTest.createCell(CellType.LEFTDOWN,1,1) instanceof  LeftDownCell); }
}