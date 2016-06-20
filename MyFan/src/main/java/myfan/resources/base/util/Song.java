package myfan.resources.base.util;

public class Song {
	  private String name;
      private String duration;
      private boolean version;
      private boolean type;
      private String video;
      
	public String getName() {
		return name;
	}
	public String getDuration() {
		return duration;
	}
	public boolean isVersion() {
		return version;
	}
	public boolean isType() {
		return type;
	}
	public String getVideo() {
		return video;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public void setVersion(boolean version) {
		this.version = version;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public void setVideo(String video) {
		this.video = video;
	}
      
      

}
