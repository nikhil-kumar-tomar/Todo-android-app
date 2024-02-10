package com.example.myapplication.tasks;

class Node
{
    int id;
    static int counter;
    Node()
    {
        id = counter;
        counter += 1;
    }
    String to_do_task;
    Node next;
}
public class Task
{

    Node head;
    private static Task instance;
    private Task()
    {
        head = new Node();
    }

    public static Task getTask()
    {
        if (Task.instance == null)
        {
            Task.instance = new Task();
        }
        return Task.instance;
    }


    public void addTask(String to_do_task)
    {
        Node newnode = new Node();
        newnode.to_do_task = to_do_task;
        traverse().next = newnode;
    }

    Node traverse()
    {
        /**
          This function will give the last node, whoose next is null good for insertion
         **/
        Node current_node = head;
        while (current_node.next != null)
        {
            current_node = current_node.next;
        }
        return current_node;
    }
    Node traverse(int id)
    {
        /**
         * This functions will give the previous node of the asked id, good for deletion of
         * node which is asked, used for updation as well I amg going to anyway.
         * **/
        Node current_node = head;
        while (current_node.next.id != id)
        {
            current_node = current_node.next;
        }
        return current_node;
    }

    public String[] allTasks()
    {
        Node current_node = head.next;
        String[] all_tasks = new String[Node.counter - 1];
        int i = 0;
        while (current_node != null)
        {
            all_tasks[i] = current_node.to_do_task;
            current_node = current_node.next;
            i += 1;
        }
        return all_tasks;
    }

    public int[] allTasksIds()
    {
        Node current_node = head.next;
        int[] all_tasks = new int[Node.counter - 1];
        int i = 0;
        while (current_node != null)
        {
            all_tasks[i] = current_node.id;
            current_node = current_node.next;
            i += 1;
        }
        return all_tasks;

    }

    public void deleteTask(int id)
    {
        traverse(id).next = traverse(id).next.next;
        Node.counter -= 1;
    }

    public void updateTask(int id, String to_do_task)
    {
        traverse(id).next.to_do_task = to_do_task;
    }

}
