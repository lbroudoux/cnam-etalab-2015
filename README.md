# cnam-etalab-2015


Some inspirations :
* http://www.javacodegeeks.com/2013/01/processing-huge-files-with-java.html
* http://www.javacodegeeks.com/2015/01/java-8-stream-and-lambda-expressions-parsing-file-example.html
* http://www.javacodegeeks.com/2012/01/using-memory-mapped-file-for-huge.html


some tips for ui : 

* to get my grunt working i have to install nodejs-legacy 
  sudo apt-get install nodejs-legacy
* you need to install imagemin-gifsicle, imagemin-jpegtran, imagemin.....
  sudo npm install imagemin-gifsicle
* problem : i have to "patch" the Gruntfile.js (add comment for this line : )
 wiredep: {
      options: {
      //  cwd: '<%= yeoman.app %>'
      },

found this tips here : https://stackoverflow.com/questions/25784986/yeoman-grunt-no-such-file-or-directory-bower-json/25851329#25851329


