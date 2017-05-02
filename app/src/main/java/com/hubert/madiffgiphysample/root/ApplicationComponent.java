package com.hubert.madiffgiphysample.root;

import com.hubert.madiffgiphysample.gifview.ApiModule;
import com.hubert.madiffgiphysample.gifview.GifViewActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Hubert on 02.05.2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {
  void inject(GifViewActivity target);
}
