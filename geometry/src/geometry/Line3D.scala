package geometry

class Line3D( val head : Vector3D, val tail : Vector3D ) {

  /**
   * create a vector that points from
   * the tail to the head of this line
  */
  def vector : Vector3D = head - tail 

  /**
   * compute the length of this line
  */
  def length : Double = vector.magnitude

  /**
   * produce a vector of length one
   * that points from the tail toward the head
  */
  def direction : Vector3D = vector.normalize

  /**
   * create a string that describes this
   * line in the SVG (Scalable Vector Graphics)
   * language
  */
  def midpoint : Vector3D = (head + tail).scale(0.5)
  /**
   * finds the mipoint of a line scaled by 0.5
   * 
   */
  def svg : String =
    "<line x1= \"" + head.x + "\" " + 
    "y1= \"" + head.y + "\" " +
    "x2= \"" + tail.x + "\" " +
    "y2= \"" + tail.y + "\" " +
    "\n\t" +
    "style=\"stroke:rgb(0,0,0);stroke-width:2\"/>"
    
   

  override def toString : String = "(" + head + "," + tail + ")"

} // Line3D
