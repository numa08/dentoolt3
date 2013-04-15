package controllers

import play.api._
import play.api.mvc._
import net.numa08.dentoolt.model._

object Application extends Controller {
	def send = Action(parse.json){ request =>
		val text = request.body.\("text").asOpt[String]
		val status = text match {
			case Some(text) => {
				Message(text).send
			}
			case _ => BadRequest("bad")
		}
		status match {
			case Some(status) => Ok("send ok")
			case _ => BadRequest("invalid request")
		}
		
	}  
}