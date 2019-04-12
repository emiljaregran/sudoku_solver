import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Main
{
    private Square[][] squares = new Square[9][9];

    private Main()
    {
        JFrame frame = new JFrame("Sudoku Solver - Emil Jaregran 2019");
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EtchedBorder()));
        JPanel buttonPanel = new JPanel();
        JPanel gridPanel = new JPanel(new GridLayout(3,3));
        JPanel[] bigSquares = new JPanel[9];

        JLabel label = new JLabel("Speed (ms): ");
        JTextField textField = new JTextField("500");
        textField.setColumns(4);
        JButton button = new JButton("Solve");

        buttonPanel.add(label);
        buttonPanel.add(textField);
        buttonPanel.add(button);

        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        for (int i = 0; i < 9; i++)
        {
            bigSquares[i] = new JPanel(new GridLayout(3, 3));
            bigSquares[i].setBorder(BorderFactory.createLineBorder(Color.black));
            gridPanel.add(bigSquares[i]);
        }

        for (int row = 0; row < 9; row++)
        {
            for (int col = 0; col < 9; col++)
            {
                int square;

                if (row < 3)
                {
                    square = col / 3;
                }
                else if (row < 6)
                {
                    square = (col / 3) + 3;
                }
                else
                {
                    square = (col / 3) + 6;
                }

                squares[row][col] = new Square(row, col, "0");
                bigSquares[square].add(squares[row][col]);
            }
        }

        squares[7][5].setColor(Color.green);


        frame.add(mainPanel);
        frame.setSize(499, 496);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        //Board board = new Board();
        //Solver solver = new Solver(board);
        new Main();
    }
}
