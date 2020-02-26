package ConnectFour;

public class C4HumanPlayer extends ConnectPlayer {

	public C4HumanPlayer(int playerPiece) {
		playerNumber = playerPiece;
	}

	public void playPiece(Connect42DArray grid, int column) {
		grid.dropPiece(this, column);
	}

}
