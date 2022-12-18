package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class questionbank {
public static List <QuestionList> javaQuestions(){
    final List<QuestionList> questionLists=new ArrayList<>();
    final QuestionList question1=new QuestionList("Who invented Java Programming?","Guido van Rossum","James Gosling","Dennis Ritchie","Bjarne Stroustrup","James Gosling","");
    final QuestionList question2=new QuestionList("Which component is used to compile, debug and execute the java programs?","JRE","JIT","JDK","JVM","JDK","");
    final QuestionList question3=new QuestionList(" Which one of the following is not a Java feature?","Object-oriented","Use of pointers","Portable","Dynamic and Extensible","Use of pointers","");
    final QuestionList question4=new QuestionList("Which of these cannot be used for a variable name in Java?","identifier & keyword","identifier","keyword","none of the mentioned","keyword","");
    final QuestionList question5=new QuestionList("Which exception is thrown when java is out of memory?","MemoryError","OutOfMemoryError","MemoryOutOfBoundsException","MemoryFullException","OutOfMemoryError","");
    final QuestionList question6=new QuestionList("Which environment variable is used to set the java path?","MAVEN_Path","JavaPATH","JAVA","JAVA_HOME","JAVA_HOME","");
   questionLists.add(question1);
   questionLists.add(question2);
   questionLists.add(question3);
   questionLists.add(question4);
   questionLists.add(question5);
   questionLists.add(question6);
   return questionLists;

}
    public static List <QuestionList> flutterQuestions(){
        final List<QuestionList> questionLists=new ArrayList<>();
        final QuestionList question1=new QuestionList("Flutter developed by?","Oracle","Facebook","Google","IBM","Google","");
        final QuestionList question2=new QuestionList("Flutter is mainly optimized for 2D mobile apps that can run on?","Android","iOS","Both A and B","None of the above","Both A and B","");
        final QuestionList question3=new QuestionList(" Which of the following used to develop the native hybrid app from a single codebase?","React Native","Flutter","Both A and B","Keras","Both A and B","");
        final QuestionList question4=new QuestionList("Which function is responsible for starting the program?","runApp()","run()"," flutter()","main()","main()","");
        final QuestionList question5=new QuestionList("The Flutter tooling supports _____ modes while compiling the application","2","3","4","5","3","");
        final QuestionList question6=new QuestionList("A widget that allows us to refresh the screen is called a ____________.","Stateless widgets","Stateful widget","Statebuild widget","All of the above","Stateful widget","");
        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);
        questionLists.add(question6);
        return questionLists;

    }
    public static List <QuestionList> kotliQuestions(){
        final List<QuestionList> questionLists=new ArrayList<>();
        final QuestionList question1=new QuestionList("Which extension is responsible to save Kotlin files ?",".kot"," .android"," .src","kt or .kts","kt or .kts","");
        final QuestionList question2=new QuestionList("What handles null exceptions in Kotlin ?","Sealed classes","Lambda functions","Elvis operator","The Kotlin extension","Elvis operator","");
        final QuestionList question3=new QuestionList("In Kotlin, the default visibility modifier is ?","sealed","public","protected","private","public","");
        final QuestionList question4=new QuestionList("What defines a sealed class in Kotlin ?","Its another name for an abstract clas","It represents restricted class hierarchies","It is used in every Kotlin program","None of these","It represents restricted class hierarchies","");
        final QuestionList question5=new QuestionList("Which of these features are available in Kotlin but not\n" +
                "in the Java language ?\n"," Operator overloading"," Coroutines and Null safety","Range expressions","All of the above","All of the above","");
        final QuestionList question6=new QuestionList("val short for Value, a constant which cannot be\n" +
                "changed once assigned ?\n","It can be changed but once only","It can be changed","val cannot be changed after its assigned","None of these","val cannot be changed after its assigned","");
        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);
        questionLists.add(question6);
        return questionLists;

    }
    public static List <QuestionList> androidQuestions(){
        final List<QuestionList> questionLists=new ArrayList<>();
        final QuestionList question1=new QuestionList("Android is based on which of the following language? ","Java","C++ ","C","None of the above ","Java","");
        final QuestionList question2=new QuestionList("Which of the following is not a nickname of any android version?","Donut","Muffin","Honeycomb","Cupcake","Muffin","");
        final QuestionList question3=new QuestionList("What is an activity in android? ","android class ","android package ","A single screen in an application with supporting java code","None of the above ","A single screen in an application with supporting java code","");
        final QuestionList question4=new QuestionList("Which of the following kernel is used in Android? ","MAC","Windows","Linux","Redhat ","Linux","");
        final QuestionList question5=new QuestionList("Which of the following is contained in the src folder?","XML ","Java source code ","Manifest ","None of the above ","Java source code ","");
        final QuestionList question6=new QuestionList("Which of the following method is used to handle what happens after clicking a button? ","onClick ","onCreate","onSelect","None of the above","onClick ","");
        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);
        questionLists.add(question6);
        return questionLists;

    }
    public static List<QuestionList> getquestions(String selecttopic)
    {
        switch (selecttopic)
        {
            case "java":
                return javaQuestions();
            case "android":
                return androidQuestions();
            case "kotlin":
                return kotliQuestions();
            default:
                return flutterQuestions();
        }

    }
}
