package com.example.download_manager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sd.lib.dldmgr.DownloadInfo;
import com.sd.lib.dldmgr.DownloadManager;
import com.sd.lib.dldmgr.FDownloadManager;

import java.io.File;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String URL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_download).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FDownloadManager.getDefault().addTask(URL);
            }
        });

        FDownloadManager.getDefault().addCallback(mDownloadCallback);
    }

    private final DownloadManager.Callback mDownloadCallback = new DownloadManager.Callback()
    {
        @Override
        public void onPrepare(DownloadInfo info)
        {
            Log.i(TAG, "onPrepare:" + info.getUrl());
        }

        @Override
        public void onProgress(DownloadInfo info)
        {
            Log.i(TAG, "onProgress:" + info.getTransmitParam());
        }

        @Override
        public void onSuccess(DownloadInfo info, File file)
        {
            Log.i(TAG, "onSuccess:" + info.getUrl() + "\r\n"
                    + " file:" + file.getAbsolutePath());
        }

        @Override
        public void onError(DownloadInfo info)
        {
            Log.e(TAG, "onError:" + info.getError());
        }
    };

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        FDownloadManager.getDefault().removeCallback(mDownloadCallback);
    }
}
