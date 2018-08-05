package project1;

import java.util.Stack;

/**
 * @author RobertFlorence Java182 Project 1
 */
public class WorkOrders {

    private static SystemTasks[] taskarray = new SystemTasks[20];
    private static int i = 0;

    public WorkOrders() throws Exception {
        taskarray[0] = new SystemTasks("MAR", "Backup Users", 4, 21, 30);
        taskarray[1] = new SystemTasks("APR", "Upgrade Hard Drives", 1, 17, 00);
        taskarray[2] = new SystemTasks("MAY", "Virus Scan", 6, 10, 45);
        taskarray[3] = new SystemTasks("JUN", "Database Backup", 3, 9, 15);

    }

    public static void main(String[] args) throws Exception {
        WorkOrders test = new WorkOrders();
        WorkOrders.run();
    }

    public static void run() throws Exception {
        boolean count = true;

        while (count == true) {
            System.out.println("Menu!\n");
            System.out.println("A)dd SystemTask , D)elete SystemTask , L)ist SystemTask , E)xit");
            System.out.print("Your Option: ");

            char a = UserInput.getChar();
            switch (Character.toLowerCase(a)) {
                case 'a':
                    addSystemTask();
                    break;

                case 'd':
                    deleteSystemTask();
                    break;

                case 'l':
                    listSystemTask();
                    break;

                case 'e':
                    count = false;
                    break;
            }
        }
    }

    public static boolean compareSystemTask(SystemTasks A1, SystemTasks A2) throws Exception {

        if (A1.setDatenum() > A2.setDatenum()) {
            return true;
        }


        return false;
    }

    public static void insertSystemTask(SystemTasks A1, int pos) {
        
        taskarray[pos] = A1;
        
    }

    public static int listSystemTask() {
        int i = 0;

        while (taskarray[i] != null) {

            System.out.println(taskarray[i].toString());
            i++;

        }
        return i;
    }

    public static void deleteSystemTask() {
        
        
        
    }

    public static void addSystemTask() throws Exception {

        int i = 0, pos = 0;
        SystemTasks test = new SystemTasks();
        SystemTasks temp = new SystemTasks();
        System.out.println("Enter System Task into system: ");
        test.inputSystemTask();

        while (taskarray[i] != null) {
            if (compareSystemTask(test, taskarray[i])) {
               
                pos++;
            }
            i++;
        }
        int l= pos;
        for (int k = 0; k<=i-l; k++){
         temp = taskarray[pos];
         insertSystemTask(test, pos);
         test = temp;
         pos++;
           
    }
}
}