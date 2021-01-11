public class Task implements Comparable<Task>
{
    private String description;
    private int priority;
    private boolean complete;
    private Category category;

    //enum list of categories
    public enum Category
    {
        PERSONAL, WORK, NONE
    };

    public Task(String description, int priority, Category category)
    {
        this.description = description;
        this.priority = priority;
        this.complete = false;
        this.category = category;
    }

    public Task(String description, int priority)
    {
        this.description = description;
        this.priority = priority;
        this.complete = false;
        this.category = Category.NONE;
    }

    @Override
    public int compareTo(Task t)
    {
        if( (this.complete && t.complete) || (!this.complete && !t.complete) )
        {
            if ( this.priority == t.priority )
            {
                return 0;
            }
            else if ( this.priority < t.priority )
            {
                return -1;
            }
            else
            {
                return 1;
            }

        }
        else if ( this.complete && !t.complete)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }

    public String toString()
    {
        String isComplete = this.complete ? "[x]" : "[]";
        String response = isComplete + " " + this.description + ", " + this.category + ", " + this.priority;
        return response;
    }

    public boolean equals(Task task)
    {
        if (this.description.equalsIgnoreCase(task.getDescription()) && this.category.equals(task.category))
        {
            return true;
        }
        return false;
    }

    public Category getCategory()
    {
        return this.category;
    }

    public void setCategory(Category c)
    {
        this.category = c;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String request)
    {
        this.description = request;
    }

    public int getPriority()
    {
        return this.priority;
    }

    public void setPriority(int request)
    {
         this.priority = request;
    }

    public boolean isComplete()
    {
        return this.complete;
    }

    public void setComplete(boolean request)
    {
        this.complete = request;
    }
}

