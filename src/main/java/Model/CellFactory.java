package Model;

import Contract.Cell;
import Contract.CellFactoryContract;
import Contract.CellType;

// Singleton factory to create different type of Cells

public class CellFactory implements CellFactoryContract {
    private static CellFactory ourInstance = new CellFactory();

    public static CellFactory getInstance() {
        return ourInstance;
    }

    private CellFactory() {
    }

    public Cell createCell(CellType type, int width, int height) {

        Cell cell;
        switch (type) {
            case RIGHT:
                cell = new RightCell(width, height);
                break;
            case LEFT:
                cell = new LeftCell(width, height);
                break;
            case TOP:
                cell = new TopCell(width, height);
            break;
            case DOWN:
                cell = new DownCell(width, height);
            break;

            case RIGHTDOWN:
                cell = new RightDownCell(width, height);
                break;

            case RIGHTTOP:
                cell = new RightTopCell(width, height);
                break;

            case LEFTDOWN:
                cell = new LeftDownCell(width, height);
            break;

            case LEFTTOP:
                cell = new LeftTopCell(width, height);
                break;

            case CENTER:
                cell = new CenterCell(width, height);
                break;

            default: cell = null;
                break;


        }
        return cell;
    }
}
