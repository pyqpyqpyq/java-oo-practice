import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
//    private static MessageHeader user_list;

    public static void main(String[] args) {
        init();
    }

    static Set<User> user_list = new HashSet<User>();
    static Set<Admin> admin_list = new HashSet<Admin>();
    static Set<hotsearch> memory_list = new HashSet<hotsearch>();
//    ArrayList rec=new ArrayList();


    public static void init(){
        greet();
//        Set<hotsearch> memory_list = new HashSet<hotsearch>();
//        Set<User> user_list = new HashSet<User>();
//        Set<Admin> admin_list = new HashSet<Admin>();
        user_choose();
    }

    public static void greet(){
        System.out.println("欢迎来到热搜榜，你是？");
        System.out.println("1.用户");
        System.out.println("2.管理员");
        System.out.println("3.退出");
    }

    public static void user_choose(){
        Scanner input= new Scanner(System.in);
        int user = input.nextInt();
        if(user == 1) {
            switch_to_user();
        }else if(user == 2){
            switch_to_admin();
        }
    }

    public static void switch_to_user(){
        User using_user;
        System.out.println("请输入您的昵称");
        Scanner input= new Scanner(System.in);
        String username = input.nextLine();
        System.out.print("你好，");
        System.out.print(username);
        if (user_list.toString().contains(username)){using_user=user_list(0);}
        else {user_list.add(new User(username));}

        System.out.println("，你可以");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.给热搜事件投票");
        System.out.println("3.购买热搜");
        System.out.println("4.添加热搜");
        System.out.println("5.退出");
        int choice = input.nextInt();
        switch (choice){
            case 1: show_hot_search();
            case 2: vote_hot_search();
            case 3: buy_hot_search();
            case 4: add_hot_search();
            default: init();
        }
}
    public static void switch_to_admin(){
        System.out.println("请输入您的昵称");
        Scanner input= new Scanner(System.in);
        String username = input.nextLine();
        System.out.println("请输入您的密码");
        String pwd = input.nextLine();
        admin(username);
    }

    public static void show_hot_search(){

    }

    public static void vote_hot_search(){

    }

    public static void buy_hot_search(){

    }
    public static void add_hot_search(){

    }

    public static void add_super_hot_search(){

    }
    public static void admin(String username){
        System.out.println("你好，");
        System.out.println(username);
        System.out.println(",你可以");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.添加热搜");
        System.out.println("3.添加超级热搜");
        System.out.println("4.退出");
        Scanner input= new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice){
            case 1:show_hot_search();
            case 2:add_hot_search();
            case 3:add_super_hot_search();
            default:init();
        }
    }
}
