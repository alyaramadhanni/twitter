/**
 * @(#)NamexTweet.java
 *
 *
 * @author 
 * @version 1.00 2019/5/31
 */
import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
private final static String CONSUMER_KEY = "EhVIXWBE1qiu1oQYwOznys1sp";
    private final static String CONSUMER_KEY_SECRET = "wCls1qIXmJ9krrVpVPaMNOxRLJmwCGgODSTklazLfs3CFqVE6w";
    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hallo Twitter");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "zcxgHncHuIULeW0ZK9vSfUUKKW9vU22H2dac0jJtCoKbZ";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "2359189639-CCZ7G9EUimgPwjAJ6m85Fzxd4ivOlGBynx9N23H";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
    
    
}