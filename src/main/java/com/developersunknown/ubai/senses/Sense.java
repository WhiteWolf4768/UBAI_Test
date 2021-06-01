package com.developersunknown.ubai.senses;

import com.developersunknown.ubai.bot.Bot;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public abstract class Sense implements SenseInterface {

    private String senseId;
    private Bot player;
    private Bot target;
    private Map<String, List<Float>> params;

    public Sense(String senseId, Bot target, Map<String, List<Float>> params) {
        this.senseId = senseId;
        this.target = target;
        this.params = params;
    }

    public Sense(String senseId, Map<String, List<Float>> params) {
        this.senseId = senseId;
        this.params = params;
    }

    public Sense(String senseId, Bot target) {
        this.senseId = senseId;
        this.target = target;
    }

    public Sense(String senseId, Bot player, Bot target, Map<String, List<Float>> params) {
        this.senseId = senseId;
        this.player = player;
        this.target = target;
        this.params = params;
    }
}
