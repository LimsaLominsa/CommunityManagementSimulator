package org.example.Building;

import org.example.interfaces.Add;
import org.example.interfaces.Delete;
import org.example.interfaces.Modify;

import java.util.HashMap;
import java.util.Map;

import static org.example.Community.CommunityManager.communityMap;

public class BuildingManager implements Add<String[]>, Delete<String>, Modify<String[]> {
    public static final HashMap<String, String> buildingMap = new HashMap<>();

    @Override
    public void addInfo(String[] data) {
        String id = data[0];
        String comId = data[2];
        String nameComId = data[1] + "," + comId;
        if (!buildingMap.containsKey(id) && communityMap.containsKey(comId)) { //无重复添加和有此小区
            buildingMap.put(id, nameComId);
            System.out.println("添加编号" +id+ "楼栋成功");
        }else {
            System.out.println("编号"+id+"楼栋添加失败，请检查内容");
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
        String id = data[0];

        if(getBuildingUseId(id) == null){
            System.out.println("无法找到信息");
        }else{
            setBuildingUseId(id,data[1],data[2]);
            System.out.println("修改编号"+id+"小区成功");
        }

    }


    public void showData(){
        for (Map.Entry<String, String> entry : buildingMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("楼栋编号: " + key + ", 楼栋名称，小区编号: " + value);
        }
    }

    public String getBuildingUseId(String id){
        return buildingMap.get(id);
    }

    public void setBuildingUseId(String id, String name, String comId){
        // 确保id、name和address都不为空
        if (id != null
                && !id.trim().isEmpty()
                && name != null
                && !name.trim().isEmpty()
                && comId != null
                && !comId.trim().isEmpty()
                && communityMap.containsKey(comId)) {

            System.out.println("此编号原信息: " + buildingMap.get(id));
            String nameComId = name + "," + comId;
            buildingMap.put(id, nameComId);
            System.out.println("更新成功！");

        } else {
            System.out.println("错误：名称和小区编号都不能为空！");
        }
    }


}
