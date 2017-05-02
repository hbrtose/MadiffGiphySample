package com.hubert.madiffgiphysample.gifview;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hubert on 02.05.2017.
 */

@Module
public class ApiModule {
  public final String BASE_URL = "http://api.giphy.com/v1/stickers/";

  @Provides
  public OkHttpClient provideClient(){
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return new OkHttpClient.Builder().addInterceptor(interceptor).build();
  }

  @Provides
  public Retrofit provideRetrofit(String baseUrl, OkHttpClient client){
    return new Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  @Provides
  public TrendingGiphyApi provideMoreInfoApiService() {
    return provideRetrofit(BASE_URL, provideClient()).create(TrendingGiphyApi.class);
  }

  @Provides
  public GifViewMVP.Presenter provideGifPresenter(GifViewMVP.Model model){
    return new GifViewPresenter(model);
  }

  @Provides
  public GifViewMVP.Model provideGifModel(TrendingGiphyApi trendingGiphyApi){
    return new GifViewModel(trendingGiphyApi);
  }
}
