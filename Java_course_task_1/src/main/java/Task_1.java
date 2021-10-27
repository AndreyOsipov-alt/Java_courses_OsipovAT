import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Task_1 {
    static Scanner in  = new Scanner(System.in);

    static List<Task> list_task = new ArrayList<Task>();
    public static void main(String[] args) {
        String comm = " ";
        Integer count = 0;


        while (!comm.equals("quit")) {
            comm = "";
            Integer arg_edit = 0;
            String arg2_edit = "";
            String arg = "";
            Integer arg2 = 0;

            System.out.println("Выберите команду: ");
            System.out.println(" add - добавление задачи\n" +
                    " print - печать списка задач\n" +
                    " search - поиск задачи\n" +
                    " toggle - изменение статуса задачи\n" +
                    " delete - удаление задачи\n" +
                    " edit - изменение описание задачи\n" +
                    " quit - завершение работы");
            System.out.print("Выберите команду :  ");


            comm = in.next();
            if(comm.equals("edit")) {
                arg_edit = in.nextInt();
                arg2_edit = in.nextLine().trim();
            }
            if(comm.equals("add")||comm.equals("print")||comm.equals("search")) {
                arg = in.nextLine().trim();
            }

            if(comm.equals("toggle")||comm.equals("delete")) {
                arg2 = in.nextInt();
            }




            switch (comm) {
                case ("add"):

                    if(arg.equals("")){
                        System.out.println("Не введено описание задачи");
                        }
                    else {
                            list_task.add(new Task( " ", arg));
                            count++;
                            }
                    break;

                case ("print"):
                    accert_task();


                    if(arg.equals("all")){
                    for (Task task:list_task) {
                        System.out.println((list_task.indexOf(task)+1)+ "." + task.toString());
                    }}else
                    {
                        for (Task task:list_task) {
                            if(task.getStatus().equals(" "))
                                System.out.println((list_task.indexOf(task)+1) + "." + task.toString());

                        }
                    }


                    break;

                case ("search"):

                    for (Task task:list_task) {
                      if(task.getName_task().contains(arg)){
                          System.out.println((list_task.indexOf(task)+1) + "." + task.toString());
                      }else{
                          System.out.println("Совпадений не найдено");
                      }

                    }
                    break;

                case ("toggle"):
                       accert_task();
                       if(arg2.equals("")) {
                           System.out.println("Неуказан идентификатор задачи");
                       }
                       else {

                           if ( arg2 > list_task.size()) {
                               System.out.println("Неверно указан идентификатор");
                           } else {

                               if (list_task.get(arg2 -1 ).getStatus().equals(" ")) {
                                   list_task.get(arg2 -1).setStatus("x");
                               } else {
                                   list_task.get(arg2 -1).setStatus(" ");
                               }
                           }
                       }
                    break;

                case("delete"):
                    accert_task();
                    if(arg2.equals("")) {
                        System.out.println("Неуказан идентификатор задачи");
                    }
                    else {

                        if ( arg2 > list_task.size()) {
                            System.out.println("Неверно указан идентификатор");
                        } else {

                            list_task.remove(arg2 -1);
                        }
                    }
                    break;

                    case("edit"):
                        accert_task();
                        if(arg2_edit.equals("")&&arg_edit.equals("")){
                            System.out.println("Неверно указаны идентификаторы");
                        }else {
                            list_task.get(arg_edit-1).setName_task(arg2_edit);
                        }

                    break;

                case ("quit"):
                    System.out.println("Завершение работы");
                    break;
                default:
                    System.out.println(" Введено неверное значение.\n" +
                            "Повторите ввод!");
            }


            arg = "";
            arg2 = 0;
            arg2_edit = "";
            arg_edit = 0;

        }
    }

    static void accert_task (){

        if(list_task.isEmpty())
            System.out.println("Список задач пустой");

    }

   /* static void change_status_task(){
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
    }*/
}
