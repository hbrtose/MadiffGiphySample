package com.hubert.madiffgiphysample.gifview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GifResult {

  @SerializedName("data")
  @Expose
  private List<GifsData> data;

  public GifResult(List<GifsData> data) {
    this.data = data;
  }

  public GifResult() {
  }

  public List<GifsData> getData() {
    return data;
  }

  public void setData(List<GifsData> data) {
    this.data = data;
  }

  public class GifsData {

    @SerializedName("images")
    @Expose
    private GifImages images;

    public GifsData(GifImages images) {
      this.images = images;
    }

    public GifsData() {
    }

    public GifImages getImages() {
      return images;
    }

    public void setImages(GifImages images) {
      this.images = images;
    }
  }

  public class GifImages {

    @SerializedName("original")
    @Expose
    private Original original;

    public GifImages(Original original) {
      this.original = original;
    }

    public GifImages() {
    }

    public Original getOriginal() {
      return original;
    }

    public void setOriginal(Original original) {
      this.original = original;
    }
  }

  public class Original {

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("height")
    @Expose
    private int height;

    public Original(String url, int height) {
      this.url = url;
      this.height = height;
    }

    public Original() {
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public int getHeight() {
      return height;
    }

    public void setHeight(int height) {
      this.height = height;
    }
  }
}
