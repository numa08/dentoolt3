package net.numa08.dentoolt.model

case class Message(text:String) {
<<<<<<< HEAD
	def send = {
		val config = new ConfigurationBuilder()
						.setOAuthConsumerKey(TwitterAuth.ConsumerKey)
						.setOAuthConsumerSecret(TwitterAuth.ConsumerSecret)
						.setOAuthAccessToken(TwitterAuth.AccessToken)
						.setOAuthAccessTokenSecret(TwitterAuth.AccessTokenSecret)
						.build()
		val twitter = new TwitterFactory(config).getInstance
		try { 
		  Some(twitter.updateStatus(text))
		} catch {
		  case _ => None
		}
	}
}

object TwitterAuth {
	val ConsumerKey	= "consumer_key"
	val	ConsumerSecret = "consumer_secret"
	val	AccessToken = "access_token"
	val	AccessTokenSecret = "access_token_secret"
}