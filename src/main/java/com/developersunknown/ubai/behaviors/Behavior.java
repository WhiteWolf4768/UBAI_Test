package com.developersunknown.ubai.behaviors;

import com.developersunknown.ubai.actions.Action;

import java.util.List;

public class Behavior {

    protected final String behaviorId;

    protected final List<Action> actionList;

    public Behavior(String behaviorId, List<Action> actionList) {
        this.behaviorId = behaviorId;
        this.actionList = actionList;
    }

    public Action chooseAction() {
        return null;
    }
}
