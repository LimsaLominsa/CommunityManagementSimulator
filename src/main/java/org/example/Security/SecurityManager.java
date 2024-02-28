package org.example.Security;

import org.example.interfaces.Add;
import org.example.interfaces.Delete;

import java.util.Arrays;
import java.util.HashMap;

import static org.example.Building.BuildingManager.buildingMap;
import static org.example.Community.CommunityManager.communityMap;

public class SecurityManager implements Add<String[]>, Delete<String> {
    public static final HashMap<String , String> securityMap = new HashMap<>();

    @Override
    public void addInfo(String[] data) {
        String id = data[0];
        String moreInfo = String.join(",", Arrays.copyOfRange(data, 1, data.length));
        if (!securityMap.containsKey(id)) {
            securityMap.put(id, moreInfo);
            System.out.println("添加编号" + id + "安保成功");
        } else {
            System.out.println("编号" + id + "安保已存在");
        }
    }

    @Override
    public void delInfo(String id) {
        if(!securityMap.containsKey(id)){
            System.out.println("无法找到安保信息");
        }else{
            securityMap.remove(id);
            System.out.println("删除编号"+id+"安保成功");
        }
    }

    public void choiceSetSecurity(String id , Integer choice , String updated){
        if(securityMap.containsKey(id)){
            String[] info = securityMap.get(id).split(",");

            switch(choice){
                case 1:
                    info[0] = updated;
                    String nameUpdated = String.join(",",info);
                    securityMap.put(id,nameUpdated);
                    System.out.println("更改成功！");
                    break;

                case 2:
                    info[1] = updated;
                    String levelUpdated = String.join(",",info);
                    securityMap.put(id,levelUpdated);
                    System.out.println("更改成功！");
                    break;

                case 3:
                    info[2] = updated;
                    String payUpdated = String.join(",",info);
                    securityMap.put(id,payUpdated);
                    System.out.println("更改成功！");
                    break;

                case 4:
                    info[3] = updated;
                    String payStatusUpdated = String.join(",",info);
                    securityMap.put(id,payStatusUpdated);
                    System.out.println("更改成功！");
                    break;

                default:


            }

        }else{
            System.out.println("查无此人");
        }



    }



}
