package com.hascode.tutorial.example1;

import com.github.nitram509.jmacaroons.Macaroon;
import com.github.nitram509.jmacaroons.MacaroonsBuilder;
import com.github.nitram509.jmacaroons.MacaroonsVerifier;
import com.github.nitram509.jmacaroons.verifier.TimestampCaveatVerifier;

public class MacaroonWithCaveatExample {

  public static void main(String[] args) {
    String location = "http://some.hascode/";
    String secretKey = "thisisaverysecretsecretsecretkeyxoxoxoxo";
    String identifier = "hascode-someservice";

    // create macaroon
    Macaroon macaroon = MacaroonsBuilder.create(location, secretKey, identifier);
    printInfo(macaroon);

    // add caveat
    Macaroon withCaveat = MacaroonsBuilder.modify(macaroon)
        .add_first_party_caveat("userid = 123456").getMacaroon();
    printInfo(withCaveat);

    // verify with caveat
    MacaroonsVerifier veri = new MacaroonsVerifier(withCaveat);
    veri.satisfyExact("userid = 666"); // invalid
    System.out.printf("macaroon with id '%s' is valid: %s\n", withCaveat.identifier,
        veri.isValid(secretKey));
    veri.satisfyExact("userid = 123456"); // valid
    System.out.printf("macaroon with id '%s' is valid: %s\n", withCaveat.identifier,
        veri.isValid(secretKey));
  }

  private static void printInfo(Macaroon macaroon) {
    System.out.println("-----------------------------------\n");
    System.out.printf("-- Human readable:\n%s\n", macaroon.inspect());
    System.out.printf("-- Serialized (Base64 URL safe):\n%s\n", macaroon.serialize());
    System.out.println("-----------------------------------\n");
  }
}
