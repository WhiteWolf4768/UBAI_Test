package com.developersunknown.ubai.senses.impl;

import com.developersunknown.ubai.senses.Sense;

import java.util.List;
import java.util.Map;

public class ConstantSense extends Sense {
    public ConstantSense(String senseId, Map<String, List<Float>> params) {
        super(senseId, params);
    }

    public float calculateScore() {
        return getParams().get("const").get(0);
    }
}
