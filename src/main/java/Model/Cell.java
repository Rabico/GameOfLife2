package Model;

import Contract.CellType;
import Contract.Status;



public class Cell {
    Status status; // Cell condition
    protected final int cellWidth; // Width of cell
    protected final int cellHeight; // Height of cell
    protected boolean hasItChanged = false; // parameter about cell condition change
    protected int numberOfAliveCell = 0; // Number of alive neighbors
    protected final CellType cellType;

    public Cell(int width, int height, int maxWidth, int maxHeight) {
        cellHeight = height;
        cellWidth = width;

        if (cellWidth == 0) {
            if (cellHeight == 0) {
                cellType = CellType.LEFTTOP;
            } else if (cellHeight == maxHeight - 1) {
                cellType = CellType.LEFTDOWN;
            } else {
                cellType = CellType.LEFT;
            }
        } else if (cellWidth == maxWidth - 1) {
            if (cellHeight == 0) {
                cellType = CellType.RIGHTTOP;
            } else if (cellHeight == maxHeight - 1) {
                cellType = CellType.RIGHTDOWN;
            } else {
                cellType = CellType.RIGHT;
            }
        } else {
            if (cellHeight == 0) {
                cellType = CellType.TOP;
            } else if (cellHeight == maxHeight - 1) {
                cellType = CellType.DOWN;
            } else {
                cellType = CellType.CENTER;
            }
        }


    }


    // Method to find number of alive neighbors
    public void checkAliveCell(Manager manager) {
        if (cellType == CellType.RIGHT) {
            RightCellCount(manager);
        }  if (cellType == CellType.LEFT) {
            LeftCellCount(manager);
        }  if (cellType == CellType.TOP) {
            TopCellCount(manager);
        } if (cellType == CellType.DOWN) {
            DownCellCount(manager);
        } if (cellType == CellType.RIGHTTOP) {
            RightTopCellCount(manager);
        } if (cellType == CellType.RIGHTDOWN) {
            RightDownCellCount(manager);
        } if (cellType == CellType.LEFTTOP) {
            LeftTopCellCount(manager);
        } if (cellType == CellType.LEFTDOWN) {
            LeftDownCellCount(manager);
        } if (cellType == CellType.CENTER) {
            CenterCellCount(manager);
        }

    }

    public int getNumberOfAliveCell() {
        return numberOfAliveCell;
    }

    //Method for changing status
    public void checkStatus() {


        if (status == Status.ALIVE) {
            if (numberOfAliveCell == 2 || numberOfAliveCell == 3) {
            } else {
                status = Status.DEAD;
                hasItChanged = true;
            }

        } else {
            if (numberOfAliveCell == 3) {
                status = Status.ALIVE;
                hasItChanged = true;
            } else {
            }
        }

        numberOfAliveCell = 0;

    }

    // Method for sending information about status change
    public void sendStatus(Manager manager) {
        if (hasItChanged) {
            manager.setStatus(status, cellWidth, cellHeight);
            hasItChanged = false;
        }
    }


    public void setStatus(Status status) {
        this.status = status;
    }


    protected void RightCellCount(Manager manager) {
        if (manager.get(cellWidth, cellHeight + 1) == Status.ALIVE) {
            numberOfAliveCell++;
        }

        if (manager.get(cellWidth - 1, cellHeight) == Status.ALIVE) {
            numberOfAliveCell++;
        }

        if (manager.get(cellWidth - 1, cellHeight + 1) == Status.ALIVE) {
            numberOfAliveCell++;
        }

        if (manager.get(cellWidth - 1, cellHeight - 1) == Status.ALIVE) {
            numberOfAliveCell++;
        }

        if (manager.get(cellWidth, cellHeight - 1) == Status.ALIVE) {
            numberOfAliveCell++;
        }
    }

