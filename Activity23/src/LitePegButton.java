import javax.swing.*;
import java.awt.Color;

public class LitePegButton extends JButton {
    private final Color[] COLORS = {Color.BLACK, Color.YELLOW, Color.RED, Color.BLUE, Color.ORANGE};
    private int colorIndex;

    public LitePegButton()
    {
        this.setOpaque(true);
        this.setBorderPainted(false);
        this.resetColor();
    }
    public Color getColor()
    {
        return this.COLORS[this.colorIndex];
    }

    public void resetColor()
    {
        this.colorIndex = 0;
        this.setBackground(this.getColor());
    }

    public void changeColor()
    {
        this.colorIndex++;
        if (this.colorIndex > this.COLORS.length)
        {
            this.colorIndex = 0;
        }
        this.setBackground(this.getColor());
    }

}
