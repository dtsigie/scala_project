package geometry

import scala.util.Random
import scala.Int




class Triangle3D( val a : Vector3D, val b : Vector3D, val c : Vector3D ) {

  /**
   * create a unit vector that is
   * perpendicular to this triangle
  */
  def normal : Vector3D = {
    val u = (a - b).normalize
    val v = (c - b).normalize
    u.cross( v )
  } // normal

  /**
   * divide this triangle into four smaller triangles
   * result is an array that contains the 4 smaller triangles
  */
  def subdivide : List[Triangle3D] = {
    val ab = (new Line3D( a, b )).midpoint//.normalize
    val bc = (new Line3D(b, c)).midpoint//.normalize
    val ca = (new Line3D( c, a )).midpoint//.normalize

    val t0 = ( new Triangle3D( a, ab, ca ))
    val t1 = ( new Triangle3D( ab, b, bc ))
    val t2 = ( new Triangle3D( bc, c, ca ))
  

    t0::t1::t2::Nil
  } // subdivide

  /**
   * describe this triangle in the 
   * SVG (Scalable Vector Graphics) language
  */
  def svg( radius : Double, illumination : Vector3D ) : String = {
    val translation = new Vector3D( radius, radius, 0 )
    val p0 = (a.scale( radius )) + translation
    val p1 = (b.scale( radius )) + translation
    val p2 = (c.scale( radius )) + translation

    val p01 = new Line3D( p0, p1 )
    val p12 = new Line3D( p1, p2 )
    val p20 = new Line3D( p2, p0 )	
    
   
    
    /** Randomly creates values for the colors in the html using the scala library Random 
     */
    val rand = new Random()
    var col1 = rand.nextInt % 256
    var col2 = rand.nextInt % 256
    var col3 = rand.nextInt % 256
    
    if ( col1 < 0 ){
      col1 = col1 * -1
     
    }
     if ( col2 < 0 ){
      col2 = col2 * -1
     
    }
      if ( col3 < 0 ){
      col3 = col3 * -1
     
    }
     
    "<polygon points = \"" + 
    p0.x + "," + p0.y + " " +
    p1.x + "," + p1.y + " " +
    p2.x + "," + p2.y + "\" style=\"fill:rgb(" +
   col3 + "," + col1 + "," + col2 + ")\"/>\n"

 
  } // svg( Double )

 

} // Triangle3D
