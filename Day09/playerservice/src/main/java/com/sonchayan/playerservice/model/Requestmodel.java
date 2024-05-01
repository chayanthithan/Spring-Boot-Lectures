package com.sonchayan.playerservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Requestmodel {
    private String playerName;
    private String playerNum;
    private String playerCountry;
    private String playerEmail;
    private String playerPassword;
}
