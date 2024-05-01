package com.sonchayan.playerservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "player_details")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private Long playerId;
    @Column(name = "player_Name")
    @Size(min = 2,max = 50)
    private String playerName;
    @Column(name = "player_Num")
    @Size(max = 3,min = 1)
    private String playerNum;
    @Column(name = "player_Country")
    private String playerCountry;
    @Column(name = "player_Email")
    @Email
    private String playerEmail;
    @Column(name = "player_Password")
    private String playerPassword;
}
