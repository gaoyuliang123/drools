package com.tgl.template;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.StatefulSession;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;

public class TestItemTemplate {
    public static void main(String[] args) throws Exception{
        Collection<ParamSet> cf = new ArrayList<ParamSet>();
        cf.add(new ParamSet("price", 10, 50, EnumSet.of(ItemCode.BARREL)));
        cf.add(new ParamSet("weight", 10, 99, EnumSet.of(ItemCode.LOCK, ItemCode.STOCK)));
        InputStream is = ResourceFactory.newClassPathResource("rules/item.drl")
                .getInputStream();
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        Expander ex = new Expander();
        ex.expander(knowledgeBase, is, cf);
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
        session.insert(new Item("A", 130, 42, ItemCode.LOCK));
        session.insert(new Item("B", 44, 140, ItemCode.STOCK));
        session.insert(new Item("C", 23, 80, ItemCode.BARREL));
        session.insert(new Item("D", 85, 9, ItemCode.LOCK));
        session.insert(new Item("E", 146, 189, ItemCode.STOCK));
        session.insert(new Item("F", 16, 90, ItemCode.STOCK));
        session.insert(new Item("G", 44, 140, ItemCode.BARREL));
        session.fireAllRules();
    }
}
