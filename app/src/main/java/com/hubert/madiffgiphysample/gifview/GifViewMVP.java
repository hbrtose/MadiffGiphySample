package com.hubert.madiffgiphysample.gifview;

import rx.Observable;

/**
 * Created by Hubert on 02.05.2017.
 */

public interface GifViewMVP {

  interface View {
    void loadGifsFromUrls(String[] urls, int[] height);
  }

  interface Presenter {
    void setView(GifViewMVP.View view);
    void getGifs(String key, int limit);
    void rxUnsubscribe();
  }

  interface Model {
    Observable<GifResult> getGifs(String key, int limit);
  }
}
