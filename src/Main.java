import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener
{
    private final int ROW = 0;
    private final int COL = 1;
    private final int NORMAL_MODE = 0;
    private final int EDIT_MODE = 1;
    private int currentMode = NORMAL_MODE;

    private final Color colorEdit = Color.decode("#4286F4");

    private Square[][] squares = new Square[9][9];
    private int[] editSquare = new int[] {0, 0};
    private JButton editButton = new JButton("Edit");
    private JButton clearButton = new JButton("Clear");
    private JButton solveButton = new JButton("Solve");

    private Main()
    {
        JFrame frame = new JFrame("Sudoku Solver - Emil Jaregran 2019");
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EtchedBorder()));
        JPanel buttonPanel = new JPanel();
        JPanel gridPanel = new JPanel(new GridLayout(3,3));
        JPanel[] bigSquares = new JPanel[9];

        JLabel speedLabel = new JLabel("Speed (ms): ");
        JLabel invisibleLabel1 = new JLabel("       ");
        JLabel invisibleLabel2 = new JLabel("       ");
        JTextField textField = new JTextField("500");

        editButton.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent keyEvent)
            {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent)
            {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent)
            {
                if (currentMode == EDIT_MODE)
                {
                    editBoard(keyEvent);
                }
            }
        });

        editButton.addActionListener(this);
        clearButton.addActionListener(this);
        solveButton.addActionListener(this);
        textField.setColumns(4);

        buttonPanel.add(editButton);
        buttonPanel.add(invisibleLabel1);
        buttonPanel.add(clearButton);
        buttonPanel.add(invisibleLabel2);
        buttonPanel.add(speedLabel);
        buttonPanel.add(textField);
        buttonPanel.add(solveButton);

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

                squares[row][col] = new Square(row, col);
                bigSquares[square].add(squares[row][col]);
            }
        }

        frame.add(mainPanel);
        frame.setSize(499, 496);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == editButton)
        {
            if (currentMode == NORMAL_MODE)
            {
                currentMode = EDIT_MODE;
                squares[editSquare[ROW]][editSquare[COL]].setColor(colorEdit, 3);
                editButton.setText("Done");
            }
            else if (currentMode == EDIT_MODE)
            {
                currentMode = NORMAL_MODE;
                squares[editSquare[ROW]][editSquare[COL]].setColor(Color.black, 1);
                editButton.setText("Edit");
            }
        }
        else if (e.getSource() == clearButton)
        {
            if (currentMode == NORMAL_MODE)
            {
                clearAllSquares();
            }
        }
        else if (e.getSource() == solveButton)
        {
            System.out.println("Solve");
        }
    }

    private void clearAllSquares()
    {
        int choice = JOptionPane.showConfirmDialog(null,
                "Are you sure that you want to clear the board?",
                "Sudoku Solver", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION)
        {
            for (int row = 0; row < squares.length; row++)
            {
                for (int col = 0; col < squares[0].length; col++)
                {
                    squares[row][col].setNumber(0);
                }
            }
        }
    }

    private void editBoard(KeyEvent keyEvent)
    {
        int key = keyEvent.getKeyCode();

        if (key == KeyEvent.VK_LEFT)
        {
            if (editSquare[COL] > 0)
            {
                squares[editSquare[ROW]][editSquare[COL]--].setColor(Color.black, 1);
                squares[editSquare[ROW]][editSquare[COL]].setColor(colorEdit, 3);
            }
        }
        else if (key == KeyEvent.VK_RIGHT)
        {
            if (editSquare[COL] < 8)
            {
                squares[editSquare[ROW]][editSquare[COL]++].setColor(Color.black, 1);
                squares[editSquare[ROW]][editSquare[COL]].setColor(colorEdit, 3);
            }
        }
        else if (key == KeyEvent.VK_DOWN)
        {
            if (editSquare[ROW] < 8)
            {
                squares[editSquare[ROW]++][editSquare[COL]].setColor(Color.black, 1);
                squares[editSquare[ROW]][editSquare[COL]].setColor(colorEdit, 3);
            }
        }
        else if (key == KeyEvent.VK_UP)
        {
            if (editSquare[ROW] > 0)
            {
                squares[editSquare[ROW]--][editSquare[COL]].setColor(Color.black, 1);
                squares[editSquare[ROW]][editSquare[COL]].setColor(colorEdit, 3);
            }
        }
    }

    public static void main(String[] args)
    {
        //Board board = new Board();
        //Solver solver = new Solver(board);
        new Main();
    }
}
