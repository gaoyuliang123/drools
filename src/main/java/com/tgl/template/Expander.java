package com.tgl.template;


import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.template.ObjectDataCompiler;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;

public class Expander {
    public void expander(KnowledgeBase knowledgeBase, InputStream is, Collection<?> act) {
        ObjectDataCompiler converter = new ObjectDataCompiler();
        //drl
        String drl = converter.compile(act, is);
        //kBuilder
        KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        //add drl
        Reader rdrl = new StringReader(drl);
        kBuilder.add(ResourceFactory.newReaderResource(rdrl), ResourceType.DRL);
        //KnowledgeBuilderError
        if (kBuilder.hasErrors()) {
            for (KnowledgeBuilderError err : kBuilder.getErrors()) {
                System.err.println(err.toString());
            }
            throw new IllegalStateException("DRL errors");
        }
        //addKnowledgePackages
        knowledgeBase.addKnowledgePackages(kBuilder.getKnowledgePackages());
    }
}
