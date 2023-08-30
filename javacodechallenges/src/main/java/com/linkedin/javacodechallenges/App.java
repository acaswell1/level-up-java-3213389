package com.linkedin.javacodechallenges;

public class App 
{
    public static void main( String[] args )
    {
        Person alec = new Person("Alec", "Caswell", 22);
        Person sam = new Person("Sam", "Bunker", 23);


        alec.introduction();
        sam.introduction();
    }
}
