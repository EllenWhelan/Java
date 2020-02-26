package ConnectFour;

public class C4RandomAIPlayer extends ConnectPlayer {

	public C4RandomAIPlayer(int playerPiece) {
		playerNumber=playerPiece;
	}
	public void playPiece(Connect42DArray grid, int column) {
		grid.dropPiece(this,column);
	}

}
