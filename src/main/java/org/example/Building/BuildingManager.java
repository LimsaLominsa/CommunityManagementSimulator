package org.example.Building;

import org.example.interfaces.Add;
import org.example.interfaces.Delete;
import org.example.interfaces.Modify;

import java.util.HashMap;

import static org.example.Community.CommunityManager.communityMap;

public class BuildingManager implements Add<String[]>, Delete<String>, Modify<String[]> {
    private static final HashMap<String, String> buildingMap = new HashMap<>();

    @Override
    public void addInfo(String[] data) {
        String id = data[0];
        String comId = data[2];
        String nameComId = data[1] + "," + comId;
        if (!buildingMap.containsKey(id) || communityMap.containsKey(comId)) {
            buildingMap.put(id, nameComId);
            System.out.println("添加编号" +id+","+nameComId+ "楼栋成功");
        }else {
            System.out.println("编号"+id+"楼栋已存在");
        }

    }

    @Override
    public void delInfo(String id) {
        if(getBuildingUseId(id) == null){
            System.out.println("无法找到楼栋信息");
        }else{
            buildingMap.remove(id);
            System.out.println("删除编号"+id+"楼栋成功");
        }
    }

    @Override
    public void modInfo(String[] data) {

    }


    //show buildings

    public String getBuildingUseId(String id){
        return buildingMap.get(id);
    }


}
