package Model;

import Contract.Status;



public class Manager {
    Status[][] status;
    private int mangerWidth;
    private int managerHeight;

    Manager(int width, int height){
        mangerWidth =width;
        managerHeight =height;
        status = new Status[mangerWidth][managerHeight];
        for(int i = 0; i< mangerWidth; i++){
            for(int j = 0; j< managerHeight; j++){
                status[i][j] = Status.DEAD;
            }
        }
    }

    Status get(int width, int height){
        return status[width][height];
    }

    public void setStatus(Status status, int width, int height){
      this.status[width][height]= status;
    }

    public void print(){
        java.lang.System.out.print(" ");
        for(int i = 0; i< mangerWidth *2; i++) {
            java.lang.System.out.print("-");
        }
        java.lang.System.out.println(" ");

        for(int j = 0; j< managerHeight; j++){
            java.lang.System.out.print("|");
            for(int i = 0; i< mangerWidth; i++){
                if(status[i][j]==Status.DEAD){
                    java.lang.System.out.print("O"+" ");
                }else{
                    java.lang.System.out.print("X"+" ");
                }

            }
            java.lang.System.out.println("|");
        }

        java.lang.System.out.print(" ");
        for(int i = 0; i< mangerWidth *2; i++) {
            java.lang.System.out.print("-");
        }
        java.lang.System.out.print(" ");
        java.lang.System.out.println(" ");
    }

}
