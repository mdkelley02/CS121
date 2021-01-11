import javax.swing.*;

public class ToDoListPanel extends JPanel {

    private ToDoList list;

    public ToDoListPanel(String name){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.list = new ToDoList(name);
        JLabel nameLabel = new JLabel(list.getName());
        add(nameLabel);
    }

    public void addTask(Task t)
    {
        this.list.addTask(t);
        TaskButton tb = new TaskButton(t);
        add(tb);
        revalidate();
    }

    public void showWorkDialog()
    {
        Task t = list.getWork();
        if (t == null)
        {
            JOptionPane.showMessageDialog(this,
                    "You're all done with your work",
                    "Show Work",
                    JOptionPane.INFORMATION_MESSAGE
                    );
        }
        else
        {
            JOptionPane.showMessageDialog(this,
                    "you should do " + t.getDescription() + " next",
                    "Show Work",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
