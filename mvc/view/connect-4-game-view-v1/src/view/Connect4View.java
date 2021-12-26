package view;

import game.Connect4;
import view.constant.BoardDimension;
import game.GoalStatus;
import view.constant.BoardElement;
import view.constant.Message;

import java.util.Scanner;

public class Connect4View {

    private final Scanner scanner = new Scanner(System.in);
    private final Connect4 connect4;

    public Connect4View() {
        this.connect4 = new Connect4();
    }

    public void printGame() {
        this.connect4.initGame();
        printStartGame();

        do {
            this.connect4.playTurn(getPlayerOrder());
        } while (this.connect4.isInProgress());

        printEndGame();
    }

    private void printStartGame() {
        print(Message.START_GAME.getValue());
    }

    private Integer getPlayerOrder() {
        print(Message.PLAYER_TURN.getValue().concat(this.connect4.getActivedPlayer()));
        printBoard();
        print(Message.CHOOSE_COLUMN.getValue());

        String input =  scanner.nextLine();
        while (!connect4.isValidTurn(Integer.parseInt(input))){
            print(Message.INPUT_ERROR.getValue());
            input =  scanner.nextLine();
        }

        return Integer.parseInt(input);
    }

    private void printEndGame() {
        printBoard();
        print(Message.END_GAME.getValue());
        print(Message.HEADER_SEPARATOR.getValue());
        print(Message.RESULT_GAME.getValue().concat(this.connect4.getGoal().toString()));

        if(GoalStatus.WIN.equals(this.connect4.getGoal())){
            print(Message.RESULT_WINNER.getValue().concat(this.connect4.getActivedPlayer()));
        }
    }

    private void printBoard() {
        printHeaderBoard();
        for (int i = BoardDimension.ROW.getValue() - 1; i >= 0; i--) {
            for (int j = 0; j <  BoardDimension.COLUMN.getValue(); j++) {
                printSameLine(BoardElement.EDGE_SEPARATOR.getValue());
                printSameLine(this.connect4.getSquare(i, j));
                if (j == (BoardDimension.COLUMN.getValue() - 1)) {
                    print(BoardElement.EDGE_SEPARATOR.getValue());
                }
            }
        }
        print(BoardElement.LINE_SEPARATOR.getValue());
    }

    private void printHeaderBoard() {
        String headerColumn = " ";
        for (int i = 0; i < BoardDimension.COLUMN.getValue(); i++) {
            headerColumn = headerColumn.concat(i + " ");
        }
        print(headerColumn);
        print(BoardElement.LINE_SEPARATOR.getValue());
    }

    private void print(String variable) {
        System.out.println(variable);
    }

    private void printSameLine(String variable) {
        System.out.print(variable);
    }

    public static void main(String[] args) {
        new Connect4View().printGame();
    }
}