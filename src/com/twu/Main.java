import java.util.*;

public class Main {
//    private static MessageHeader user_list;

    public static void main(String[] args) {
        init();
    }

    static Map<String, User> userName2User = new HashMap<>();
    static Map<String, Admin> adminName2User = new HashMap<>();
    static Map<String, hotsearch> hot_search_list = new HashMap<>();
    static People currentPeople = null;


    public static void init() {
        greet();
        user_choose();
    }

    public static void greet() {
        System.out.println("欢迎来到热搜榜，你是？");
        System.out.println("1.用户");
        System.out.println("2.管理员");
        System.out.println("3.退出");
    }

    public static void user_choose() {
        Scanner input = new Scanner(System.in);
        int user = input.nextInt();
        if (user == 1) {
            switch_to_user();
        } else if (user == 2) {
            switch_to_admin();
        }
    }

    public static void switch_to_user() {
        System.out.println("请输入您的昵称");
        Scanner input = new Scanner(System.in);
        String user_name = input.nextLine();
        if (userName2User.containsKey(user_name)) {
            currentPeople = userName2User.get(user_name);
        } else {
            User user = new User(user_name, 10);
            userName2User.put(user_name, user);
            currentPeople = user;
        }User_choice(currentPeople);
    }

    public static void User_choice(People user) {
        System.out.print("你好，");
        System.out.print(user);
        // 如果当前用户是新用户，则新建一个user将其缓存到map中，并将currentPeople指向该user
        System.out.println("，你可以");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.给热搜事件投票");
        System.out.println("3.购买热搜");
        System.out.println("4.添加热搜");
        System.out.println("5.退出");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                show_hot_search(People user);
            case 2:
                vote_hot_search(People user);
            case 3:
                buy_hot_search(People user);
            case 4:
                add_hot_search(People user);
            default:
                init();
        }
    }

    public static void switch_to_admin() {
        System.out.println("请输入您的昵称");
        Scanner input = new Scanner(System.in);
        String admin_name = input.nextLine();
        System.out.println("请输入您的密码");
        String pwd = input.nextLine();
        if (adminName2User.containsKey(admin_name)) {
            currentPeople = adminName2User.get(admin_name);
        } else {
            Admin admin = new Admin(admin_name, pwd);
            adminName2User.put(admin_name, admin);
            currentPeople = admin;
        }
        admin(admin_name);
    }

    public static void show_hot_search() {
        System.out.println("请输入您的昵称");
    }

    public static void vote_hot_search() {
        System.out.println("请输入你要投票的热搜名称");

    }

    public static void buy_hot_search() {

    }

    public static void add_hot_search(People people) {
        System.out.println("请输入你要添加的热搜事件的名字");
        Scanner input = new Scanner(System.in);
        String hot_search = input.nextLine();
        if (hot_search_list.containsKey(hot_search)) {
            hot_search_list.get(hot_search).addTimes();
        } else {
            hotsearch hs = new hotsearch(hot_search,1);
        }
        if (people)


    }

    public static void add_super_hot_search() {

    }

    public static void admin(String username) {
        System.out.println("你好，");
        System.out.println(username);
        System.out.println(",你可以");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.添加热搜");
        System.out.println("3.添加超级热搜");
        System.out.println("4.退出");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                show_hot_search();
            case 2:
                add_hot_search();
            case 3:
                add_super_hot_search();
            default:
                init();
        }
    }
}
