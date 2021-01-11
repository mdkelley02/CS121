import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LiteBriteBoardPanel extends JPanel
{
    private LitePegButton[][] pegs;

    public LiteBriteBoardPanel(ActionListener listener, int width, int height)
    {
        this.pegs = new LitePegButton[height][width];

        this.setLayout(new GridLayout(height, width));
        this.setPreferredSize(new Dimension(600,400));

        for(int row=0; row<this.pegs.length; row++)
        {
            for(int col=0; col<this.pegs[row].length; col++)
            {
                this.pegs[row][col] = new LitePegButton();
                this.pegs[row][col].addActionListener(listener);
                this.add(this.pegs[row][col]);
            }
        }

    }
    public void reset()
    {
        for(int row=0; row<this.pegs.length; row++)
        {
            for(int col=0; col<this.pegs[row].length; col++)
            {
                this.pegs[row][col].resetColor();
            }
        }
    }
}
