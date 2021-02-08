package com.demo.util;

public interface DownloadListener {
    /**
     * 通知下载进度
     * @param progress
     */
    void onProgress(int progress);

    /**
     * 通知下载成功
     */
    void onSuccess();

    /**
     * 通知下载失败
     */
    void onFailed();

    /**
     * 通知下载暂停
     */
    void onPuased();

    /**
     * 通知下载取消
     */
    void onCanceled();
}
