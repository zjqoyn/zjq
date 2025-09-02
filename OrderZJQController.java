
package class3.s2022350143202.controller;

import class3.s2022350143202.data.OrdersZJQData;
import class3.s2022350143202.model.OrdersZJQModel;
import class3.s2022350143202.service.imp.OrderZJQServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderZJQController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrdersZJQData ordersZJQData = new OrdersZJQData();
        List<OrdersZJQModel> ordList = new ArrayList<>();
        OrderZJQServiceImpl orderService = new OrderZJQServiceImpl();

        int num;
        do {
            System.out.println("========== 库存管理 =========");
            System.out.println("====       0.返回首页    ====");
            System.out.println("====       1.订单查询    ====");
            System.out.println("====       2.订单录入    ====");
            System.out.println("====       3.订单更新    ====");
            System.out.println("请输入功能对应选项:");
            num = scanner.nextInt();

            switch (num) {
                case 0:
                    HomeZJQController.main(args);
                    break;
                case 1:
                    System.out.println("====  订单查询  ====");
                    System.out.println("0: 用订单编号查询或者用户名查询");
                    System.out.println("1: 按日期段（开始日期-结束日期）查询");
                    System.out.println("请输入你要使用的功能:");
                    int num1 = scanner.nextInt();
                    scanner.nextLine();
                    if (num1 == 0) {
                        System.out.println("请输入订单编号或用户名：");
                        String id_or_customName = scanner.next();
                        ordList = orderService.getOrder(id_or_customName);
                        for (OrdersZJQModel ordersModel : ordList) {
                            System.out.println("订单id为：" + ordersModel.getGoodId() + "  订单名称为：" + ordersModel.getGoodName() + "  订单价格为：" + ordersModel.getTotalPrice() + "  订单数量为：" + ordersModel.getQuantity());

                        }
                    }

                    if (num1 == 1) {
                        System.out.println("请输入开始日期：(格式为yy-mm-dd)");
                        String startDate = scanner.next();
                        System.out.println("请输入结束日期：(格式为yy-mm-dd)");
                        String endDate = scanner.next();
                        ordList = orderService.getOrder(startDate,endDate);
                        for(OrdersZJQModel ordersModel:ordList) {
                            System.out.println("订单id为：" + ordersModel.getGoodId() + "  订单名称为：" + ordersModel.getGoodName() + "  订单价格为：" + ordersModel.getTotalPrice() + "  订单数量为：" + ordersModel.getQuantity());
                        }
                    }

                    System.out.println("是否要保存查询信息（0保存，其余自动退出）");
                    int save = scanner.nextInt();
                    if (save == 0) {
                        orderService.exportData(ordList);
                    } else {
                        System.out.println("操作结束");
                    }
                    break;
                case 2:
                    System.out.println("====  订单录入  ====");
                    System.out.println("请输入你的用户名：");
                    String customerName = scanner.next();
                    scanner.nextLine();
                    System.out.println("请输入你要购买的商品名称：");
                    String goodName = scanner.next();
                    scanner.nextLine();
                    System.out.println("请输入商品的编号：");
                    String goodId = scanner.next();
                    scanner.nextLine();
                    System.out.println("请输入商品的价格");
                    int goodPrice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("请输入你要购买的数量");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    for(OrdersZJQModel ordersModel:ordersZJQData.getOrdersDataList()){
                        if(goodId.equals(ordersModel.getGoodId())){
                            System.out.println("订单编号重复！");
                        }
                        else{
                            OrdersZJQModel orderModel = new OrdersZJQModel(LocalDateTime.now(),customerName,goodId,goodName,goodPrice,quantity);
                            orderService.addOrders(orderModel);
                            System.out.println("订单录入成功！！");
                            break;
                        }
                    }
                    orderService.show();
                    break;
                case 3:
                    orderService.show();
                    break;
            }
        } while(num != 0);

    }
}
