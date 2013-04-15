package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
	def send = Action(parse.json){ request =>
		val text = request.body.\("text").asOpt[String]
		text match {
			case Some(text) => {
				Message(text).send
				Ok("send Ok")
			}
			case _ => BadRequest("invalid json")
		}
	}  
}