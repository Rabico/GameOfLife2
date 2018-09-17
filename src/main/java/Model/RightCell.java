package Model;


import Contract.Cell;
import Contract.Status;

class RightCell extends Cell {


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