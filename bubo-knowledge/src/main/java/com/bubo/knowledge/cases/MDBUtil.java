package com.bubo.knowledge.cases;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import org.apache.commons.lang.StringUtils;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;
import java.nio.charset.Charset;


import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 解析MDB文件
 *
 * @author： cd
 * @date： 2023-12-13 16:55
 */
public class MDBUtil {
    /**
     * 读取解析access文件
     *
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
                        map.forEach((k, v) -> {
                            if (StringUtils.equals(k, "SHAPE")) {
                                byte[] bytes = (byte[]) v;
//                                // java byte数组打印(十进制输出)
//                                System.out.println("byte数组打印(十进制输出)：\t" + bytes2hexDisplayDec(bytes));
//                                // java byte数组打印(十六进制输出)
//                                System.out.println("byte数组打印(十六进制输出)：\t" + bytes2hexDisplayHex(bytes));
//                                String bytestr; // 设定编码方式相互转换
//                                bytestr = new String(bytes2hexDisplayHex(bytes));
//                                System.out.println("byte[] 转 string输出：\t" + bytestr);

//                                byte[] bytes = aByte; // 将文本转换为字节数组
                                // 将byte数组转换为Blob对象
//                                System.out.println(bytes);
                                try {
                                    Blob blob = new SerialBlob(bytes);
                                    InputStream in = blob.getBinaryStream();

                                    // 将二进制数据保存为文件
                                    FileOutputStream out = new FileOutputStream("/Users/street/Desktop/output.txt");
                                    byte[] buffer = new byte[1024];
                                    int bytesRead = 0;
                                    while ((bytesRead = in.read(buffer)) != -1) {
                                        out.write(buffer, 0, bytesRead);
                                    }
                                    out.close();
                                    in.close();
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                } catch (FileNotFoundException e) {
                                    throw new RuntimeException(e);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
//                                StringBuilder binaryBuilder = new StringBuilder();
//                                for (byte b : bytes) {
//                                    int value = b; // 将每个字节转换为整数
//                                    StringBuilder textBuilder = new StringBuilder();
//                                    for (int i = 7; i >= 0; i--) {
//                                        char bit = ((value >> i) & 1) == 1 ? '1' : '0'; // 获取每一位的二进制值
//                                        binaryBuilder.append(bit);
//                                    }
//                                    binaryBuilder.append(' '); // 为了可读性，每个字节之间添加一个空格
//                                }
//                                System.out.println(binaryBuilder);
//                                byte[] byteArray = getByteArray(String.valueOf(binaryBuilder));
//                                int width = 100; // 图片宽度
//                                int height = 100; // 图片高度
//                                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
//                                // 将字节数组写入图片
//                                for (int x = 0; x < width; x++) {
//                                    for (int y = 0; y < height; y++) {
//                                        int index = x * height + y;
//                                        int bit = byteArray[index] & 0xFF; // 将字节的符号位清零
//                                        int rgb = (bit << 16) | (bit << 8) | bit; // 创建灰度值的RGB值
//                                        image.setRGB(x, y, rgb);
//                                    }
//                                }
//
//                                // 保存图片
//                                try {
//                                    File outputFile = new File("/Users/street/Desktop/output.png"); // 图片保存路径
//                                    ImageIO.write(image, "png", outputFile);
//                                    System.out.println("图片保存成功！");
//                                } catch (IOException e) {
//                                    System.out.println("保存图片失败： " + e.getMessage());
//                                }

                            }
                        });
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

    // 将二进制字符串转换为字节数组
    private static byte[] binaryStringToByteArray(String binaryString) {
        int length = binaryString.length();
        byte[] byteArray = new byte[length / 8];
        for (int i = 0; i < length; i += 8) {
            String byteString = binaryString.substring(i, i + 8);
            byte b = (byte) Integer.parseInt(byteString, 2);
            byteArray[i / 8] = b;
        }
        return byteArray;
    }

    // 将字节数组转换为BufferedImage
    private static BufferedImage bytesToImage(byte[] byteArray) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
            return ImageIO.read(bis);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 保存图像
    private static void saveImage(BufferedImage image, String fileName) {
        try {
            File output = new File(fileName);
            ImageIO.write(image, "jpg", output);
            System.out.println("图像已保存为：" + output.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        MDBUtil rmf = new MDBUtil();
        File mdbFile = new File("/Users/street/Desktop/公园建库.mdb");
        List<Map> rstMap = rmf.readFileACCESS(mdbFile);
        System.out.println("rstMap = " + rstMap);
    }

    private static byte[] getByteArray(String binaryString) {
        int length = binaryString.length() / 8;
        byte[] byteArray = new byte[length];

        for (int i = 0; i < length; i++) {
            String byteString = binaryString.substring(i * 8, (i + 1) * 8);
            byteArray[i] = Byte.parseByte(byteString);
        }

        return byteArray;
    }

    // byte 转 string (十进制)
    public static String bytes2hexDisplayDec(byte[] bytes) {
        return Arrays.toString(bytes);
    }

    // byte 转 string (十六进制)
    public static String bytes2hexDisplayHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String tmp;
        sb.append("[");
        for (byte b : bytes) {
            // 将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制
            tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() == 1) {
                tmp = "0" + tmp;//只有一位的前面补个0
            }
            sb.append(tmp).append(" ");//每个字节用空格断开
        }
        sb.delete(sb.length() - 1, sb.length());//删除最后一个字节后面对于的空格
        sb.append("]");
        return sb.toString();
    }


//    public static void main(String[] args) {
//        String binaryData = "0100100001101001"; // 要转换的二进制数据
//
//        // 将二进制数据分成8位一组
//        int chunks = binaryData.length() / 8;
//        String[] binaryChunks = new String[chunks];
//        for (int i = 0; i < chunks; i++) {
//            binaryChunks[i] = binaryData.substring(i * 8, (i + 1) * 8);
//        }
//
//        // 将每个8位二进制转换为字符
//        StringBuilder textBuilder = new StringBuilder();
//        for (String chunk : binaryChunks) {
//            int decimalValue = Integer.parseInt(chunk, 2);
//            char character = (char) decimalValue;
//            textBuilder.append(character);
//        }
//
//        String textData = textBuilder.toString();
//        System.out.println("转换后的文本：" + textData);
//    }


//    public static void main(String[] args) {
//        double minGX = 599107600;  // 最小经度
//        double minGY = 1364457431; // 最小纬度
//        double maxGX = 599162283;  // 最大经度
//        double maxGY = 1364492129; // 最大纬度
//
//        // 构造请求URL
//        String url = "http://api.map.baidu.com/geoconv/v1/?coords=" +
//                minGX + "," + minGY + ";" +
//                maxGX + "," + maxGY +
//                "&from=1&to=5&ak=1fd78dbdec551c1c30729d835da0a706";
//
//        try {
//            // 发送HTTP请求
//            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//            connection.setRequestMethod("GET");
//
//            // 解析HTTP响应
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            StringBuilder response = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            reader.close();
//
//            // 解析JSON响应获取转换后的坐标
//            String json = response.toString();
//            // TODO: 解析JSON响应，获取转换后的坐标信息
//            System.out.println(json);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }





        //                                byte[] bytes =(byte[]) v;
////                                byte[] bytes = aByte; // 将文本转换为字节数组
//
//                                StringBuilder binaryBuilder = new StringBuilder();
//                                for (byte b : bytes) {
//                                    int value = b; // 将每个字节转换为整数
//                                    StringBuilder textBuilder = new StringBuilder();
//                                    for (int i = 7; i >= 0; i--) {
//                                        char bit = ((value >> i) & 1) == 1 ? '1' : '0'; // 获取每一位的二进制值
//
//                                        binaryBuilder.append(bit);
//
//                                    }
//                                    binaryBuilder.append(' '); // 为了可读性，每个字节之间添加一个空格
//                                }

//                                // 将二进制文本转换为字节数组
//                                String[] binaryArray = binaryBuilder.toString().split(" ");
//                                byte[] byteArray = new byte[binaryArray.length];
//                                for (int i = 0; i < binaryArray.length; i++) {
//                                    byteArray[i] = (byte) Integer.parseInt(binaryArray[i], 2);
//                                }
//
//                                // 将字节数组转换为字符串
//                                String text = new String(byteArray);
//
//                                System.out.println("转换后的字符串为: " + text); // 输出: abc

//                                String binaryData = binaryBuilder.toString();
//                                int chunks = binaryData.length() / 8;
//                                String[] binaryChunks = new String[chunks];
//                                for (int i = 0; i < chunks; i++) {
//                                    String substring = binaryData.substring(i * 8, (i + 1) * 8);
////                                    int decimal = Integer.parseInt(substring, 2);
////                                    char character = (char) decimal;
////                                    System.out.println(character);
//                                }

//                                System.out.println("转换后的二进制数据：" + binaryBuilder);
//                                StringBuilder text = new StringBuilder();
//                                for (byte aByte : bytes) {
//
////                                    System.out.println(aByte);
////                                    char character = (char) aByte; // 将十进制数值转换为对应的字符
////                                    text.append(character);
//                                }


//                                String base64String = (String) v; // 示例Base64编码字符串
//                                byte[] bytes = Base64.getDecoder().decode(base64String);
//                                String text = new String(bytes);
////                                byte[] bytes =(byte[]) v;
////                                String text = new String(bytes, StandardCharsets.UTF_16LE); // 将字节转换为文本
//////                                String text = new String(bytes);
//                                System.out.println(text);
    }