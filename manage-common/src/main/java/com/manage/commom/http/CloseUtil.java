package com.manage.commom.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.ZipOutputStream;

public class CloseUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CloseUtil.class);

    public static void close(Object... objs) {

        try {
            if (objs != null) {
                for (Object obj : objs) {
                    if (obj != null) {
                        if (obj instanceof Closeable) {
                            try {
                                Closeable closeable = (Closeable) obj;
                                closeable.close();
                            } catch (Exception e) {
                                LOGGER.error("流关闭失败", e);
                            }
                        } else if (obj instanceof Socket) {
                            try {
                                Socket socket = (Socket) obj;
                                socket.close();
                            } catch (Exception e) {
                                LOGGER.error("流关闭失败", e);
                            }
                        } else if (obj instanceof ServerSocket) {
                            try {
                                ServerSocket serverSocket = (ServerSocket) obj;
                                serverSocket.close();
                            } catch (Exception e) {
                                LOGGER.error("流关闭失败", e);
                            }
                        } else if (obj instanceof ZipOutputStream) {
                            try {
                                ZipOutputStream zipOutputStream = (ZipOutputStream) obj;
                                zipOutputStream.close();
                            } catch (Exception e) {
                                LOGGER.error("流关闭失败", e);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("流关闭失败", e);
        }

    }

}
