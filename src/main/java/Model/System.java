package Model;

import Contract.CellType;
import Contract.Status;



public class System {
    private int systemHeight;
    private int systemWidth;
    protected Cell[][] system;

    System(int width, int height){
        systemHeight = height;
        systemWidth = width;
        system = new Cell[systemWidth][systemHeight];
        CellType type;
        for (int i = 0; i< systemWidth; i++){
            for (int j = 0; j< systemHeight; j++) {

                system[i][j]=new Cell(i,j, systemWidth, systemHeight);
                system[i][j].setStatus(Status.DEAD);
            }
        }
    }

    // Method to find number of alive neighbors for all cells
public void checkAliveCell(Manager manager){
        for(int i = 0; i< systemWidth; i++){
            for (int j = 0; j< systemHeight; j++){
                system[i][j].checkAliveCell(manager);
            }
        }
}
    //Method for changing status of all cells
    public void checkStatus(){
        for(int i = 0; i< systemWidth; i++){
            for (int j = 0; j< systemHeight; j++){
                system[i][j].checkStatus();
            }
        }
    }

    public void sendStatus(Manager manager){
        for(int i = 0; i< systemWidth; i++){
            for (int j = 0; j< systemHeight; j++){
                system[i][j].sendStatus(manager);
            }
        }
    }

    public void setStatusToBegin(Status status, int width, int height){
        system[width][height].setStatus(status);
    }

}
