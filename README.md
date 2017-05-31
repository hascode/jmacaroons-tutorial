# jmacaroons Tutorial

Examples for implementing distributed authorization using [Macaroons] with the Java &trade; based implementation, [jmacaroons].

For more detailed information, please feel free to visit my blog at [www.hascode.com].


## Running the Examples

Run it using Maven like this:

```bash
mvn exec:java -Dexec.mainClass=com.hascode.tutorial.example1.BaseMacaroonExample 
mvn exec:java -Dexec.mainClass=com.hascode.tutorial.example1.MacaroonWithCaveatExample
mvn exec:java -Dexec.mainClass=com.hascode.tutorial.example1.ThirdPartyCaveatExample 
```

----

**2017 Micha Kops / hasCode.com**

   [Macaroons]:http://research.google.com/pubs/pub41892.html
   [jmacaroons]:https://github.com/nitram509/jmacaroons
   [www.hascode.com]:http://www.hascode.com/
