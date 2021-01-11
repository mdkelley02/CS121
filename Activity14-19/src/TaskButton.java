import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskButton extends JButton{
    //fields
    private Task task;
    //task constructor
    public TaskButton(Task t)
    {
        this.task = t;
        setText(t.toString());
        addActionListener(new TaskButtonListener());
    }

    private class TaskButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(task.isComplete())
            {
                task.setComplete(false);
                setForeground(Color.black);
            }
            else
            {
                task.setComplete(true);
                setForeground(Color.gray);
            }
            setText(task.toString());
        }
    }
}

