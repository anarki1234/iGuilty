package com.klisly.iguilty.bean;

public class GuiltyEntry {
	private String uid;
	private String avatar;
	private String nickname;
	private String guiltyId;
	private String contenText;
	private String contentAudio;
	private String contentImage;
	private int praise;

	public GuiltyEntry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GuiltyEntry(String uid, String avatar,
			String nickname,  String guiltyId,String contenText, String contentAudio,
			String contentImage, int praise) {
		super();
		this.uid = uid;
		this.avatar = avatar;
		this.guiltyId = guiltyId;
		this.nickname = nickname;
		this.contenText = contenText;
		this.contentAudio = contentAudio;
		this.contentImage = contentImage;
		this.praise = praise;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getGuiltyId() {
		return guiltyId;
	}

	public void setGuiltyId(String guiltyId) {
		this.guiltyId = guiltyId;
	}

	

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContenText() {
		return contenText;
	}

	public void setContenText(String contenText) {
		this.contenText = contenText;
	}

	public String getContentAudio() {
		return contentAudio;
	}

	public void setContentAudio(String contentAudio) {
		this.contentAudio = contentAudio;
	}

	public String getContentImage() {
		return contentImage;
	}

	public void setContentImage(String contentImage) {
		this.contentImage = contentImage;
	}

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}

}
