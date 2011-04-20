package views

import models.User
import glitter._
import play.modules.glitter._

object Layouts {
  def main(content: Xml) =
    html5dtd | 'html %('lang->"fr") :: (
        'head (
            'meta %('charset->"utf-8")
          | 'title :: "Play!-Glitter sample"
          | 'link %('rel->"stylesheet", 'type->"text/css", 'href->"/public/stylesheets/main.css")
          | 'link %('rel->"shortcut icon", 'href->"/public/images/favicon.png")
        )
      | 'body (
            'h1 :: 'a %('href -> @@("Application.index")) :: "Play!-Glitter sample"
          | content
        )
    )
}

object Templates {

  def index(users: Traversable[User]) =
    Layouts.main(
        'h2 :: &("user.list")
      | 'ul :: forM(users)( user =>
          'li :: 'a %('href -> @@("Application.show", 'id->user.id)) :: user.name
        )
    )

  def show(user: User) =
    Layouts.main(
        'h2 :: &("user.hello", user.name)
    )
}
