package Contract;

import Model.Manager;

public abstract class Cell {
    private Status status;
    private int width;
    private int height;
    private boolean hasItChanged = false;
    private int numberOfAliveCell = 0;
    public void checkAliveCell(Manager manager){}
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
    public void sendStatus(Manager manager){
        if(hasItChanged){
            manager.setStatus(status,width,height);
        hasItChanged = false;
        }
    }
    Status getStatus() {return status;}

    public Cell(int width, int height){
        this.height = height;
        this.width = width;
    }

    public void setStatus(Status status){
        this.status = status;
    }

}

