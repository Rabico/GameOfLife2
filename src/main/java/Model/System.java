package Model;

import Contract.Cell;
import Contract.CellType;
import Contract.Status;

public class System {
    private int height;
    private int width;
    protected Cell[][] system;
    CellFactory cellFactory;
    System(int width, int height){
        this.height = height;
        this.width = width;
        system = new Cell[width][height];
        CellType type;
        cellFactory = CellFactory.getInstance();
        for (int i = 0; i<width; i++){
            for (int j = 0; j<height; j++) {

                if(i==0){
                    if(j==0){
                      type = CellType.LEFTTOP;
                    } else if (j==height-1){
                        type = CellType.LEFTDOWN;
                    } else {
                        type = CellType.LEFT;
                    }
                } else if (i == width-1){
                    if(j==0){
                        type = CellType.RIGHTTOP;
                    } else if (j==height-1){
                        type = CellType.RIGHTDOWN;
                    } else {
                        type = CellType.RIGHT;
                    }
                } else{
                    if(j==0){
                        type = CellType.TOP;
                    } else if (j==height-1){
                        type = CellType.DOWN;
                    } else {
                        type = CellType.CENTER;
                    }
                }
           system[i][j] = cellFactory.createCell(type, i,j);
            }
        }
    }

    // Method to find number of alive neighbors for all cells
public void checkAliveCell(Manager manager){
        for(int i=0; i<width;i++){
            for (int j=0; j<height; j++){
                system[i][j].checkAliveCell(manager);
            }
        }
}
    //Method for changing status of all cells
    public void checkStatus(){
        for(int i=0; i<width;i++){
            for (int j=0; j<height; j++){
                system[i][j].checkStatus();
            }
        }
    }

    public void sendStatus(Manager manager){
        for(int i=0; i<width;i++){
            for (int j=0; j<height; j++){
                system[i][j].sendStatus(manager);
            }
        }
    }

    public void setStatusToBegin(Status status, int width, int height){
        system[width][height].setStatus(status);
    }

}
