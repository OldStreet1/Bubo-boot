package com.bubo.knowledge.cases;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 解析MDB文件
 * @author： cd
 * @date： 2023-12-13 16:55
 */
public class MDBUtil {
    /**
     * 读取解析access文件
     * @param mdbFile
     * @return
     */
    @SuppressWarnings({"unchecked"})
    public static List<Map> readFileACCESS(File mdbFile) {
        List<Map> maplist = new ArrayList();
        try {
            if (mdbFile.exists()) {
                Database dbin = null;
                dbin = DatabaseBuilder.open(mdbFile);//读文件
                Set<String> tables = dbin.getTableNames();

                for (String t : tables) {//遍历所有表名
                    Map mapTable = new HashMap();
                    mapTable.put("tableName", t);
                    Table table = dbin.getTable(t);//获取对应表结构
                    List<Map> list = new ArrayList();
                    for (Map<String, Object> map : table) {//遍历表数据
                        list.add(map);
                    }
                    mapTable.put("data", list);
                    maplist.add(mapTable);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maplist;
    }


    /**
     * 测试
     * @param args
     */
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        MDBUtil rmf = new MDBUtil();
        File mdbFile = new File("/Users/street/Desktop/公园建库.mdb");
        List<Map> rstMap = rmf.readFileACCESS(mdbFile);
        System.out.println("rstMap = " + rstMap);
    }

}