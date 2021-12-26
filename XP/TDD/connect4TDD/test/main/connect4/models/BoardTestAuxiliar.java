package main.connect4.models;

public class BoardTestAuxiliar extends Board {

    public boolean isColumnEmpty(int column) {
        return this.getEmptyCoordinate(column).getRow() == 0;
    }

    @Override
    public Board clone(){
        BoardTestAuxiliar boardCloned = new BoardTestAuxiliar();
        for(int i=0; i<Board.ROWS; i++){
            for(int j=0; j<Board.COLUMNS; j++){
                boardCloned.putToken(j, this.colors[i][j]);
            }
        }
        return boardCloned;
    }
}
