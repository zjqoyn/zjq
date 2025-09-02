
package class3.s2022350143202.controller;

import class3.s2022350143202.model.GoodsZJQModel;
import class3.s2022350143202.service.imp.GoodsZJQServiceImpl;

import java.util.Scanner;

public class GoodsZJQController {
    public GoodsZJQController() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GoodsZJQServiceImpl goodsService = new GoodsZJQServiceImpl();

        int num;
        do {
            System.out.println("========== 库存管理 =========");
            System.out.println("====       0.返回首页    ====");
            System.out.println("====       1.商品查询    ====");
            System.out.println("====       2.商品录入    ====");
            System.out.println("====       3.商品删除    ====");
            System.out.println("====       4.库存增删    ====");
            System.out.print("请输入选项：");
            num = scanner.nextInt();
            scanner.nextLine();

            switch (num) {
                case 0:
                    HomeZJQController.main(args);
                    break;

                case 1:
                    System.out.println("请输入您需要查找的商品的名称：");
                    String info = scanner.nextLine();
                    goodsService.find_goods(info);
                    break;

                case 2:
                    System.out.println("====  商品录入  ====");
                    System.out.println("请输入商品名称：");
                    String goodName = scanner.next();
                    System.out.println("请输入商品价格：");
                    int goodPrice = scanner.nextInt();
                    System.out.println("请输入商品尺寸：");
                    String goodSize = scanner.next();
                    System.out.println("请输入商品数量：");
                    int goodNum = scanner.nextInt();
                    GoodsZJQModel goodsModel = new GoodsZJQModel(goodName, goodSize, goodPrice, goodNum);
                    goodsService.addGoods(goodsModel);
                    break;

                case 3:
                    System.out.println("====  商品删除  ====");
                    System.out.println("请输入你要删除的商品编号：");
                    String goodId = scanner.next();
                    goodsService.delete(goodId);
                    break;

                case 4:
                    System.out.println("====  库存管理  ====");
                    goodsService.show();
                    System.out.println("请输入你要修改的商品编号：");
                    String id = scanner.next();
                    System.out.println("请输入你要修改的数量：");
                    int number = scanner.nextInt();
                    goodsService.setInventory(id, number);
                    break;
                default:
                    System.out.println("无效选项，请重新输入！");
            }
        } while(num != 0);

    }
}
