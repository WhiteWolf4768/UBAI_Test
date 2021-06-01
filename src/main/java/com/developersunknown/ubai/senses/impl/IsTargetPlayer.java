package com.developersunknown.ubai.senses.impl;

import com.developersunknown.ubai.bot.Bot;
import com.developersunknown.ubai.senses.Sense;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class IsTargetPlayer extends Sense {
    public IsTargetPlayer(String senseId, Bot target, Map<String, List<Float>> params) {
        super(senseId, target, params);
    }

    @Override
    public float calculateScore() {
        log.info("Sense {} params: {true = {}, false = {}}", getSenseId(), getParams().get("true"), getParams().get("false"));
        log.info("Target {} is on spot = {}", getTarget().getName(), getTarget().isOnSpot());
        if (getTarget().isPlayer()) {
            return getParams().get("true").get(0);
        } else {
            return getParams().get("false").get(0);
        }
    }
}
