# hisCinema Web Server
Sample web server for handling HTTP Requests

## To set-up
Go to `HttpResponse.java` and change the line
```
String root = "<enter your directory path to folder here"
```
**Do NOT** include a `/` at the end of the path.  
Make sure the directory is *absolute* (i.e. starting from the root directory of the filesystem).  
Example:
```
String root = "/home/User/Desktop/sample"
```  
Don't use *relative* paths (e.g. `./`, `../`, etc)

## To run
Compile in the terminal and run
```
javac WebServer.java
java WebServer
```
