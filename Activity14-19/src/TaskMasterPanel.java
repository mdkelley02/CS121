import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lesson 18-19: Activity - Task Master GUI
 *
 * This class represents the main TaskMaster JPanel.
 *
 * It contains a ToDoListPanel and the control sub-panel.
 *
 * @author CS121 Instructors
 * @version [semester]
 * @author [your name]
 */
@SuppressWarnings("serial")
public class TaskMasterPanel extends JPanel
{
    private ToDoListPanel listPanel;
    private JTextField descriptionField;
    private JTextField priorityField;
    private JButton addTaskButton;
    private JButton getWorkButton;
    private JScrollPane toDoListScrollPane;

    /**
     * Creates a new TaskMasterPanel.
     */
    public TaskMasterPanel()
    {
        this.setPreferredSize(new Dimension(700, 400));
        setLayout(new BorderLayout());
        listPanel = new ToDoListPanel("CS121 To dos");
        toDoListScrollPane = new JScrollPane(listPanel);
        toDoListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        toDoListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel controlPanel = new JPanel();
        add(controlPanel, BorderLayout.SOUTH);

        descriptionField = new JTextField(15);
        controlPanel.add(new JLabel("description"));
        controlPanel.add(descriptionField);


        priorityField = new JTextField(4);
        controlPanel.add(new JLabel("Priority"));
        controlPanel.add(priorityField);


        addTaskButton = new JButton("Add Task");
        controlPanel.add(addTaskButton);

        getWorkButton = new JButton("Get Work");
        controlPanel.add(getWorkButton);



        getWorkButton.addActionListener(new GetWorkButtonListener());
        addTaskButton.addActionListener(new AddTaskButtonListener());





        add(toDoListScrollPane, BorderLayout.CENTER);

    }
    private class GetWorkButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            listPanel.showWorkDialog();
        }
    }

    private class AddTaskButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("pressed");
            String desc = descriptionField.getText();
            int prior = 0;
            try
            {
                prior = Integer.parseInt(priorityField.getText());
            }
            catch (NumberFormatException nfe)
            {
                priorityField.setText("");
            }
            if (!desc.trim().equals(""))
            {
                listPanel.addTask(new Task(desc, prior));
                descriptionField.setText("");
                priorityField.setText("");
            }

        }
    }

}

