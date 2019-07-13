package com.sd.lib.dldmgr;

import java.io.File;

public interface DownloadManager
{
    String TAG = DownloadManager.class.getName();

    /**
     * 添加回调
     *
     * @param callback
     */
    void addCallback(Callback callback);

    /**
     * 移除回调
     *
     * @param callback
     */
    void removeCallback(Callback callback);

    /**
     * 返回url对应的文件
     *
     * @param url
     * @return null-文件不存在，不为null下载文件存在
     */
    File getDownloadFile(String url);

    /**
     * 返回下载信息
     *
     * @param url
     * @return
     */
    DownloadInfo getDownloadInfo(String url);

    /**
     * 删除所有临时文件(下载中的临时文件不会被删除)
     */
    void deleteAllTempFile();

    /**
     * 添加下载任务
     *
     * @param url
     * @return true-任务被添加
     */
    boolean addTask(String url);

    /**
     * 取消下载任务
     *
     * @param url
     * @return true-任务被取消
     */
    boolean cancelTask(String url);

    interface Callback
    {
        void onPrepare(DownloadInfo info);

        void onProgress(DownloadInfo info);

        void onSuccess(DownloadInfo info, File file);

        void onError(DownloadInfo info);
    }
}
