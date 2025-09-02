
package class3.s2022350143202.controller;

import class3.s2022350143202.model.UserZJQModel;
import class3.s2022350143202.service.imp.LoginZJQServiceImpl;
import class3.s2022350143202.utils.ValidateZJQUtil;

import java.util.Random;
import java.util.Scanner;

public class LoginZJQController {
    Scanner scanner = new Scanner(System.in);
    boolean flag = false;

    public void login() {

        Random random = new Random();
        LoginZJQServiceImpl loginService = new LoginZJQServiceImpl();
        int code = random.nextInt(9999);
        System.out.println("=========进销存管理系统=========");
        System.out.println("欢迎使用，请先登录！");
        System.out.println("登录验证码：" + code);

        System.out.println("请输入用户名:");
        String user = scanner.next();

        System.out.println("请输入密码:");
        String pwd = scanner.next();

        System.out.println("请输入验证码:");
        int codeInput = scanner.nextInt();

        if (codeInput != code) {
            System.out.println("验证码错误");
            login();
        }

        if (!user.isEmpty() && !pwd.isEmpty() && !ValidateZJQUtil.checkUser(user) && !ValidateZJQUtil.checkPassword(pwd)) {
            System.out.println("用户名不存在或者密码格式错误！");
            login();
        }
         else {
            UserZJQModel userModel = new UserZJQModel();
            userModel.setUsername(user);
            userModel.setPassword(pwd);
            if (loginService.checkLogin(userModel)) {
                System.out.println("登录成功！");
                String[] args = new String[0];
                HomeZJQController.main(args);
            } else {
                System.out.println("用户名|密码错误");
                login();
            }
        }

    }
}
