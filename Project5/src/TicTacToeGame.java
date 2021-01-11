import java.awt.*;

public class TicTacToeGame implements TicTacToe
//    @author Matthew Kelley
//    class that interfaces with the GUI for all of the logic
//    of the tic tac toe game.
{
    private BoardChoice[][] grid;
    private Point[] moves;
    private int numMoves;
    private GameState state;
    private BoardChoice lastPlayer;

    public TicTacToeGame()
    {
        this.grid = new BoardChoice[3][3];
        this.moves = new Point[9];
        this.numMoves = 0;
        this.newGame();
    }

    @Override
    public void newGame()
    {
        this.state = GameState.IN_PROGRESS;
        for(int row=0; row < grid.length; row++)
        {
            for(int col=0; col<grid[row].length; col++)
            {
                grid[row][col] = BoardChoice.OPEN;
            }
        }
    }

    @Override
    public boolean choose(BoardChoice player, int row, int col) {
        if(gameOver() || grid[row][col] != BoardChoice.OPEN || player == lastPlayer)
            return false;
        grid [row][col] = player;

        moves[numMoves] = new Point(row, col);
        numMoves++;

        lastPlayer = player;
        gameOver();
        return true;
    }

    @Override
    public boolean gameOver() {
        for(int row=0; row < grid.length; row++)
        {
            for(int col = 0; col<grid[row].length; col++)
            {
                if(grid[row][0] != BoardChoice.OPEN && grid[row][0] == grid[row][1] && grid[row][1] == grid[row][2] )
                {
                    this.state = grid[row][0] == BoardChoice.O ? GameState.O_WON : GameState.X_WON;
                    return true;
                }
                if (grid[0][col] != BoardChoice.OPEN && grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col]){
                    this.state = grid[0][col] == BoardChoice.O ? GameState.O_WON : GameState.X_WON;
                    return true;
                }
            }
        }
        if ( grid[0][0] != BoardChoice.OPEN && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] )
        {
            this.state = grid[0][0] == BoardChoice.O ? GameState.O_WON : GameState.X_WON;
            return true;
        }
        if ( grid[0][2] != BoardChoice.OPEN && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] )
        {
            this.state = grid[0][2] == BoardChoice.O ? GameState.O_WON : GameState.X_WON;
            return true;
        }
        if(this.numMoves == 9){
            this.state = GameState.TIE;
            return true;
        }
        return false;
    }

    @Override
    public GameState getGameState() {
        return this.state;
    }

    @Override
    public BoardChoice[][] getGameGrid() {
        BoardChoice[][] tgrid = new BoardChoice[3][3];
        for (int row=0; row< grid.length; row++)
        {
            for(int col=0; col< grid.length; col++)
            {
                tgrid[row][col] = grid[row][col];
            }
        }
        return tgrid;
    }

    @Override
    public Point[] getMoves() {
        Point[] tmoves = new Point[numMoves];
        for(int point=0; point<tmoves.length; point++)
        {
            tmoves[point] = moves[point];
        }
        return tmoves;
    }
}
