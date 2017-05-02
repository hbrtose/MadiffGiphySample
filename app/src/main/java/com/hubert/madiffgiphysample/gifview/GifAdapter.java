package com.hubert.madiffgiphysample.gifview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hubert.madiffgiphysample.R;

/**
 * Created by Hubert on 02.05.2017.
 */

public class GifAdapter extends BaseAdapter {

  private Context context;
  private String[] urls;
  private int[] height;

  public GifAdapter(Context c, String[] u, int[] h)
  {
    context = c;
    urls = u;
    height = h;
  }

  public int getCount() {
    return urls.length;
  }

  public Object getItem(int position) {
    return position;
  }

  public long getItemId(int position) {
    return position;
  }

  public View getView(int position, View convertView, ViewGroup parent) {
    ImageView imageView;
    if (convertView == null) {
      imageView = new ImageView(context);
      imageView.setLayoutParams(new GridView.LayoutParams(500, height[position]));
      imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      imageView.setPadding(5, 5, 5, 5);
    } else {
      imageView = (ImageView) convertView;
    }
    Glide
        .with(context)
        .load(urls[position])
        .asGif()
        .error(R.mipmap.ic_launcher)
        .into(imageView);
    return imageView;
  }

}
