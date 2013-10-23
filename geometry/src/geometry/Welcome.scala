package geometry

object Welcome  extends App {

  /**
   * make faces of an octahedron
  */
  def octahedron : List[Triangle3D] = {
    // create 2 faces of an octahedron that
    // lie on the near side of the x-y plane.

   
    val east = new Vector3D( 1.0, 0.0, 0.0 )
    val south = new Vector3D( 0.0, -1.0, 0.0 )
    val west = new Vector3D( -1.0, 0.0, 0.0 )
    val near = new Vector3D( 0.0, 0.0, 1.0 )

   
    val southeast = new Triangle3D( east, south, near )
    val southwest = new Triangle3D( near, south, west )
   

    southeast::southwest::Nil
  } // constructor

  def angle( i : Int, n : Int ) : Double = {
    i * ((2 * Math.PI)/n)
  }
  
  def x( i : Int, angle : Double ) : Double = {
    Math.cos( angle )
  }
  
  def y( i : Int, angle : Double ) : Double = {
    Math.sin( angle )
  }
  
  def vertex( i : Int, z : Double, n : Int ) : Vector3D = {
    val theta = angle( i, n )
    new Vector3D( x(i,theta), y(i,theta), z)
  }
  def polygon( n : Int, z : Double ) : List[Vector3D] = {
    List.range(0,n) map (i => vertex(i,z,n))
  }
  
  
val p = new Polyhedron( octahedron )
println( p.subdivide.subdivide.subdivide.subdivide.subdivide.html )
}