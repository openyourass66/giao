import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // 初始化学生信息列表
            ArrayList<Student> studentList = new ArrayList<>();
            studentList.add(new Student("100", "张曦", 20, "男"));
            studentList.add(new Student("110", "林晓", 20, "女"));
            studentList.add(new Student("111", "何峰", 22, "男"));
            studentList.add(new Student("112", "谢瑶", 21, "女"));
            studentList.add(new Student("113", "邓杰", 23, "男"));
            studentList.add(new Student("114", "许琴", 20, "女"));
            studentList.add(new Student("115", "罗宇", 22, "男"));
            studentList.add(new Student("116", "苏婉", 21, "女"));
            studentList.add(new Student("117", "叶涛", 23, "男"));
            studentList.add(new Student("118", "吕珊", 20, "女"));
            studentList.add(new Student("119", "魏宇", 22, "男"));
            // 初始化管理员信息列表
            ArrayList<User_Manager> userManagerList = new ArrayList<>();
            userManagerList.add(new User_Manager("202304353072", "ZX0326.."));
            // 初始化学生使用者信息列表
            ArrayList<User_Student> userStudentList = new ArrayList<>();
            while (true) {
                System.out.println("请选择操作 1:登录 2:注册");
                try {
                    int userChoice = sc.nextInt();
                    sc.nextLine(); // 消耗换行符
                    switch (userChoice) {
                        case 1:
                            // 登录
                            System.out.println("登录");
                            System.out.println("请选择身份 1:学生 2:管理员");
                            int userRole = sc.nextInt();
                            sc.nextLine(); // 消耗换行符
                            switch (userRole) {
                                case 1:
                                    User_Student userStudent = null;
                                    System.out.println("请输入id");
                                    String userStudentId = sc.nextLine();
                                    System.out.println("请输入密码");
                                    String userStudentPassword = sc.nextLine();
                                    if (User_Student.Log_in(userStudentList, userStudentId, userStudentPassword) != null) {
                                        System.out.println("登陆成功");
                                        userStudent = User_Student.Log_in(userStudentList, userStudentId, userStudentPassword);
                                        User_Student.help();
                                        while (true) {
                                            try {
                                                System.out.println("请选择操作：");
                                                int userStudentAction = sc.nextInt();
                                                sc.nextLine(); // 消耗换行符

                                                switch (userStudentAction) {
                                                    case 1:
                                                        System.out.println("查看本人信息");
                                                        userStudent.prtSelf(studentList);
                                                        break;
                                                    case 2:
                                                        System.out.println("查看所有信息");
                                                        User_Student.prtList(studentList);
                                                        break;
                                                    case 3:
                                                        System.out.println("查询学生信息");
                                                        User_Student.search(studentList);
                                                        break;
                                                    case 4:
                                                        System.out.println("查看帮助文档");
                                                        User_Student.help();
                                                        break;
                                                    case 5:
                                                        System.out.println("退出");
                                                        return;
                                                    default:
                                                        System.out.println("请重新输入");
                                                        break;
                                                }
                                            } catch (java.util.InputMismatchException e) {
                                                System.out.println("输入无效，请输入一个整数。");
                                                sc.nextLine(); // 消耗无效输入
                                            }
                                        }
                                    } else {
                                        System.out.println("id或密码错误");
                                    }
                                    break;
                                case 2:
                                    User_Manager userManager = null;
                                    System.out.println("请输入id");
                                    String userManagerId = sc.nextLine();
                                    System.out.println("请输入密码");
                                    String userManagerPassword = sc.nextLine();

                                    if (User_Manager.Log_in(userManagerList, userManagerId, userManagerPassword) != null) {
                                        System.out.println("登陆成功");
                                        userManager = User_Manager.Log_in(userManagerList, userManagerId, userManagerPassword);
                                        User_Manager.help();

                                        while (true) {
                                            try {
                                                System.out.println("请选择操作：");
                                                int userManagerAction = sc.nextInt();
                                                sc.nextLine(); // 消耗换行符

                                                switch (userManagerAction) {
                                                    case 1:
                                                        System.out.println("查看所有信息");
                                                        User_Manager.prtList(studentList);
                                                        break;
                                                    case 2:
                                                        System.out.println("添加学生信息");
                                                        User_Manager.addList(studentList);
                                                        break;
                                                    case 3:
                                                        System.out.println("删除学生信息");
                                                        User_Manager.removeList(studentList);
                                                        break;
                                                    case 4:
                                                        System.out.println("查询学生信息");
                                                        User_Manager.search(studentList);
                                                        break;
                                                    case 5:
                                                        User_Manager.help();
                                                        break;
                                                    case 6:
                                                        System.out.println("退出");
                                                        return;
                                                    default:
                                                        System.out.println("请重新输入");
                                                        break;
                                                }
                                            } catch (java.util.InputMismatchException e) {
                                                System.out.println("输入无效，请输入一个整数。");
                                                sc.nextLine(); // 消耗无效输入
                                            }
                                        }
                                    } else {
                                        System.out.println("id或密码错误");
                                    }
                                    break;
                                default:
                                    System.out.println("请重新输入");
                                    break;
                            }
                            break;
                        case 2:
                            //注册
                            User_Student.register(userStudentList);
                            break;
                        default:
                            System.out.println("请重新输入");
                            break;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("输入无效，请输入一个整数。");
                    sc.nextLine();
                }
            }
        } finally {
            sc.close();
        }
    }
}