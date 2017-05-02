package com.hubert.madiffgiphysample.gifview;

import rx.Observable;

/**
 * Created by Hubert on 02.05.2017.
 */

public class GifViewModel implements GifViewMVP.Model {

  private TrendingGiphyApi trendingGiphyApi;

  public GifViewModel(TrendingGiphyApi trendingGiphyApi) {
    this.trendingGiphyApi = trendingGiphyApi;
  }

  @Override
  public Observable<GifResult> getGifs(String key, int limit) {
    return trendingGiphyApi.getGifs(key, limit);
  }
}
