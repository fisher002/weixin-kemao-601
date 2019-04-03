package org.fisher.weixin.controller.inmessage.video;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.fisher.weixin.controller.inmessage.InMessage;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class VideoInMessage extends InMessage{

	private static final long serialVersionUID = 1L;
	private String video;
	@XmlElement(name="MediaId")
	private String mediaId;
	private String thumbmediaId;
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getThumbmediaId() {
		return thumbmediaId;
	}
	public void setThumbmediaId(String thumbmediaId) {
		this.thumbmediaId = thumbmediaId;
	}
	@Override
	public String toString() {
		return "VideoInMessage [video=" + video + ", mediaId=" + mediaId + ", thumbmediaId=" + thumbmediaId
				+ ", getToUserName()=" + getToUserName() + ", getFromUserName()=" + getFromUserName()
				+ ", getCreateTime()=" + getCreateTime() + ", getMsgType()=" + getMsgType() + ", getMsgId()="
				+ getMsgId() + "]";
	}

}
