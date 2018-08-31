package Model;


import Contract.Cell;
import Contract.Status;

class RightCell extends Cell {

    private int width;
    private int height;
    private Status status;
    private int numberOfAliveCell = 0;
    public RightCell(int width, int height) {
        super(width, height);
    }

     @Override
     public void checkAliveCell(Manager manager) {


        if(manager.get(width, height+1) == Status.ALIVE){
            numberOfAliveCell++;
        }

         if(manager.get(width-1, height) == Status.ALIVE){
             numberOfAliveCell++;
         }

         if(manager.get(width-1, height+1) == Status.ALIVE){
             numberOfAliveCell++;
         }

         if(manager.get(width-1, height-1) == Status.ALIVE){
             numberOfAliveCell++;
         }

         if(manager.get(width, height-1) == Status.ALIVE){
             numberOfAliveCell++;
         }


     }
 }

class LeftCell extends Cell {

    private int width;
    private int height;
    private Status status;
    private int numberOfAliveCell = 0;
    public LeftCell(int width, int height) {
        super(width, height);
    }

    @Override
    public void checkAliveCell(Manager manager) {


        if(manager.get(width, height+1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width+1, height) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width+1, height+1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width+1, height-1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width, height-1) == Status.ALIVE){
            numberOfAliveCell++;
        }


    }
}

class TopCell extends Cell {

    private int width;
    private int height;
    private Status status;
    private int numberOfAliveCell = 0;
    public TopCell(int width, int height) {
        super(width, height);
    }

    @Override
    public void checkAliveCell(Manager manager) {


        if(manager.get(width+1, height) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width-1, height+1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width, height+1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width+1, height+1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width-1, height) == Status.ALIVE){
            numberOfAliveCell++;
        }


    }
}

class DownCell extends Cell {

    private int width;
    private int height;
    private Status status;
    private int numberOfAliveCell = 0;
    public DownCell(int width, int height) {
        super(width, height);
    }

    @Override
    public void checkAliveCell(Manager manager) {


        if(manager.get(width+1, height) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width-1, height-1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width, height-1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width+1, height-1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width-1, height) == Status.ALIVE){
            numberOfAliveCell++;
        }


    }
}

class LeftDownCell extends Cell {

    private int width;
    private int height;
    private Status status;
    private int numberOfAliveCell = 0;
    public LeftDownCell(int width, int height) {
        super(width, height);
    }

    @Override
    public void checkAliveCell(Manager manager) {


        if(manager.get(width, height-1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width+1, height-1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width+1, height) == Status.ALIVE){
            numberOfAliveCell++;
        }




    }
}

class RightDownCell extends Cell {

    private int width;
    private int height;
    private Status status;
    private int numberOfAliveCell = 0;
    public RightDownCell(int width, int height) {
        super(width, height);
    }

    @Override
    public void checkAliveCell(Manager manager) {


        if(manager.get(width, height-1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width-1, height-1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width-1, height) == Status.ALIVE){
            numberOfAliveCell++;
        }




    }
}

class RightTopCell extends Cell {

    private int width;
    private int height;
    private Status status;
    private int numberOfAliveCell = 0;
    public RightTopCell(int width, int height) {
        super(width, height);
    }

    @Override
    public void checkAliveCell(Manager manager) {


        if(manager.get(width, height+1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width-1, height+1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width-1, height) == Status.ALIVE){
            numberOfAliveCell++;
        }




    }
}

class LeftTopCell extends Cell {

    private int width;
    private int height;
    private Status status;
    private int numberOfAliveCell = 0;
    public LeftTopCell(int width, int height) {
        super(width, height);
    }

    @Override
    public void checkAliveCell(Manager manager) {


        if(manager.get(width, height+1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width+1, height+1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width+1, height) == Status.ALIVE){
            numberOfAliveCell++;
        }




    }
}

class CenterCell extends Cell {

    private int width;
    private int height;
    private Status status;
    private int numberOfAliveCell = 0;
    public CenterCell(int width, int height) {
        super(width, height);
    }

    @Override
    public void checkAliveCell(Manager manager) {


        if(manager.get(width-1, height-1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width, height-1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width+1, height-1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width+1, height) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width+1, height+1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width, height+1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width-1, height+1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(width-1, height) == Status.ALIVE){
            numberOfAliveCell++;
        }


    }
}