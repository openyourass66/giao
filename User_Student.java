import java.util.ArrayList;
import java.util.Scanner;

public class User_Student {
    private String id;
    private String password;

    public User_Student() {
    }

    public User_Student(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //帮助文档
    public static void help() {
        System.out.println("—————————————");
        System.out.println("|学生管理系统  |");
        System.out.println("|请输入操作:   |");
        System.out.println("|1:查看本人信息|");
        System.out.println("|2:查看所有学生|");
        System.out.println("|3:查询学生信息|");
        System.out.println("|4:查看帮助文档|");
        System.out.println("|5:退出程序   |");
        System.out.println("——————————————");
    }
    //查找注册时id是否合适
    public static boolean check_id(ArrayList<User_Student> list,String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return false;
            }
        }
        return true;
    }
    //注册时密码是否为数字字母结合
    public static boolean check_password(String password) {
        boolean num=false,chars=false;
        for(int i=0;i<password.length();i++) {
            if(password.charAt(i)>='0'&&password.charAt(i)<='9') {
                num=true;
            }
            if(password.charAt(i)>='a'&&password.charAt(i)<='z') {
                chars=true;
            }
            if(num&&chars) {
                return true;
            }
        }
        return false;
    }
    //查看本人信息
    public void prtSelf(ArrayList<Student> List){
        for(int i=0;i<List.size();i++){
            if(List.get(i).getId().equals(this.id)){
                System.out.printf("%-10s %-10s %-10s %-10s %-10s\n","序号","id","姓名","年龄","性别");
                System.out.printf("%-10d %-10s %-10s %-10d %-10s\n",i+1,List.get(i).getId(),
                        List.get(i).getName(),List.get(i).getAge(),List.get(i).getGender());
                return;
            }
        }
        System.out.println("未找到本人信息");

    }
    //查看所有学生信息
    public static void prtList(ArrayList<Student> List){
        if(List.size()==0){
            System.out.println("当前无学生信息");
        }else{
            System.out.printf("%-10s %-10s %-10s %-10s %-10s\n","序号","id","姓名","年龄","性别");
            for(int i=0; i<List.size(); i++){
                System.out.printf("%-10d %-10s %-10s %-10d %-10s\n",i+1,List.get(i).getId(),
                        List.get(i).getName(),List.get(i).getAge(),List.get(i).getGender());
            }
        }

    }
    //查询学生
    public static void search(ArrayList<Student> List) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的id或姓名");
        String input = sc.next();
        boolean found = false;
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId().contains(input) || List.get(i).getName().contains(input)) {
                if (!found) {
                    System.out.println("查询成功");
                }
                found = true;
                System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "序号", "id", "姓名", "年龄", "性别");
                System.out.printf("%-10d %-10s %-10s %-10d %-10s\n", i + 1, List.get(i).getId(),
                        List.get(i).getName(), List.get(i).getAge(), List.get(i).getGender());
            }

        }
        if (!found) {
            System.out.println("查询失败");
        }
    }
    //注册
    public static void register(ArrayList<User_Student> User_Student_List) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入id");
        String new_id=sc.next();
        sc.nextLine();
        System.out.println("请输入密码");
        String new_password=sc.next();
        if(!User_Student.check_id(User_Student_List,new_id)){
            System.out.println("id已存在");
            return;
        }else if(new_id.length()<3||new_id.length()>16){
            System.out.println("id长度需在3~16位");
            return;
        }else if(!User_Student.check_password(new_password)){
            System.out.println("密码需为数字字母结合");
        }else{
            User_Student_List.add(new User_Student(new_id,new_password));
            for(int i=0;i<User_Student_List.size();i++){
                if(User_Student_List.get(i).getId().equals(new_id)&&User_Student_List.get(i).getPassword().equals(new_password)){
                    System.out.println("注册成功");
                    return;
                }else{
                    System.out.println("注册失败");
                    return;
                }
            }
        }
    }
    //登录
    public static User_Student Log_in(ArrayList<User_Student> List,String id,String password){
        for(int i=0; i<List.size(); i++){
            if(List.get(i).getId().equals(id) && List.get(i).getPassword().equals(password)){
                return List.get(i);
            }
        }
        return null;
    }
}
