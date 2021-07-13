package me.torissi.jpapractice.common.enumerate;

public enum BrowserType {

  CHROME("Chrome"),
  SAFARI("Safari"),
  EDGE("Edge"),
  FIREFOX("Firefox"),
  BRAVE("Brave"),
  ETC("ETC");

  private final String value;

  BrowserType(String value) {
    this.value = value;
  }
}
