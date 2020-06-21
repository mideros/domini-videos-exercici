package com.mideros.videos;

/**
 * This class contains the attributes and methods of a tag
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 */

public class Tag {

	private String tagTxt;

	public Tag() {
	}

	public Tag(String tagTxt) {
		super();
		this.tagTxt = tagTxt;
	}

	public String getTagTxt() {
		return tagTxt;
	}

	public void setTagTxt(String tagTxt) {
		this.tagTxt = tagTxt;
	}
}