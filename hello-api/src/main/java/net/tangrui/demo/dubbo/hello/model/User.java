package net.tangrui.demo.dubbo.hello.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable {

  private String id;
  private String name;
  private Date createdTime;

  public String getId() {
    return this.id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public Date getCreatedTime() {
    return this.createdTime;
  }
  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  @Override
  public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    if (this.getCreatedTime() != null) {
      return String.format("%s (%s)", this.getName(), sdf.format(this.getCreatedTime()));
    }

    return String.format("%s (N/A)", this.getName());
  }

}
