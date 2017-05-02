package com.hubert.madiffgiphysample.gifview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.hubert.madiffgiphysample.R;
import com.hubert.madiffgiphysample.root.MadiffGiphySampleApplication;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Hubert on 02.05.2017.
 */

public class GifViewActivity extends AppCompatActivity implements GifViewMVP.View {

  @BindView(R.id.gridview)
  public GridView gridView;

  @Inject GifViewMVP.Presenter presenter;

  private Unbinder unbinder;
  private GifAdapter gifAdapter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ((MadiffGiphySampleApplication) getApplication()).getComponent().inject(this);
    unbinder = ButterKnife.bind(this);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    unbinder.unbind();
    presenter.rxUnsubscribe();
  }

  @Override
  protected void onResume() {
    super.onResume();
    presenter.setView(this);
    presenter.getGifs(getString(R.string.api_key), getResources().getInteger(R.integer.gifs_limit));
  }

  @Override
  public void loadGifsFromUrls(String[] urls, int[] height) {
    gifAdapter = new GifAdapter(this, urls, height);
    gridView.setAdapter(gifAdapter);
  }
}
