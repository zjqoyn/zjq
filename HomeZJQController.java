
package class3.s2022350143202.controller;

import java.util.Scanner;

public class HomeZJQController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========== 登录系统 =========");
        System.out.println("====       0.退出       ====");
        System.out.println("====       1.库存管理    ====");
        System.out.println("====       2.订单管理    ====");
        System.out.print("请输入功能对应选项:");
        int num = scanner.nextInt();
        switch (num) {
            case 0:
                System.out.println("已退出系统！");
                System.exit(0);
            case 1:
                GoodsZJQController.main(args);
            case 2:
                OrderZJQController.main(args);
            default:
                System.out.println("输入的数字不正确...请重试。");
                break;
        }
    }
}
