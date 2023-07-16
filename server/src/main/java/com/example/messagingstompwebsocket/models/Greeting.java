package com.example.messagingstompwebsocket.models;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Greeting {

  private String content;
  private UUID id = UUID.randomUUID();

  public Greeting(String content) {
    this.content = content;
  }

}