package exeress


trait Binary
case object Zero extends Binary
case object One extends Binary
case class O(b: Binary) extends Binary
case class I(b: Binary) extends Binary


object Binart {

}
