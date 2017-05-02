package com.hubert.madiffgiphysample.gifview;

import android.support.annotation.Nullable;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Hubert on 02.05.2017.
 */

public class GifViewPresenter implements GifViewMVP.Presenter {

  @Nullable
  private GifViewMVP.View view;
  private Subscription subscription;
  private GifViewMVP.Model model;

  public GifViewPresenter(GifViewMVP.Model model) {
    this.model = model;
  }

  @Override
  public void setView(GifViewMVP.View view) {
    this.view = view;
  }

  @Override
  public void getGifs(String key, final int limit) {
    subscription = model.getGifs(key, limit)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<GifResult>() {
          @Override
          public void onCompleted() {

          }

          @Override
          public void onError(Throwable e) {
            e.printStackTrace();

          }

          @Override
          public void onNext(GifResult gifResult) {
            String[] urls = new String[gifResult.getData().size()];
            int[] height = new int[gifResult.getData().size()];
            for (int i = 0; i < gifResult.getData().size(); i++){
              urls[i] = gifResult.getData().get(i).getImages().getOriginal().getUrl();
              if(i > 0 && i%2 == 1){
                if(height[i-1] > gifResult.getData().get(i).getImages().getOriginal().getHeight()){
                  height[i] = height[i-1];
                } else {
                  height[i] = gifResult.getData().get(i).getImages().getOriginal().getHeight();
                  height[i-1] = height[i];
                }
              } else {
                height[i] = gifResult.getData().get(i).getImages().getOriginal().getHeight();
              }
            }
            if(view != null){
              view.loadGifsFromUrls(urls, height);
            }
          }
        });
  }

  @Override
  public void rxUnsubscribe() {
    if(subscription != null){
      if(!subscription.isUnsubscribed()){
        subscription.unsubscribe();
      }
    }
  }
}
