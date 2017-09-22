package com.mo3athi.stadiumsmaps;

/**
 * Created by Mo3athi on 9/20/2017.
 */

public class StadiumModel {

  private String name;
  private String hours, lat, lng;
  private String fee;

  public StadiumModel(String name, String hours, String fee, String lat, String lng) {
    this.name = name;
    this.hours = hours;
    this.lat = lat;
    this.lng = lng;
    this.fee = fee;
  }

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getLng() {
    return lng;
  }

  public void setLng(String lng) {
    this.lng = lng;
  }

  public String getHours() {
    return hours;
  }

  public void setHours(String hours) {
    this.hours = hours;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFee() {
    return fee;
  }

  public void setFee(String fee) {
    this.fee = fee;
  }
}
