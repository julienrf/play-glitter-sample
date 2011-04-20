package models

case class User(id: Long, name: String)

object User {
  
  def all =
	List(
      User(1, "Julien"),
      User(2, "Paul"),
      User(3, "Christopher")
  	)
  
  def findById(id: Long) =
    all.find(_.id == id)
}
