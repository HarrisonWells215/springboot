package com.springboot.provider;

import com.springboot.datetansor.AccessTokenDTO;
import com.springboot.datetansor.User;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassNameProvider
 * @Date2019-11-3020:54
 **/
@Component
public class Provider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public User getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string =response.body().string();
            User user = JSON.parseObject(string,User.class);
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


