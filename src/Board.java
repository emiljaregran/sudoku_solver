public class Board
{
    private final int[][] board;

    Board ()
    {
        this.board = new int[][] {{0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0}};
    }

    Board(int[][] board)
    {
        this.board = board;
    }

    void printBoard()
    {
        for (int row = 0; row < board.length; row++)
        {
            if (row % 3 == 0 && row != 0)
            {
                System.out.println("-------------------------------");
            }
            for (int col = 0; col < board[0].length; col++)
            {
                if (col % 3 == 0)
                {
                    System.out.print("|");
                }
                System.out.print(" " + board[row][col] + " ");
            }
            System.out.println("|");
        }
    }

    int[] getFirstEmptyPosition()
    {
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                if (board[row][col] == 0)
                {
                    return new int[] {row, col};
                }
            }
        }

        return null;
    }

    int[][] getBoard()
    {
        return board;
    }

    void resetBoard()
    {
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                board[row][col] = 0;
            }
        }
    }

    void setPosition(int row, int col, int number)
    {
        board[row][col] = number;
    }

    private boolean isValidRow(int row, int number)
    {
        for (int currentCol = 0; currentCol < board[0].length; currentCol++)
        {
            if (board[row][currentCol] == number)
            {
                return false;
            }
        }

        return true;
    }

    private boolean isValidColumn(int col, int number)
    {
        for (int currentRow = 0; currentRow < board.length; currentRow++)
        {
            if (board[currentRow][col] == number)
            {
                return false;
            }
        }

        return true;
    }

    private boolean isValidSquare(int row, int col, int number)
    {
        int startRow = (row / 3) * 3;
        int endRow = startRow + 3;

        int startCol = (col / 3) * 3;
        int endCol = startCol + 3;

        for (int currentRow = startRow; currentRow < endRow; currentRow++)
        {
            for (int currentCol = startCol; currentCol < endCol; currentCol++)
            {
                if (board[currentRow][currentCol] == number)
                {
                    return false;
                }
            }
        }

        return true;
    }

    boolean isValidPosition(int row, int col, int number)
    {
        return isValidRow(row, number) && isValidColumn(col, number) && isValidSquare(row, col, number);
    }
}
