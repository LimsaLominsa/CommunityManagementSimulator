package org.example;

import org.example.Building.BuildingManager;
import org.example.Community.CommunityManager;
import org.example.Room.RoomManager;

import java.util.Objects;
import java.util.Scanner;

/**
 * 所给代码仅供参考，可以根据自己的设计情况对代码进行修改。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--欢迎来到小区智能管理系统--");
        System.out.println("-------1.管理小区--------");
        System.out.println("-------2.管理物业--------");
        System.out.println("---------3.退出---------");


        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                manageCommunity();
                break;
            case 2:
                managementFees();
                break;
            case 3:
                System.out.println("正在退出...");
                scanner.close();
                break;

            default:
                System.out.println("无效选择");
                showMainMenu();
        }
    }

    //用于第1+n次返回访问主菜单
    private static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--欢迎来到小区智能管理系统--");
        System.out.println("-------1.管理小区--------");
        System.out.println("-------2.管理物业--------");
        System.out.println("---------3.退出---------");



        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                manageCommunity();
                break;
            case 2:
                managementFees();
                break;
            case 3:
                System.out.println("正在退出...");
                scanner.close();
                break;

            default:
                System.out.println("无效选择");
                showMainMenu();
        }


    }

    private static void managementFees() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------管理物业-------");
        System.out.println("------1.查看总额------");
        System.out.println("------2.流水记录------");
        System.out.println("------3.添加记录------");
        System.out.println("------4.返回上级------");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                //checkBalance
                break;
            case 2:
                //checkRecords
                break;
            case 3:
                //addRecord
                break;
            case 4:
                return ;

            default:
                System.out.println("无效输入");


        }
    }

    private static void manageCommunity() {
        Scanner scanner = new Scanner(System.in);
        CommunityManager manage = new CommunityManager();
        System.out.println("-------管理小区-------");
        manage.showData();
        System.out.println("------1.添加小区------");
        System.out.println("------2.删除小区------");
        System.out.println("------3.修改小区------");
        System.out.println("------4.查看楼栋------");
        System.out.println("------5.查看安保------");
        System.out.println("------6.返回上级------");


        int choice = scanner.nextInt();
        //scanner.nextLine();

        switch (choice) {
            case 1://添加
                System.out.println("请输入小区编号：");
                String id = scanner.next(); // 读取编号

                System.out.println("请输入小区名称：");
                String name = scanner.next(); // 读取名称

                System.out.println("请输入地址：");
                String address = scanner.next(); // 读取地址

                String[] data = new String[]{id, name, address};
                manage.addInfo(data);

                manageCommunity();
                break;

            case 2://删除
                System.out.println("请输入需要删除的小区编号:");
                String keyToDelete =scanner.next();
                manage.delInfo(keyToDelete);

                manageCommunity();
                break;

            case 3:
                System.out.println("请输入要更改的小区编号：");
                String idUpdated = scanner.next(); // 读取编号

                System.out.println("请输入要更改的小区名称：");
                String nameUpdated = scanner.next(); // 读取名称

                System.out.println("请输入要更改的小区地址：");
                String addressUpdated = scanner.next(); // 读取地址

                String[] updatedData = new String[]{idUpdated, nameUpdated, addressUpdated};
                manage.modInfo(updatedData);
                manageCommunity();
                break;

            case 4:
                manageBuildings();
                break;
            case 5:
                manageSecurity();
                break;
            case 6:
                showMainMenu();

            default:
                System.out.println("无效输入");
                showMainMenu();

        }
    }

    private static void manageSecurity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------管理安保-------");
        System.out.println("------1.添加安保------");
        System.out.println("------2.删除安保------");
        System.out.println("------3.记录安保------");
        System.out.println("------4.返回上级------");
        //try update git

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                //addSecurity();
                break;
            case 2:
                //deleteSecurity();
                break;
            case 3:
                //modifySecurity();
                break;
            case 4:
                manageCommunity();
            default:
                System.out.println("无效输入");


        }
    }

    private static void manageBuildings() {
        Scanner scanner = new Scanner(System.in);
        BuildingManager manageB = new BuildingManager();
        System.out.println("-------管理楼栋-------");
        manageB.showData();
        System.out.println("------1.添加楼栋------");
        System.out.println("------2.删除楼栋------");
        System.out.println("------3.修改楼栋------");
        System.out.println("------4.管理房屋------");
        System.out.println("------5.返回上级------");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("请输入楼栋编号：");
                String id = scanner.next(); // 读取编号

                System.out.println("请输入楼栋名称：");
                String name = scanner.next(); // 读取名称

                System.out.println("请输入所属小区编号：");
                String comId = scanner.next(); // 读取地址

                String[] data = new String[]{id, name, comId};
                manageB.addInfo(data);
                manageBuildings();
                break;

            case 2://删除
                System.out.println("请输入需要删除的楼栋编号:");
                String keyToDelete =scanner.next();
                manageB.delInfo(keyToDelete);

                manageBuildings();
                break;

            case 3:
                System.out.println("请输入要更改的楼栋编号：");
                String idUpdated = scanner.next(); // 读取编号

                System.out.println("请输入要更改的楼栋名称：");
                String nameUpdated = scanner.next(); // 读取名称

                System.out.println("请输入要更改的小区编号：");
                String comIDUpdated = scanner.next(); // 读取地址

                String[] updatedData = new String[]{idUpdated, nameUpdated, comIDUpdated};
                manageB.modInfo(updatedData);
                manageBuildings();
                break;

            case 4:
                manageRoom();

            case 5:
                manageCommunity();

            default:
                System.out.println("无效输入");
                manageCommunity();

        }
    }

    private static void manageRoom() {
        Scanner scanner = new Scanner(System.in);
        RoomManager manageR = new RoomManager();
        System.out.println("-------管理房屋-------");
        manageR.showData();
        System.out.println("------1.添加房屋------");
        System.out.println("------2.删除房屋------");
        System.out.println("------3.修改房屋------");
        System.out.println("------4.返回上级------");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("请输入房间编号：");
                String id = scanner.next();

                System.out.println("请输入房号名称：");
                String name = scanner.next();

                System.out.println("请输入业主名称：");
                String owner = scanner.next();

                System.out.println("请输入房屋建筑面积编：");
                String area = scanner.next();

                System.out.println("请输入物业管理费用：");
                String fees = scanner.next();

                System.out.println("请输入是否缴纳物业管理费：");
                String feesStatus = scanner.next();

                System.out.println("请输入下一次缴纳时间：");
                String nextPaymentDue = scanner.next();

                System.out.println("请输入车库进入标志：");
                String garageSign = scanner.next();

                System.out.println("请输入小区编号：");
                String comId = scanner.next();

                System.out.println("请输入楼栋编号：");
                String buildId = scanner.next();

                String[] data = new String[]{id, name, owner, area, fees,
                feesStatus, nextPaymentDue, garageSign, comId, buildId};
                manageR.addInfo(data);
                manageRoom();
                break;

            case 2:
                System.out.println("请输入需要删除的房屋编号:");
                String keyToDelete =scanner.next();
                manageR.delInfo(keyToDelete);

                manageBuildings();
                break;

            case 3:
                System.out.println("请输入需要更改的房屋编号");
                String idForUpdate = scanner.next();

                System.out.println("----1.房号名称-----");
                System.out.println("----2.业主名称-----");
                System.out.println("---3.房屋建筑面积---");
                System.out.println("--4.物业管理费用----");
                System.out.println("--5.是否缴纳管理费--");
                System.out.println("--6.下一次缴纳时间--");
                System.out.println("---7.车库进入标志---");
                System.out.println("----8.小区编号-----");
                System.out.println("----9.楼栋编号-----");
                System.out.println("请选择要更改的项目:");
                int choiceUpdate = scanner.nextInt();

                System.out.println("请输入更改内容:");
                String updatedInfo =scanner.next();

                manageR.choiceSetRoom(idForUpdate,choiceUpdate,updatedInfo);

                manageRoom();
                break;
            case 4:
                manageBuildings();

            default:
                System.out.println("无效输入");
                manageRoom();


        }
    }
}