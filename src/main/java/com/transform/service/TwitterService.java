package com.transform.service;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.MediaEntity;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.URLEntity;
import twitter4j.conf.ConfigurationBuilder;

@SuppressWarnings("serial")
public class TwitterService implements Serializable {
	private static final Logger logger = LoggerFactory.getLogger(TwitterService.class);
	private static String text;

	public static void main(String[] args) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("CE29Wt7MshUG6B5ei07xPam4l")
				.setOAuthConsumerSecret("sh8hxBoO91GrPcB80baOWs02be7NnN33EB1fdEzRhGLeZQ85gO")
				.setOAuthAccessToken("3436474612-1OMz20MOv83cE5RJLpq6VYzgozpygSGeYky4PcH")
				.setOAuthAccessTokenSecret("CzvQ2jq3Z03LQoKvkijvYOpxNIFyPvZjOWcCDrnFZfZpQ");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		// Twitter twitter = TwitterFactory.getSingleton();

		Paging paging = new Paging(1, 100);

		try {

			List<Status> statuses = twitter.getUserTimeline("AlArabiya", paging);
			for (Status status : statuses) {
				logger.info("====================================");
				text = status.getText();
				String linkifiedMyText = getLinkifiedMyText();
				replaceWithLinks(status);
				logger.info("@" + status.getUser().getScreenName() + " - " + text);
				logger.info("links are: " + linkifiedMyText);

				for (URLEntity entity : status.getURLEntities()) {
					logger.info("URL is: " + entity.getExpandedURL());
				}
				MediaEntity[] mediaEntities = status.getMediaEntities();
				for (MediaEntity mediaEntity : mediaEntities) {
					logger.info("Image url is: " + mediaEntity.getMediaURL());
				}
			}

			// ResponseList<User> searchUsers = twitter.searchUsers(query, 1);

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void replaceWithLinks(Status status) {
		int i = 0;
		for (URLEntity entity : status.getURLEntities()) {
			text = text.replaceFirst("_LINK_", entity.getExpandedURL());
			i++;
		}
		text = text.replaceAll("_LINK_", "");

	}

	public static String getLinkifiedMyText() {
		StringBuffer sb = new StringBuffer();
		try {
			Pattern pat = Pattern.compile("(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",
					Pattern.DOTALL);
			Matcher matcher = pat.matcher(text);
			while (matcher.find()) {
				sb.append(matcher.group());
				text = matcher.replaceAll("_LINK_");
				sb.append("|");
			}
		} catch (Exception e) {

		}
		return sb.toString();
	}

}
