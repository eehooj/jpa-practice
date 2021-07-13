package me.torissi.jpapractice.common.enumerate;

public enum NationType {

  KOREA("Korea"),
  AMERICA("America"),
  CHINA("China"),
  JAPAN("Japan");

  private final String value;

  NationType(String value) {
    this.value = value;
  }
}
