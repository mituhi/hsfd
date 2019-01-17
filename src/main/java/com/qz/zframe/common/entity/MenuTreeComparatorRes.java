package com.qz.zframe.common.entity;

import java.util.Comparator;

public class MenuTreeComparatorRes implements Comparator<Res> {
	public int compare(Res o1, Res o2) {
        if (o1 == null || o2 == null) {
            return 0;
        }

        Res node1 = o1;
        Res node2 = o2;

        if (node1.getOrderNo() < node2.getOrderNo()) {
            return -1;
        } else if (node1.getOrderNo() > node2.getOrderNo()) {
            return 1;
        }
        return 0;
    }
}
