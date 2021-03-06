package com.sd.lib.dldmgr.executor;

import com.sd.lib.dldmgr.DownloadRequest;
import com.sd.lib.dldmgr.DownloadUpdater;

import java.io.File;

public interface DownloadExecutor
{
    /**
     * 提交下载任务
     *
     * @param request 下载请求
     * @param file    要保存的下载文件
     * @param updater 下载信息更新对象
     * @return true-提交成功，false-提交失败
     */
    boolean submit(DownloadRequest request, File file, DownloadUpdater updater);

    /**
     * 取消下载任务
     *
     * @param url
     * @return true-任务取消
     */
    boolean cancel(String url);
}
