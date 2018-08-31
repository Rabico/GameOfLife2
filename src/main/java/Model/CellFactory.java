package Model;

import Contract.Cell;
import Contract.CellFactoryContract;
import Contract.CellType;

public class CellFactory implements CellFactoryContract {
    private static CellFactory ourInstance = new CellFactory();

    public static CellFactory getInstance() {
        return ourInstance;
    }

    private CellFactory() {
    }

    public Cell createCell(CellType type, int width, int height) {

        Cell cell = null;
        switch (type) {
            case RIGHT:{
                cell = new RightCell(width, height);
            }
            case LEFT:{
                cell = new LeftCell(width, height);
            }
            case TOP:{
                cell = new TopCell(width, height);
            }
            case DOWN:{
                cell = new DownCell(width, height);
            }

            case RIGHTDOWN:{
                cell = new RightDownCell(width, height);
            }

            case RIGHTTOP:{
                cell = new RightTopCell(width, height);
            }

            case LEFTDOWN:{
                cell = new LeftDownCell(width, height);
            }

            case LEFTTOP:{
                cell = new LeftTopCell(width, height);
            }

            case CENTER:{
                cell = new CenterCell(width, height);
            }



        }
        return cell;
    }
}
