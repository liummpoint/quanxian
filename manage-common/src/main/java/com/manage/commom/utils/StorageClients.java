package com.manage.commom.utils;


import org.csource.common.*;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;

public class StorageClients extends StorageClient {

    public static final org.csource.common.Base64 base64 = new org.csource.common.Base64('-', '_', '.', 0);
    protected TrackerServer trackerServer;
    protected StorageServer storageServer;
    protected byte errno;

    public StorageClients() {
        this.trackerServer = null;
        this.storageServer = null;
    }

    public StorageClients(TrackerServer trackerServer, StorageServer storageServer) {
        this.trackerServer = trackerServer;
        this.storageServer = storageServer;
    }
    public String[] uploadFile(String group_name,String local_filename, String file_ext_name, NameValuePair[] meta_list) throws IOException, MyException {
        return this.upload_file(group_name, local_filename, file_ext_name, meta_list);
    }
}
