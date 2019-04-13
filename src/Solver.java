import javax.swing.*;

public class Solver extends Thread
{
    private final Main main;
    private final Board board;
    private final Square[][] squares;
    private final int delay;
    private boolean stopSolve;

    Solver(Main main, Board board, Square[][] squares, int delay)
    {
        this.main = main;
        this.board = board;
        this.squares = squares;
        this.delay = delay;
        this.stopSolve = false;
    }

    boolean solve(int delay)
    {
        final int ROW = 0;
        final int COL = 1;

        if (board.getFirstEmptyPosition() == null || stopSolve)
        {
            return true;
        }

        int[] emptyPosition = board.getFirstEmptyPosition();
        for (int number = 1; number < 10; number++)
        {
            // Visually showing progress in real time on the board
            squares[emptyPosition[ROW]][emptyPosition[COL]].setNumber(number);
            try
            {
                Thread.sleep(delay);
            }
            catch (InterruptedException e)
            {
                stopSolve = true;
            }

            if (board.isValidPosition(emptyPosition[ROW], emptyPosition[COL], number))
            {
                board.setPosition(emptyPosition[ROW], emptyPosition[COL], number);
                if (solve(delay))
                {
                    return true;
                }
            }
        }

        squares[emptyPosition[ROW]][emptyPosition[COL]].setNumber(0);
        board.setPosition(emptyPosition[ROW], emptyPosition[COL], 0);
        return false;
    }

    @Override
    public void run()
    {
        main.solvingResult(solve(delay));
    }
}
