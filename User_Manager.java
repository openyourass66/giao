import java.util.ArrayList;
import java.util.Scanner;

public class User_Manager {
    private String id;
    private String password;

    public User_Manager() {
    }

    public User_Manager(String id, String password) {
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
        System.out.println("|1:查看所有学生|");
        System.out.println("|2:录入学生信息|");
        System.out.println("|3:删除学生信息|");
        System.out.println("|4:查询学生信息|");
        System.out.println("|5:查看帮助文档|");
        System.out.println("|6:退出程序   |");
        System.out.println("——————————————");
    }
    //查找id是否存在
    public static int check(ArrayList<Student> List, String id) {
        for (int i = 0; i < List.size(); i++) {
            if(List.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
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
    //添加学生信息
    public static void directAddlist(ArrayList<Student> List,Student s){
        if(check(List,s.getId())!=-1){
            System.out.println("该id已存在");
        }else{
            List.add(s);
        }
    }
    public static void addList(ArrayList<Student> List){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入id");
        String id=sc.next();
        if(check(List,id)!=-1){
            System.out.println("该id已存在");
        }else{
            System.out.println("请输入姓名");
            String name=sc.next();
            System.out.println("请输入年龄");
            int age=sc.nextInt();
            sc.nextLine();
            System.out.println("请输入性别");
            String gender=sc.nextLine();
            List.add(new Student(id,name,age,gender));
            if(check(List,id)!=-1){
                System.out.println("添加成功");
            }else{
                System.out.println("添加成功");
            }
        }

    }
    //删除学生信息
    public static void removeList(ArrayList<Student> List){
        if(List.size()==0){
            System.out.println("当前无学生信息");
        }else{
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入要删除学生的id");
            String id=sc.next();
            if(check(List,id)==-1){
                System.out.println("该学生不存在");
            }else{
                List.remove(check(List,id));
                if(check(List,id)==-1){
                    System.out.println("已删除");
                }else{
                    System.out.println("删除失败");
                }
            }

        }
    }
    //查询学生
    public static void search(ArrayList<Student> List){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的id或姓名");
        String input=sc.next();
        boolean found=false;
        for(int i=0; i<List.size(); i++){
            if(List.get(i).getId().contains(input) || List.get(i).getName().contains(input)){
                if(!found){
                    System.out.println("查询成功");
                }
                found=true;
                System.out.printf("%-10s %-10s %-10s %-10s %-10s\n","序号","id","姓名","年龄","性别");
                System.out.printf("%-10d %-10s %-10s %-10d %-10s\n",i+1,List.get(i).getId(),
                        List.get(i).getName(),List.get(i).getAge(),List.get(i).getGender());
            }

        }
        if(!found){
            System.out.println("查询失败");
        }
    }
    //登录
    public static User_Manager Log_in(ArrayList<User_Manager> List,String id,String password){
        for(int i=0; i<List.size(); i++){
            if(List.get(i).getId().equals(id) && List.get(i).getPassword().equals(password)){
                return List.get(i);
            }
        }
        return null;
    }
}
