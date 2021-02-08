package com.demo.util;

import android.util.Log;

import com.demo.model.App;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {

    /**
     * OkHttp发送请求
     * @param address
     * @param callback
     */
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address).build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * HttpURLConnection发送请求
     * @param address
     * @param listener
     */
    public static void sendHttpRequest(final String address, final HttpCallbackListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null){
                        response.append(line);
                    }
                    if(listener != null){
                        //回掉onFinish()方法
                        listener.onFinish(response.toString());
                    }
                } catch (IOException e) {
                    if (listener != null) {
                        //回调onError()方法
                        listener.onError(e);
                    }
                } finally {
                    if(connection != null){
                        connection.disconnect();
                    }
                }
            }
        }).start();


    }

    /**
     * GSON解析
     * @param jsonData
     */
    private void parseJSONWithGSON(String jsonData){
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(jsonData, new TypeToken<List<App>>(){}.getType());
        for(App app : appList){
            Log.d("TAG", "id is "+app.getId());
            Log.d("TAG", "name is "+app.getName());
            Log.d("TAG", "version is "+app.getVersion());
        }
    }

    /**
     * JSONObject解析
     * @param jsonData
     */
    private void parseJSONWithJSONObject(String jsonData){
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for(int i=0; i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                Log.d("TAG", "id is "+id);
                Log.d("TAG", "name is "+name);
                Log.d("TAG", "version is "+version);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
