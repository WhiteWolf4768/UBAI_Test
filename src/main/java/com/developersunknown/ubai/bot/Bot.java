package com.developersunknown.ubai.bot;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

@Data
@AllArgsConstructor
public class Bot {
    private String name;
    private BotClass botClass;
    private int hp;
    private int maxHp;
    private int healCount;
    private int maxHealCount;
    private boolean onSpot;
    private boolean nearShield;
    private boolean isPlayer;
    private Point3f pos;
    private Vector3f direction;
    private String previousAction;
}
