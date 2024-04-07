/**
  * המחלקה המופשטת של OceanGame מציגה את המשחקיות של משחק Battleship.
  */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


abstract class OceanGame {
    protected Ocean ocean;
    protected List<Player> players;
/**
      * מחלקת המעצבים של OceanGame.
      * @param ocean אובייקט המייצג את האוקיינוס.
      * @param players רשימת שחקנים.
      */
    public OceanGame(Ocean ocean, List<Player> players) {
        this.ocean = ocean;
        this.players = players;
    }

    public abstract void play();
}