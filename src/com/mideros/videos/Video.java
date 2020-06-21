package com.mideros.videos;

import java.util.List;

/**
 * This class contains the attributes and methods of a video
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 */

public class Video {

	private String url;
	private String title;
	private List<Tag> tagList;

	public Video() {
		super();
	}

	public Video(String url, String title) {
		super();
		this.url = url;
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
}