package Contract;

import Model.Manager;

public abstract class Cell {
    Status status; // Cell condition
    protected int width; // Width of cell
    protected int height; // Height of cell
    protected boolean hasItChanged = false; // parameter about cell condition change
    protected int numberOfAliveCell = 0; // Number of alive neighbors

    public Cell(int width, int height){
        this.height = height;
        this.width = width;
    }


    // Method to find number of alive neighbors
    public void checkAliveCell(Manager manager){}

    public int getNumberOfAliveCell(){
        return numberOfAliveCell;
    }

    //Method for changing status
    public void checkStatus(){



        if(status==Status.ALIVE){
        if(numberOfAliveCell==2 || numberOfAliveCell==3){
        }else{
            status=Status.DEAD;
        }

    }else{
        if(numberOfAliveCell==3){
            status=Status.ALIVE;
        }else{}
    }

    numberOfAliveCell = 0;

    }

    // Method for sending information about status change
    public void sendStatus(Manager manager){
        if(hasItChanged){
            manager.setStatus(status,width,height);
        hasItChanged = false;
        }
    }



    public void setStatus(Status status){
        this.status = status;
    }

}

