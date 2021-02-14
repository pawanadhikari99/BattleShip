import javax.swing.*;
import java.util.Random;

class test {

    static int rows = 20;
    static int columns = 15;
    static int ships = 5;

    static char[][] board = new char[rows][columns];
    static Random generate = new Random();

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,
                "This program will demonstrate" +
                        "\n the radom initialization of a "
                        + "\n battle ship game board with" +
                        "\n a single shop of " + ships + " unit length \n"
                        + "\n All the user does in click buttons to either  " +
                        "\n see another board or exit the program");

        String[] options = {"Stop Already !", "Show Another Board"};

        int choice;


        do {

            choice = JOptionPane.showOptionDialog(null, createFinalBoard(), "New GameBoard", 1, 1, null,
                    options, options[1]);
        }
        while (choice == 1);
        JOptionPane.showMessageDialog(null, "The program is closing");
    }


    public static String createFinalBoard() {

        int shuffleHorizontalVertical = generate.nextInt(2);

        if (shuffleHorizontalVertical == 0) {
            horizontalShuffle();
            return positionShip();
        } else {
            verticalShuffle();
            return positionShip();

        }

    }


    public static void horizontalShuffle() {
        System.out.println("horizontal");

        int rowShuffler = generate.nextInt(rows);
        int columnShuffler = generate.nextInt((columns / 2) - 1);

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (j == rowShuffler && columnShuffler <= i && i <= (ships + columnShuffler - 1)) {
                    board[i][j] = 'x';
                } else {
                    board[j][i] = '_';
                }
            }
        }
    }

    public static void verticalShuffle() {
        System.out.println("vertical");
        int columnShuffler = generate.nextInt((rows / 2) - 1);
        int rowShuffler = generate.nextInt(columns);
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {

                if (j == rowShuffler && columnShuffler <= i && i <= (ships + columnShuffler - 1)) {
                    board[j][i] = 'x';
                } else {
                    board[j][i] = '_';
                }
            }
        }
    }

    public static String positionShip() {
        String game = "";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                game += board[i][j] + "      ";
            }
            game += "\n";
        }
        return game;
    }
}