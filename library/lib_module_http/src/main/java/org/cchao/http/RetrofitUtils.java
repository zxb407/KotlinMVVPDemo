package org.cchao.http;

import android.text.TextUtils;


import java.util.concurrent.TimeUnit;

import com.blankj.utilcode.util.LogUtils;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author cchen6
 * @Date on 2019/8/2
 * @Description
 */
public class RetrofitUtils {
    private static final Retrofit RETROFIT;

    public static String BASE_URL = "https://www.veryvoga.com/en/";
    public static String BASE_APP_URL = "https://app.veryvoga.com/en/";
    static final String CONNECT_TIMEOUT = "CONNECT_TIMEOUT";
    static final String READ_TIMEOUT = "READ_TIMEOUT";
    static final String WRITE_TIMEOUT = "WRITE_TIMEOUT";

    static {

        OkHttpClient.Builder okHttpBuild = new OkHttpClient.Builder();

        okHttpBuild.interceptors().add(chain -> {
            Request request = chain.request();
            int connectTimeout = chain.connectTimeoutMillis();
            int readTimeout = chain.readTimeoutMillis();
            int writeTimeout = chain.writeTimeoutMillis();
            String connectTimeoutNew = request.header(CONNECT_TIMEOUT);
            String readTimeoutNew = request.header(READ_TIMEOUT);
            String writeTimeoutNew = request.header(WRITE_TIMEOUT);
            if (!TextUtils.isEmpty(connectTimeoutNew)) {
                connectTimeout = Integer.valueOf(connectTimeoutNew);
            }
            if (!TextUtils.isEmpty(readTimeoutNew)) {
                readTimeout = Integer.valueOf(readTimeoutNew);
            }
            if (!TextUtils.isEmpty(writeTimeoutNew)) {
                writeTimeout = Integer.valueOf(writeTimeoutNew);
            }
            request = chain.request()
                    .newBuilder()
                    .removeHeader(CONNECT_TIMEOUT)
                    .removeHeader(WRITE_TIMEOUT)
                    .removeHeader(READ_TIMEOUT)
                    .build();
            Response response = chain
                    .withConnectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                    .withReadTimeout(readTimeout, TimeUnit.MILLISECONDS)
                    .withWriteTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                    .proceed(request);
            if (BuildConfig.IS_DEBUG) {
                Buffer buffer = new Buffer();
                BufferedSource source = null;
                ResponseBody responseBody = response.body();
                if (null != request.body() && null != responseBody) {
                    request.body().writeTo(buffer);
                    source = responseBody.source();
                    source.request(Integer.MAX_VALUE);
                }
                LogUtils.dTag("Retrofit", "=========================================================================================");
                LogUtils.dTag("Retrofit", request.method() + "-->" + request.url());
                LogUtils.dTag("Retrofit", buffer.readUtf8());
                if (null != source) {
                    LogUtils.dTag("Retrofit", source.buffer().clone().readUtf8());
                }
                LogUtils.dTag("Retrofit", "========================================================================================");
            }
            return response;
        });
        if (BuildConfig.IS_DEBUG) {
            try {
                Class cls = Class.forName("com.facebook.stetho.okhttp3.StethoInterceptor");
                okHttpBuild.addNetworkInterceptor((Interceptor) cls.newInstance());
                okHttpBuild.addInterceptor(getHttpLoggingInterceptor());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        OkHttpClient client = okHttpBuild.readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        RETROFIT = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://www.veryvoga.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private RetrofitUtils() {
        throw new AssertionError("No instances!");
    }

    static <T> T create(Class<T> service) {
        return RETROFIT.create(service);
    }

    private static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> LogUtils.dTag("RxRetrofit", "Retrofit====Message:" + message));
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}

