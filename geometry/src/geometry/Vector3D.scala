package geometry

class Vector3D( val x : Double, val y : Double, val z : Double ) {

  /**
   * add another vector to this vector
   * result is a new vector --- the sum
  */
  def +( v : Vector3D ) : Vector3D = 
    new Vector3D( x + v.x, y + v.y, z + v.z )

  /**
   * subtract another vector from this vector
   * result is a new vector --- the difference
  */
  def -( v : Vector3D ) : Vector3D = 
    new Vector3D( x - v.x, y - v.y, z - v.z )

  /**
   * create a new vector that has the same direction
   * as this vector but a different length
  */
  def scale( factor : Double ) : Vector3D =
    new Vector3D( factor * x, factor * y, factor * z )

  /*
   * compute the dot product of this vector with
   * another vector
  */
  def dot( v : Vector3D ) : Double = 
    x * v.x + y * v.y + z * v.z

  /**
   * compute the length (magnitude) of this vector
  */
  def magnitude : Double = scala.math.sqrt( this.dot( this ) )

  /**
   * create a new vector that has the same direction
   * as this vector but a length of one
  */
  def normalize : Vector3D = scale( 1.0 / magnitude )

  /**
   * compute the cross product of this vector with
   * another vector
  */
  def cross( v : Vector3D ) : Vector3D = {
    val x = this.y * v.z - this.z * v.y
    val y = this.z * v.x - this.x * v.z
    val z = this.x * v.y - this.y * v.x
    new Vector3D(  x, y, z )
  } // cross( Vector3D )

  override def toString : String = "(" + x + "," + y + "," + z + ")"

} // Vector3D