    protected void LeftCellCount(Manager manager) {


        if (manager.get(cellWidth, cellHeight + 1) == Status.ALIVE) {
            numberOfAliveCell++;
        }

        if (manager.get(cellWidth + 1, cellHeight) == Status.ALIVE) {
            numberOfAliveCell++;
        }

        if (manager.get(cellWidth + 1, cellHeight + 1) == Status.ALIVE) {
            numberOfAliveCell++;
        }

        if (manager.get(cellWidth + 1, cellHeight - 1) == Status.ALIVE) {
            numberOfAliveCell++;
        }

        if (manager.get(cellWidth, cellHeight - 1) == Status.ALIVE) {
            numberOfAliveCell++;
        }
    }

    protected void TopCellCount(Manager manager) {


            if(manager.get(cellWidth +1, cellHeight) == Status.ALIVE){
                numberOfAliveCell++;
            }

            if(manager.get(cellWidth -1, cellHeight +1) == Status.ALIVE){
                numberOfAliveCell++;
            }

            if(manager.get(cellWidth, cellHeight +1) == Status.ALIVE){
                numberOfAliveCell++;
            }

            if(manager.get(cellWidth +1, cellHeight +1) == Status.ALIVE){
                numberOfAliveCell++;
            }

            if(manager.get(cellWidth -1, cellHeight) == Status.ALIVE){
                numberOfAliveCell++;
            }


        }

    protected void DownCellCount(Manager manager) {


            if(manager.get(cellWidth +1, cellHeight) == Status.ALIVE){
                numberOfAliveCell++;
            }

            if(manager.get(cellWidth -1, cellHeight -1) == Status.ALIVE){
                numberOfAliveCell++;
            }

            if(manager.get(cellWidth, cellHeight -1) == Status.ALIVE){
                numberOfAliveCell++;
            }

            if(manager.get(cellWidth +1, cellHeight -1) == Status.ALIVE){
                numberOfAliveCell++;
            }

            if(manager.get(cellWidth -1, cellHeight) == Status.ALIVE){
                numberOfAliveCell++;
            }


        }

    protected void LeftDownCellCount(Manager manager) {


            if(manager.get(cellWidth, cellHeight -1) == Status.ALIVE){
                numberOfAliveCell++;
            }

            if(manager.get(cellWidth +1, cellHeight -1) == Status.ALIVE){
                numberOfAliveCell++;
            }

            if(manager.get(cellWidth +1, cellHeight) == Status.ALIVE){
                numberOfAliveCell++;
            }

        }

    protected void RightDownCellCount(Manager manager) {


            if(manager.get(cellWidth, cellHeight -1) == Status.ALIVE){
                numberOfAliveCell++;
            }

            if(manager.get(cellWidth -1, cellHeight -1) == Status.ALIVE){
                numberOfAliveCell++;
            }

            if(manager.get(cellWidth -1, cellHeight) == Status.ALIVE){
                numberOfAliveCell++;
            }

        }

    protected void RightTopCellCount(Manager manager) {


        if(manager.get(cellWidth, cellHeight +1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(cellWidth -1, cellHeight +1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(cellWidth -1, cellHeight) == Status.ALIVE){
            numberOfAliveCell++;
        }
    }

    protected void LeftTopCellCount(Manager manager) {


        if(manager.get(cellWidth, cellHeight +1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(cellWidth +1, cellHeight +1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(cellWidth +1, cellHeight) == Status.ALIVE){
            numberOfAliveCell++;
        }

    }

    protected void CenterCellCount(Manager manager) {


        if(manager.get(cellWidth -1, cellHeight -1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(cellWidth, cellHeight -1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(cellWidth +1, cellHeight -1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(cellWidth +1, cellHeight) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(cellWidth +1, cellHeight +1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(cellWidth, cellHeight +1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(cellWidth -1, cellHeight +1) == Status.ALIVE){
            numberOfAliveCell++;
        }

        if(manager.get(cellWidth -1, cellHeight) == Status.ALIVE){
            numberOfAliveCell++;
        }
    }


    }

