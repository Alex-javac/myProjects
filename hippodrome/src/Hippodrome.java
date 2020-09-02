import java.util.*;
import java.io.*;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses=new ArrayList<>();

    public Hippodrome(List horses) {
        this.horses=horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
    public void run() {
        try {
            for (int i =0;i<100;i++) {
                move();
                print();
                Thread.sleep(200);
            }
        }
        catch(InterruptedException e) {
            e.printStackTrace();}

    }
    public void move() {
        List<Horse> result =getHorses() ;
        for (int i =0;i<result.size();i++) {
            result.get(i).move();
        }
    }
    public void print() {
        List<Horse> result =getHorses() ;
        for (int i =0;i<result.size();i++) {
            result.get(i).print();
        }
        for (int i=0;i<10 ;i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        List<Horse> result =getHorses() ;
        double dis=0;
        int winner=0;

        for (int i =0;i<result.size();i++) {
            if(dis<result.get(i).getDistance()){
                dis=result.get(i).getDistance() ;
                winner=i;
            }
        }
        return result.get(winner);
    }
    public void printWinner() {
        System.out.println("Winner is "+getWinner().getName()+"!" );
    }


    public static void main(String[] args){
        game =new Hippodrome(new ArrayList<>());

        Horse horseOne = new Horse("Вавилон",3,0);
        Horse horseTwo = new Horse("Бальтазар",3,0);
        Horse horseThree = new Horse("Пегас",3,0);

        game.getHorses().add(horseOne) ;
        game.getHorses().add(horseTwo);
        game.getHorses().add(horseThree);

        game.run();
        game.printWinner();
    }

}
