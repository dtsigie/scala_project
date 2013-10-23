Serpienski's Gasket - Colored
Dawit Tsigie
CSC 315
10/23/2013

** Worked with Arturo on the project **

files modified: Line3D.scala, Triangle3D.scala, Polyhedron.scala

Line3D.scala - we added a method called 'midpoint' that finds the vector in the middle of the line and scales it by 0.5

Triangle3D.scala - In the svg method we ported the code from the ruby first so that we could give the figure colors, then we randomly color our figures using the Random class in scala. Note - I didn't actually use the second inpute argument of type Vector3D to create my shading. I also edited the subdivide to get my desired output which is the Serpienski Gasket

Polyhedron.scala - I created a method called 'illum' which creates a random vector which can be passed into the svg method of the triangle. 

How to run: 

Go to Run Configurations select the Common tab and check the box next to "File:" and click on "FileSystem..." to add a .html file. Apply. Then Run. Find the .html file you saved then double-click it and see the result!
