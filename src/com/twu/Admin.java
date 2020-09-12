import java.util.Scanner;

public class Admin extends People{
    private String name;
    private String pwd;
    public Admin(String name, String pwd){
        this.name=name;
        this.pwd=pwd;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public static void switch_to_admin() {
        System.out.println("请输入您的昵称");
        Scanner input = new Scanner(System.in);
        String admin_name = input.nextLine();
        System.out.println("请输入您的密码");
        String pwd = input.nextLine();
        if (Main.adminName2User.containsKey(admin_name)) {
            Main.currentPeople = Main.adminName2User.get(admin_name);
        } else {
            Admin admin = new Admin(admin_name, pwd);
            Main.adminName2User.put(admin_name, admin);
            Main.currentPeople = admin;
        }
        Admin_choice(Main.currentPeople);
    }
    public static void Admin_choice(People admin) {
        System.out.print("你好，");
        System.out.print(admin.getName());
        System.out.println(",你可以");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.添加热搜");
        System.out.println("3.添加超级热搜");
        System.out.println("4.退出");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                hot_search.show_hot_search(admin);
            case 2:
                hot_search.add_hot_search(admin);
            case 3:
                hot_search.add_super_hot_search(admin);
            default:
                Main.init();
        }
    }
}
