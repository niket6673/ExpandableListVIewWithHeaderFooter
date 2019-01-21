package com.example.niket.headerfooterforexpandablelistview;

import java.util.List;

public class ParentObject {

    public String mother;
    public String father;

    //Header and footer don’t need to be a String,
    //they can be a class or whatever depend on your need.
    public String textToHeader;
    public String textToFooter;

    //Parent should have a list of their child
    public List<ChildObject> childObjects;

    public ParentObject(String mother, String father, String textToHeader, String textToFooter, List<ChildObject> childObjects)
    {
        this.mother = mother;
        this.father = father;
        this.textToFooter = textToFooter;
        this.textToHeader = textToHeader;
        this.childObjects = childObjects;
    }
}
