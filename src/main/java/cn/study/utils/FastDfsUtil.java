package cn.study.utils;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class FastDfsUtil {

    /**
     * 加载客户端连接的配置文件
     */
    public static String conf_filename = "client.conf";

    /**
     * 字节流上传图片
     * @param byteFile 字节数组
     * @param extFile  扩展名
     */
    public static String fileUpload(byte[] byteFile, String extFile) {
        // 拼接服务区的文件路径
        StringBuffer sbPath = new StringBuffer();
        sbPath.append("http://192.168.154.110:8080");
        try {
            // 初始化文件资源
            ClientGlobal.init(conf_filename);

            // 链接FastDFS服务器，创建tracker和Stroage
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer,
                    storageServer);

            //利用字节流上传文件
            String[] strings = storageClient.upload_file(byteFile, extFile, null);

            for (String string : strings) {
                sbPath.append("/" + string);
                System.out.println(string);
            }
            // 全路径
            System.out.println(sbPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sbPath.toString();
    }

    /**
     * 删除fastdfs上的存储
     * @param fileName fastdfs 的路径
     * @return int 状态码
     */
    public static int delete(String fileName) {
        int num=0;
        try {
            ClientGlobal.init(conf_filename);

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer,
                    storageServer);
            num = storageClient.delete_file("group1", fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }


}
