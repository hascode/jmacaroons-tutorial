package com.hascode.tutorial;

import com.github.nitram509.jmacaroons.Macaroon;
import com.github.nitram509.jmacaroons.MacaroonsBuilder;

public class Main {

  public static void main(String[] args) {
    String location = "http://www.hascode.com/";
    String secretKey = "thisisaverysecretsecretsecretkey";
    String identifier = "secret key usage";

    Macaroon macaroon = MacaroonsBuilder.create(location, secretKey, identifier);
    System.out.println("Human readable: "+macaroon.inspect());
    System.out.println("Serialized: "+macaroon.serialize());
  }
}
