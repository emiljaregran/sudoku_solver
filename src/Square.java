import javax.swing.*;
import java.awt.*;

public class Square extends JLabel
{
    private int number;
    private boolean userEntered;
    private int row;
    private int col;

    Square(int row, int col)
    {
        this.row = row;
        this.col = col;

        setText(" ");
        setOpaque(true);
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setFont(new Font(this.getFont().getName(), Font.PLAIN, 17));
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    int getNumber()
    {
        return number;
    }

    boolean getUserEntered()
    {
        return userEntered;
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

    void setNumber(int number, boolean user, boolean bold)
    {
        if (number == 0)
        {
            setText(" ");
            setFont(new Font(this.getFont().getName(), Font.PLAIN, 17));
        }
        else if (bold)
        {
            setText(String.valueOf(number));
            setFont(new Font(this.getFont().getName(), Font.BOLD, 17));
        }
        else
        {
            setText(String.valueOf(number));
            setFont(new Font(this.getFont().getName(), Font.PLAIN, 17));
        }

        this.userEntered = user;
        this.number = number;
    }

    void setColor(Color color, int border)
    {
        setBorder(BorderFactory.createLineBorder(color, border));
    }
}
