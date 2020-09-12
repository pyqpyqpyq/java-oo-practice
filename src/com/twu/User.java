import java.util.Scanner;

public class User extends People{
    private String name;
    private int votes;
    public User(String name){
        this.name=name;
        this.votes=10;
    }
    public User(String name, int votes){
        this.name=name;
        this.votes=votes;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public static void switch_to_user() {
        System.out.println("请输入您的昵称");
        Scanner input = new Scanner(System.in);
        String user_name = input.nextLine();
        if (Main.userName2User.containsKey(user_name)) {
            Main.currentPeople = Main.userName2User.get(user_name);
        } else {
            User user = new User(user_name, 10);
            Main.userName2User.put(user_name, user);
            Main.currentPeople = user;
        }User_choice(Main.currentPeople);
    }

    public static void User_choice(People user) {
        System.out.print("你好，");
        System.out.print(user.getName());
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
                hot_search.show_hot_search(user);
            case 2:
                hot_search.vote_hot_search((User) user);
            case 3:
                hot_search.buy_hot_search(user);
            case 4:
                hot_search.add_hot_search(user);
            default:
                Main.init();
        }
    }
}
