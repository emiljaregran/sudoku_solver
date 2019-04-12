import javax.swing.*;
import java.awt.*;

public class Square extends JLabel
{
    private int number;
    private int row;
    private int col;

    Square(int row, int col)
    {
        this.row = row;
        this.col = col;

        setText("7");
        setOpaque(true);
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    int getNumber()
    {
        return number;
    }

    void setNumber(int number)
    {
        if (number == 0)
        {
            setText(" ");
        }
        else
        {
            setText(String.valueOf(number));
        }

        this.number = number;
    }

    void setColor(Color color)
    {
        setBorder(BorderFactory.createLineBorder(color, 3));
    }
}
