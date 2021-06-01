package com.developersunknown.ubai.behaviors.healer;

import com.developersunknown.ubai.actions.Action;
import com.developersunknown.ubai.behaviors.Behavior;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HealerBehavior extends Behavior {

    public HealerBehavior(String behaviorId, List<Action> actionList) {
        super(behaviorId, actionList);
    }

    @Override
    public Action chooseAction() {

        log.info("Choose action in {}", behaviorId);

        Map<Float, Action> map = new HashMap<>();

        actionList.forEach(act -> {
            log.info("<<<---------_ {} _--------->>>", act.getActionId());

            float calculatedWeight = act.calculateWeight();
            log.info("**********************");
            log.info("Weight for action {} = {}", act.getActionId(), calculatedWeight);
            log.info("**********************");
            map.put(calculatedWeight, act);

        });

        float max = map.keySet().stream().max(Float::compareTo).get();

        Action action = map.get(max);

        log.info("CHOSEN ACTION - {}", action.getActionId());

        return action;
    }
}
