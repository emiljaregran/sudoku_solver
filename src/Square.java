import javax.swing.*;
import java.awt.*;

public class Square extends JLabel
{
    private int digit;
    private int row;
    private int col;

    Square(int row, int col, String number)
    {
        this.row = row;
        this.col = col;

        setText(number);
        setOpaque(true);
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setHorizontalAlignment(SwingConstants.CENTER);
        set
    }

    int getDigit()
    {
        return digit;
    }

    void setDigit(int digit)
    {
        this.digit = digit;
    }

    void setColor(Color color)
    {
        setBorder(BorderFactory.createLineBorder(color, 3));
    }
}
