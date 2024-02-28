package org.example.Community;

import org.example.interfaces.Add;
import org.example.interfaces.Delete;
import org.example.interfaces.Modify;

import java.util.HashMap;
import java.util.Map;

public class CommunityManager implements Add<String[]>, Delete<String>, Modify<String[]> {
    public static final HashMap<String, String> communityMap = new HashMap<>();
    //static final确保程序运行期间只有一个hashmap存储小区信息

    @Override
    public void addInfo(String[] data) {
        String id = data[0];
        String nameAddress = data[1] + "," + data[2];
        if (!communityMap.containsKey(id)) {
            communityMap.put(id, nameAddress);
            System.out.println("添加编号" + id+ "小区成功");
        }else {
            System.out.println("编号"+id+"小区已存在");
        }
    }

    @Override
    public void delInfo(String id) {
        if(getCommunityUseId(id) == null){
            System.out.println("无法找到信息");
        }else{
            communityMap.remove(id);
            System.out.println("删除编号"+id+"小区成功");
        }
    }

    @Override
    public void modInfo(String[] data){
        String id = data[0];

        if(getCommunityUseId(id) == null){
            System.out.println("无法找到信息");
        }else{
            setCommunityUseId(id,data[1],data[2]);
            System.out.println("修改编号"+id+"小区成功");
        }

    }


    public String getCommunityUseId(String id) {
        return communityMap.get(id);
    }


    public void setCommunityUseId(String id, String name, String address){
        // 确保id、name和address都不为空
        if (id != null && !id.trim().isEmpty() && name != null && !name.trim().isEmpty() && address != null && !address.trim().isEmpty()) {
            System.out.println("此编号原信息: " + communityMap.get(id));
            String nameAddress = name + "," + address;
            communityMap.put(id, nameAddress);
            System.out.println("更新成功！");
        } else {

            System.out.println("错误：名称和地址都不能为空！");
        }
    }

    public void showData(){
        for (Map.Entry<String, String> entry : communityMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("小区编号: " + key + ", 小区名称，地址: " + value);
        }
    }



}

