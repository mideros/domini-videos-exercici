package com.mideros.videos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class contains the necessary methods to add a new video and one or more
 * tags.
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 */

public class ServiceVideo {

	private Video video;
	private Scanner lector;
	private DataValidation validObj;
	private List<Tag> tagList;
	private Tag tag;
	private boolean goTags;

	public ServiceVideo() {
		super();
		lector = new Scanner(System.in);
		validObj = new DataValidation();
	}

	public Video addNewVideo() {

		video = new Video();
		tagList = new ArrayList<Tag>();

		System.out.println("---Video---");

		String title = addTitle();
		boolean validateTitle = validObj.verifyData(title);

		while (!validateTitle) {
			title = addTitle();
			validateTitle = validObj.verifyData(title);
		}
		video.setTitle(title);

		String url = addUrl();
		boolean validateUrl = validObj.verifyData(url);

		while (!validateUrl) {
			url = addUrl();
			validateUrl = validObj.verifyData(url);
		}
		video.setUrl(url);

		tagList = addListTag();
		goTags = moreTags();

		while (goTags) {

			tagList = addListTag();
			goTags = moreTags();
		}

		video.setTagList(tagList);
		return video;
	}

	public String addTitle() {

		String title = "";
		System.out.println("Please, write a title: ");
		title = lector.nextLine();
		return title;
	}

	public String addUrl() {

		String url = "";
		System.out.println("Please, write the url of the video: ");
		url = lector.nextLine();
		return url;
	}

	public String addTag() {

		String tagText = "";
		System.out.println("Please, write a tag: ");
		tagText = lector.nextLine();
		return tagText;
	}

	public String addAnotherTag() {

		String answer = "";
		System.out.println("Do you want to add another tag? Yes or no");
		answer = lector.nextLine().toLowerCase();
		return answer;
	}

	public List<Tag> addListTag() {

		String tagT = "";
		boolean validateTag;
		tag = new Tag();

		tagT = addTag();
		validateTag = validObj.verifyData(tagT);

		if (!validateTag) {
			tagT = addTag();
			validateTag = validObj.verifyData(tagT);
		}
		tag.setTagTxt(tagT);
		tagList.add(tag);
		return tagList;
	}

	public boolean moreTags() {

		String aTag = addAnotherTag();
		boolean more = validObj.verifyAnswer(aTag);
		boolean verifyTag = false;

		while (!more) {
			aTag = addAnotherTag();
			more = validObj.verifyAnswer(aTag);
		}

		if (aTag.contentEquals("yes")) {
			verifyTag = true;
		} else {
			if (aTag.contentEquals("no")) {
				verifyTag = false;
			}
		}
		return verifyTag;
	}
}