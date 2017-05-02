package com.hubert.madiffgiphysample.gifview;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Hubert on 02.05.2017.
 */

public interface TrendingGiphyApi {

  @GET("trending")
  Observable<GifResult> getGifs(@Query("api_key") String apiKey, @Query("limit") int limit);
}
