package geometry
import scala.util.Random
class Polyhedron( val faces : List[Triangle3D]) {

  /**
   * divide each triangular face of this polyhedron into
   * four smaller triangular faces
  */
  def subdivide : Polyhedron = {
    val smallerTriangles = (faces map (f => f.subdivide)).flatten
    new Polyhedron( smallerTriangles )
  } // subdivide

  
  /**
   * produce a description of this polyhedron
   * in the HTML (HyperText Markup Language)
   * and SVG (Scaleable Vector Graphics) languages.
   * The result may be displayed with a Web browser.
  */
  def html : String = {
    val radius = 256 
    
    /**
     * random number generator
     */
    var rand = new Random(System.currentTimeMillis())
   /**
    * creates a random vector which will be used as an input argument for the svg method of the triangle
    */
    
    def illum : Vector3D = { 
      var illumination = new Vector3D(rand.nextDouble,rand.nextDouble,rand.nextDouble)
      illumination.normalize
    }
    
        

    val edges : String = 
   (faces map (f => f.svg(radius, illum)) foldLeft "") {(x,y) => x + y}

    "<html>\n" +
    "<body>\n" +
    "<h1>A Polyhedron</h1>\n" +
    "<svg xmlns=\"http://www.w3.org/2000/svg\"\n" +
    "version=\"1.1\" height=\"" + (2 * radius) +
      "\" width=\"" + (2 * radius) + "\">\n" +
    edges +
    "</svg>\n" + 
    "</body>\n" + 
    "</html>\n"
  } // html

} // Polyhedron

