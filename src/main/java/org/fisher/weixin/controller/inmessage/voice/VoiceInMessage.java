package org.fisher.weixin.controller.inmessage.voice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.fisher.weixin.controller.inmessage.InMessage;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class VoiceInMessage extends InMessage {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="Voice")
	private String voice;
	@XmlElement(name="MediaId")
	private String mediaId;
	
	public String getVoice() {
		return voice;
	}
	public void setVoice(String voice) {
		this.voice = voice;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	@Override
	public String toString() {
		return "VoiceInMessage [voice=" + voice + ", mediaId=" + mediaId + ", getToUserName()=" + getToUserName()
				+ ", getFromUserName()=" + getFromUserName() + ", getCreateTime()=" + getCreateTime()
				+ ", getMsgType()=" + getMsgType() + ", getMsgId()=" + getMsgId() + "]";
	}

}
