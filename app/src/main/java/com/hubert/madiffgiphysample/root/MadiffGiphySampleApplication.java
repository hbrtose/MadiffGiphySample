package com.hubert.madiffgiphysample.root;

import android.app.Application;

import com.hubert.madiffgiphysample.gifview.ApiModule;

/**
 * Created by Hubert on 02.05.2017.
 */

public class MadiffGiphySampleApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .apiModule(new ApiModule())
        .build();
  }

  public ApplicationComponent getComponent(){
    return applicationComponent;
  }
}
