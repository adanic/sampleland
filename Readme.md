To build project use:

```
mvn package
```

You will also need Tomcat. After installing it, rename the build `embassy.war` package in `target` directory to `ROOT.war` and copy it to Tomcat's `webapps` directory.

Add a local dns record by mapping sampleland.ir to localhost in `/etc/hosts`:

```
127.0.0.1 sampleland.ir
```

Also, to run on port number 80, you'll need root permission. Edit `server.xml` file in tomcat's `conf` directory and set port number to 80. Then start tomcat using `sudo`.
