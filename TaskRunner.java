import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.LinkedList;

public class TaskRunner {
    LinkedList<Task> taskList;

    public TaskRunner() {
        taskList = new LinkedList<>();
    }

    public void runTaskPlanner() {
        Scanner userInput = new Scanner(System.in);
        boolean running = true;

        System.out.println("This program will allow you to create a schedule for the day for your tasks. ");

        while(running) {
            int initialMenuAnswer = printInitialMenu(userInput);

            switch (initialMenuAnswer) {
                case 1:
                    Task currentTask = createNewTask(userInput);
                    taskList.add(currentTask);
                case 2:
                    showSchedule();
            }

            int askAgain = useAppAgain(userInput);

            if(askAgain == 1) {
                System.out.println("Okay taking you back to the main menu. ");
            }
            else {
                running = false;
            }

        }

    }


    public Task createNewTask(Scanner userInput) {
        System.out.println("What is the objective of this task? ");
        String task = userInput.next();

        boolean lookingForTimeFrame = true;
        int timeToComplete = 0;
        while(lookingForTimeFrame) {
            try {
                System.out.println("How long should this take to complete in hours? ");
                timeToComplete = userInput.nextInt();
                lookingForTimeFrame = false;
            }
            catch (InputMismatchException e) {
                System.out.println("You must enter a integer. Please try again. ");
                userInput.next();
            }
        }

        boolean lookingForNumBreaks = true;
        int numBreaks = 0;
        while(lookingForNumBreaks) {
            try {
                System.out.println("How Many Breaks do you want? ");
                timeToComplete = userInput.nextInt();
                lookingForNumBreaks = false;
            }
            catch (InputMismatchException e) {
                System.out.println("You must enter a integer. Please try again. ");
                userInput.next();
            }
        }

        return new Task(task, timeToComplete, numBreaks);
    }


    public int printInitialMenu(Scanner userInput) {
        boolean validResponse = false;

        while(!validResponse) {
            try {
                System.out.println("Press 1 to add a task ");
                System.out.println("Press 2 to show the current schedule of tasks ");

                int menuAnswer = userInput.nextInt();
                if(menuAnswer == 1 || menuAnswer == 2) {
                    return menuAnswer;
                }
                else {
                    System.out.println("The only valid choices are 1 or 2, please try again. ");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("The only valid choices are 1 or 2, please try again. ");
                userInput.next();
            }

        }
        return 0;
    }

    public int useAppAgain(Scanner userInput) {
        boolean validResponse = false;
        while(!validResponse) {
            try {
                System.out.println("Press 1 to use the application again, otherwise press 2 to quit. ");

                int againAnswer = userInput.nextInt();
                if (againAnswer == 1 || againAnswer == 2) {
                    return againAnswer;
                }
                else {
                    System.out.println("The only valid choices are 1 or 2, please try again. ");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("The only valid choices are 1 or 2, please try again. ");
                userInput.next();
            }
        }
        return 0;
    }

    public void showSchedule() {
        LocalTime currentTime = Time.getLocalTime();

        for(Task currentTask : taskList) {
            System.out.println(currentTime + ": " + currentTask.getObjective());
            if(currentTask.getNumberOfBreaks() > 0) {
                currentTime.plusHours(currentTask.getNumberOfBreaks());
            }
            else {
                currentTime.plusHours(1);
            }
        }
    }
// add time to current time and thinking making new simpledate formate object.

}
