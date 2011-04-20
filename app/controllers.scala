package controllers

import play._
import play.mvc._
import play.mvc.results.Result

import models.User
import views.Templates

object Application extends Controller with GlitterController {
  
  def index = Glitter(Templates.index(User.all))
  
  def show(id: Int) = {
    User.findById(id).map( (user: User) =>
      Glitter(Templates.show(user))
    ).getOrElse(NotFound("No such user"))
  }
}
