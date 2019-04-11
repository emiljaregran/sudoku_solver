public class Solver
{
    private final Board board;

    Solver(Board board)
    {
        this.board = board;
    }

    boolean solve()
    {
        final int ROW = 0;
        final int COL = 1;

        if (board.getFirstEmptyPosition() == null)
        {
            return true;
        }

        int[] emptyPosition = board.getFirstEmptyPosition();
        for (int number = 1; number < 10; number++)
        {
            if (board.isValidPosition(emptyPosition[ROW], emptyPosition[COL], number))
            {
                board.setPosition(emptyPosition[ROW], emptyPosition[COL], number);
                if (solve())
                {
                    return true;
                }
            }
        }

        board.setPosition(emptyPosition[ROW], emptyPosition[COL], 0);
        return false;
    }
}
