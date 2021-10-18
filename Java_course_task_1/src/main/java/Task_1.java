import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Task_1 {
    static Scanner in  = new Scanner(System.in);
    static Task task_one = null;
    //static List<Task> list_task = new ArrayList<Task>();
    public static void main(String[] args) {
        String input = " ";
        String status_task = " ";
        int counter = 1;

        while (!input.equals("quit")) {
            System.out.println("Выберите команду: ");
            System.out.println(" add - добавление задачи\n" +
                    " print - печать списка задач\n" +
                    " toggle - изменение статуса задачи\n" +
                    " quit - завершение работы");

            System.out.print("Выберите команду :  ");
            input = in.next();
            String arg = in.nextLine().trim();
            switch (input) {
                case ("add"):

                    if(arg.equals("")){
                        System.out.println("Не введено описание задачи");
                        }
                    else {
                        task_one = new Task(1," ",arg);

                    }
                    break;

                case ("print"):
                    if(accert_task()) {
                        System.out.println("Список задач пустой");
                    } else {
                        if (arg.equals("all")) {
                            System.out.println(task_one.toString());
                        }else{
                            if(task_one.getStatus().equals(" ")){
                                System.out.println(task_one.toString());
                            }
                        }
                    }


                    break;
                case ("toggle"):
                    if(accert_task())
                    {
                        System.out.println("Список задач пустой");
                    }
                    else {
                        if(arg.equals("")){
                            System.out.println("Не указан индификатор");
                        }
                        else {
                            if(arg.equals(task_one.getId().toString())){
                            change_status_task();}
                            else
                            {
                                System.out.println("Указанн не верный индификатор");
                            }
                        }
                    }
                    break;
                case ("quit"):
                    System.out.println("Завершение работы");
                    break;
                default:
                    System.out.println(" Введено неверное значение.\n" +
                            "Повторите ввод!");
            }

            input = "";
            arg = "";

        }
    }

    static boolean accert_task (){

        return task_one==null;
    }
    static void change_status_task(){
        boolean err = true;
        while (err) {
            System.out.println("Измените статус задачи\n" +
                    " \" \"  - задача выполнена\n" +
                    " x - задача не выполнена");
            String input = in.nextLine();
            switch (input) {
                case (" "):
                    err = false;
                    task_one.setStatus(" ");
                    break;
                case ("x"):
                    err = false;
                    task_one.setStatus("x");
                    break;

                default:
                    System.out.println("Введено неверное значение.");
                    break;
            }
        }
    }
}
