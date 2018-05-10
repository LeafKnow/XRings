package com.yj.njh.ret.http.retrofit;

import com.blankj.utilcode.util.LogUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitUtils工具类
 *
 * @author niejiahuan
 */
public class RetrofitUtils1 {
    /**
     * 接口地址
     */
    static final String TEST = "http://i.api.murendao.com/api_i1A5o3P_app/";
    static final String RELEASE = "http://hz.chengmi.la/";

    public static final String BASE_URL = TEST;
    public static final int CONNECT_TIME_OUT = 30;//连接超时时长x秒
    public static final int READ_TIME_OUT = 30;//读数据超时时长x秒
    public static final int WRITE_TIME_OUT = 30;//写数据接超时时长x秒
    private static RetrofitUtils1 mInstance = null;

    private RetrofitUtils1() {
    }

    public static RetrofitUtils1 get() {
        if (mInstance == null) {
            synchronized (RetrofitUtils1.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitUtils1();
                }
            }
        }
        return mInstance;
    }

    /**
     * 设置okHttp
     *
     * @author ZhongDaFeng
     */
    private static OkHttpClient okHttpClient() {
        //开启Log
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtils.e("okHttp:" + message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder builder = chain.request().newBuilder();
                        builder.addHeader("platform", "1");
                        if (null!= TokenManager.getInstance().getToken()&&
                                !TokenManager.getInstance().getToken().isEmpty()) {
                            LogUtils.e(TokenManager.getInstance().getToken());
                            builder.addHeader("Authorization", TokenManager.getInstance().getToken());
                            builder.addHeader("returntype", "json");
                        } else {
                            builder.addHeader("Authorization", "");
                            builder.addHeader("returntype", "json");
                        }
                        return chain.proceed(builder.build());
                    }
                })
                .build();
        return client;
    }

    /**
     * 获取Retrofit
     *
     * @author ZhongDaFeng
     */
    public Retrofit retrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

}
