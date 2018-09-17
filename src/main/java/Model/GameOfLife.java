package Model;

import Contract.Status;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameOfLife {
    public static void main(String[] args){

        int width =10;
        int height = 10;
        int heightToBegin=0;
        int widthToBegin = 0;
        Random rand = new Random();
        System system = new System(width,height);
        Manager manager = new Manager(width,height);

        for(int i=0; i<50; i++){
            heightToBegin = rand.nextInt(height);
            widthToBegin = rand.nextInt(width);
            manager.setStatus(Status.ALIVE,widthToBegin,heightToBegin);
            system.setStatusToBegin(Status.ALIVE, widthToBegin,heightToBegin);
        }

        for (int j =0; j<100; j++){
            manager.print();
            system.checkAliveCell(manager);
            system.checkStatus();
            system.sendStatus(manager);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
