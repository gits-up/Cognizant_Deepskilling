class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public String toString() {
        return taskId + " - " + taskName + " - " + status;
    }
}

public class TaskManagement {
    static Task head = null;

    public static void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }

    public static void searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println("Task found: " + temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }

    public static void deleteTask(int id) {
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Task prev = head;
        Task curr = head.next;

        while (curr != null) {
            if (curr.taskId == id) {
                prev.next = curr.next;
                System.out.println("Task deleted.");
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Task not found.");
    }

    public static void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Task List:");
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        addTask(101, "Design database", "Pending");
        addTask(102, "Implement API", "In Progress");
        addTask(103, "Testing", "Pending");

        System.out.println("\nTraversing tasks:");
        traverseTasks();

        System.out.println("\nSearching for task with ID 102:");
        searchTask(102);

        System.out.println("\nDeleting task with ID 101:");
        deleteTask(101);

        System.out.println("\nTraversing after deletion:");
        traverseTasks();
    }
}