package Model;

import Contract.Status;

public class Manager {
    Status[][] status;
    private int width=0;
    private int height = 0;

    Manager(int width, int height){
        this.width=width;
        this.height=height;
        status = new Status[width][height];
        for(int i=0; i<width;i++){
            for(int j = 0; j<height; j++){
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
        for(int i =0; i<width*2;i++) {
            java.lang.System.out.print("-");
        }
        java.lang.System.out.println(" ");

        for(int j = 0; j<height; j++){
            java.lang.System.out.print("|");
            for(int i =0;i<width; i++){
                if(status[i][j]==Status.DEAD){
                    java.lang.System.out.print("O"+" ");
                }else{
                    java.lang.System.out.print("X"+" ");
                }

            }
            java.lang.System.out.println("|");
        }

        java.lang.System.out.print(" ");
        for(int i =0; i<width*2;i++) {
            java.lang.System.out.print("-");
        }
        java.lang.System.out.print(" ");
        java.lang.System.out.println(" ");
    }

}
