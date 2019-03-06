package com.manage.commom.utils;

import java.io.File;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * @author dudianbo
 * @ClassName: FastDFSClient
 * @Description: ${DESCRIPTION}
 * @date 2018/3/8
 */
public class FastDFSClient {
    private static String clientFileName = "fdfs_client.conf";
    
    private static String imageGroup = "group4" ;

    static {
        try {
            String classPath = (new File(FastDFSClient.class.getResource("/").getFile())).getCanonicalPath();
            String configFilePath = classPath + File.separator + clientFileName;
            ClientGlobal.init(configFilePath);
            System.out.println(configFilePath);
        } catch (Exception e) {
        	e.printStackTrace();
           // logger.error("fastDfs文件服务器初始化异常",e);
        }
    }

    /**
     * 上传文件方法
     * <p>Title: uploadFile</p>
     * <p>Description: </p>
     * @param fileName 文件全路径
     * @param extName 文件扩展名，不包含（.）
     * @param metas 文件扩展信息
     * @return
     * @throws Exception
     */
    public static String uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception {
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, (StorageServer)storageServer);
        String result[] = storageClient.upload_file(fileName, extName, metas);
        return result[0]+"/"+result[1];
    }


    public static String uploadFile(String fileName) throws Exception {
        return uploadFile(fileName, null, null);
    }

    public static String uploadFile(String fileName, String extName) throws Exception {
        return uploadFile(fileName, extName, null);
    }

    /**
     * 上传文件方法 带group
     * <p>Title: uploadFile</p>
     * <p>Description: </p>
     * @param groupName group名称
     * @param fileName 文件全路径
     * @param extName 文件扩展名，不包含（.）
     * @param metas 文件扩展信息
     * @return
     * @throws Exception
     */
    public static String uploadFile(String groupName,String fileName, String extName, NameValuePair[] metas) throws Exception {
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClients storageClient = new StorageClients(trackerServer, (StorageServer)storageServer);
        String result[] = storageClient.uploadFile(groupName,fileName, extName, metas);
        return result[0]+"/"+result[1];
    }

    
    public static String uploadFileByGroup(String groupName,String fileName) throws Exception {
        return uploadFile(groupName,fileName, null, null);
    }
    /**
     * 上传文件方法
     * <p>Title: uploadFile</p>
     * <p>Description: </p>
     * @param fileContent 文件的内容，字节数组
     * @param extName 文件扩展名
     * @param metas 文件扩展信息
     * @return
     * @throws Exception
     */
    public static String uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception {
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, (StorageServer)storageServer);
        String result[] = storageClient.upload_file(fileContent, extName, metas);
        return result[0]+"/"+result[1];
    }

    public static String uploadFile(byte[] fileContent) throws Exception {
        return uploadFile(fileContent, null, null);
    }

    public static String uploadFile(byte[] fileContent, String extName) throws Exception {
        return uploadFile(fileContent, extName, null);
    }
    public static byte[] download_bytes(String groupName, String remoteFilename) throws Exception {
        byte[] b=null;
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, (StorageServer)storageServer);
        b = storageClient.download_file(groupName,remoteFilename);
        return b;
    }

    
    public static String[] uploadFileByDefaultGroup(byte[] fileContent, String extName) throws Exception {
        return uploadFile(imageGroup,fileContent, extName, null);
    }
    public static String uploadFileByByteAndGroup(byte[] fileContent, String groupName) throws Exception {
        String[] result= uploadFile(groupName,fileContent, null, null);
        return result[0]+"/"+result[1];
    }
    
    public static String[] uploadFile(String groupName , byte[] fileContent, String extName, NameValuePair[] metas) throws Exception {
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, (StorageServer)storageServer);
        String result[] = storageClient.upload_file(groupName,fileContent, extName, metas);
        return result;
    }
    
//    public static void main(String[] args) {
//    	byte[] b = download_bytes("group2","M00/00/00/rBFjYlqp4NSAbm-tAALPsmbAVXY757.pdf");
//        System.out.println(b);
//    }
}
