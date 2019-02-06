package co.com.devco.googlesuite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class YoutubeResultsPage {
	
	public static final Target LIST_OF_VIDEOS = Target.the("List of video results").locatedBy("//div[@id='contents']/ytd-video-renderer");

}
