package org.example.Room;

import org.example.interfaces.Add;
import org.example.interfaces.Delete;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.example.Building.BuildingManager.buildingMap;
import static org.example.Community.CommunityManager.communityMap;

public class RoomManager implements Add<String[]>, Delete<String>{

//房间信息内容：
// 房屋编号（作为房屋的唯一标识）、
// 房号名称、
// 业主名称、
// 房屋建筑面积、

// 物业管理费用、
// 是否缴纳、
// 下一次缴纳时间、

// 车库进入标志、

//小区编号、
// 楼栋编号

    public static final HashMap<String, String> roomMap = new HashMap<>();

    @Override
    public void addInfo(String[] data) {
        String id = data[0];
        //检查有没有这个小区和这个楼栋,还有这个楼栋是不是属于这个小区的
        if(communityMap.containsKey(data[8]) && buildingMap.containsKey(data[9]) && buildingMap.get(data[9]).contains(data[8])) {
            String moreInfo = String.join(",", Arrays.copyOfRange(data, 1, data.length));
            if (!roomMap.containsKey(id)) {
                roomMap.put(id, moreInfo);
                System.out.println("添加编号" + id + "房间成功");
            } else {
                System.out.println("编号" + id + "房间已存在");
            }
        }
    }

    @Override
    public void delInfo(String id) {
        if(!roomMap.containsKey(id)){
            System.out.println("无法找到房间信息");
        }else{
            roomMap.remove(id);
            System.out.println("删除编号"+id+"房间成功");
        }
    }

    //{key = id : value = "name, owner, area, fees, feesStatus, nextPaymentDue, garageSign, comId, buildId"}
    public void choiceSetRoom(String id, Integer choice, String updated){
        if(roomMap.containsKey(id)) {
            String[] info = roomMap.get(id).split(",");

            switch (choice) {
                case 1:
                    info[0] = updated;
                    String nameUpdated = String.join(",",info);
                    roomMap.put(id,nameUpdated);
                    System.out.println("更改成功！");
                    break;

                case 2:
                    info[1] = updated;
                    String ownerUpdated = String.join(",",info);
                    roomMap.put(id,ownerUpdated);
                    System.out.println("更改成功！");
                    break;

                case 3:
                    info[2] = updated;
                    String areaUpdated = String.join(",",info);
                    roomMap.put(id,areaUpdated);
                    System.out.println("更改成功！");
                    break;

                case 4:
                    info[3] = updated;
                    String feesUpdated = String.join(",",info);
                    roomMap.put(id,feesUpdated);
                    System.out.println("更改成功！");
                    break;

                case 5:
                    info[4] = updated;
                    String feesStatusUpdated = String.join(",",info);
                    roomMap.put(id,feesStatusUpdated);
                    System.out.println("更改成功！");
                    break;

                case 6:
                    info[5] = updated;
                    String nextPaymentDueUpdated = String.join(",",info);
                    roomMap.put(id,nextPaymentDueUpdated);
                    System.out.println("更改成功！");
                    break;

                case 7:
                    info[6] = updated;
                    String garageSignUpdated = String.join(",",info);
                    roomMap.put(id,garageSignUpdated);
                    System.out.println("更改成功！");
                    break;

                case 8:
                    if(communityMap.containsKey(info[7])){
                    info[7] = updated;
                    String comIdUpdated = String.join(",",info);
                    roomMap.put(id,comIdUpdated);
                    System.out.println("更改成功！");

                    }else{
                        System.out.println("查无小区");
                    }
                    break;

                case 9:
                    if(buildingMap.get(info[8]).contains(info[7])){
                        //确认有这个小区同时，这个小区有这个楼，
                    info[8] = updated;
                    String buildIdUpdated = String.join(",",info);
                    roomMap.put(id,buildIdUpdated);
                    System.out.println("更改成功！");
                    }else{
                        System.out.println("房屋所在小区编号" + info[8] + "查无此楼栋");
                    }
                    break;

                default:
                    System.out.println("无效选择");
            }
        }else{
            System.out.println("无法找到编号对应房屋");
        }
    }

    public void showData(){
        for (Map.Entry<String, String> entry : roomMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("房屋编号: " + key + ", 房屋信息: " + value);
        }
    }



}
