/**
  * מחלקת BattleShipGame מציגה את המחלקה הראשית להפעלה של משחק Battleship.
  * הוא מכיל את השיטה הראשית `main()`, אשר מאתחלת את המשחק, יוצרת אובייקטים במשחק ומתחילה את תהליך המשחק הראשי.
  */
import java.util.ArrayList;
import java.util.List;
public class BattleShipGame {
    /**
  * השיטה העיקרית להתחלת המשחק "ספינת קרב".
  * יוצר מופעים של אובייקטים של OceanBattle ו-OceanDisplayConsole כדי לשלוט במשחק ולהציג את מצב מגרש המשחקים.
  * יוצר שני שחקנים ומוסיף אותם לרשימת השחקנים.
  * מציג את המצב ההתחלתי של מגרש המשחקים.
  * כל שחקן מניח את ספינותיו באוקיינוס.
  * מתחיל לולאת משחק בה שחקנים מתחלפים זה בזה עד שכל הספינות של שחקן אחד טובעות.
  * קובע את המנצח ומציג הודעת ניצחון.
  *
  */
    public static void main(String[] args) {
        OceanBattle oceanBattle = new OceanBattle();
        OceanDisplayConsole oceanDisplayConsole = new OceanDisplayConsole(oceanBattle);

        Player player1 = new Player(oceanBattle, 1);
        Player player2 = new Player(oceanBattle, 2);
        List<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        oceanDisplayConsole.displayOcean();
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            player.placeShips();
            oceanDisplayConsole.displayOcean();
        }

        oceanDisplayConsole.displayOcean();

        int currentPlayerIndex = 0;
        while (!oceanBattle.isAllShipsSunk()) {
            Player currentPlayer = players.get(currentPlayerIndex);
            currentPlayer.attack();
            oceanDisplayConsole.displayOcean();
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        Player winner = players.get(currentPlayerIndex);
        System.out.println("Player " + winner + " wins!");
    }
}