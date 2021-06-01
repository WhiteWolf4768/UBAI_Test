package com.developersunknown.ubai.bot;

import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class VectorCalculator {
    public static Vector3f getDirection(Tuple3f from, Tuple3f to) {
        Vector3f dir = new Vector3f(to);
        dir.sub(from);
        dir.normalize();
        if (Float.isNaN(dir.x)) {
            dir.setX(0);
        }
        if (Float.isNaN(dir.y)) {
            dir.setY(0);
        }
        if (Float.isNaN(dir.z)) {
            dir.setZ(0);
        }
        return dir;
    }
}
