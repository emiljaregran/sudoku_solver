import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel
{
    Grid(int width, int height)
    {
        super(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        for (int row = 0; row < height; row++)
        {
            for (int col = 0; col < width; col++)
            {
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.weighty = 1.0;
                gridBagConstraints.fill = GridBagConstraints.BOTH;
                gridBagConstraints.gridy = row;
                gridBagConstraints.gridx = col;
               // add(new Square(row, col), gridBagConstraints);
            }
        }

        setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
