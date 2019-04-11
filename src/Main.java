public class Main
{
    public static void main(String[] args)
    {
        Board board = new Board();
        Solver solver = new Solver(board);

        board.printBoard();
        System.out.println();

        solver.solve();

        System.out.println();
        board.printBoard();
    }
}
