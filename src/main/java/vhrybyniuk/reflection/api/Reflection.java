package vhrybyniuk.reflection.api;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflection {


    //1 Метод принимает класс и возвращает созданный объект этого класса
 public Object generateObjectFromClass(Class clss) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
     return clss.getDeclaredConstructor().newInstance();
 }

    //2  Метод принимает object и вызывает у него все методы без параметров
    public void callMethodWithoutParams(Object object) throws InvocationTargetException, IllegalAccessException {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if(method.getParameterCount() == 0){
                method.setAccessible(true);
                method.invoke(object);

            }
        }
    }

    //3 Метод принимает object и выводит на экран все сигнатуры методов в который есть final

    public void printFinalMethods(Object object) {
     String methodName = "";
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.getModifiers() == Modifier.FINAL) {
                methodName = methodName + method.getName() + " , ";
            }
        }
        int lengthOfString = methodName.length();
        if (lengthOfString != 0) {
            System.out.println("Наявні сигнатури методів з final : " + methodName.substring(lengthOfString - 2, lengthOfString));
        } else {
            System.out.println("Відсутні сигнатури методів з final");

        }
 }
    //4 Метод принимает Class и выводит все не публичные методы этого класса

    public void printAllUnpublicMethodNames (Class clss) {
        String methodName = "";
        for (Method method : clss.getDeclaredMethods()) {
            if (method.getModifiers() != Modifier.PUBLIC) {
                methodName = methodName + method.getName() + " , ";
            }
        }
        int lengthOfString = methodName.length();
        if (lengthOfString != 0) {
            System.out.println("Методи класу " + clss.getName() + " що не є пулічними : " + methodName.substring(lengthOfString - 2, lengthOfString));
        } else {
            System.out.println("У класі" + clss.getName() + " не виявлено unpublic методів");

        }
    }

    //5 Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует

    public void printParentClassAndInterfacesNames(Class clss){

        String parentsNames = clss.getSuperclass().toString();
        String interfacesNames = clss.getInterfaces().toString();

        System.out.println("Предки класу " + clss.getName() + " " + parentsNames + " ." +"\n" +
                           "Інтерфейси імплементовані класом " + clss.getName() + " " + interfacesNames + " .");
    }

 //   6   Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+
    public void changeAllFieldsValues (Object object) throws IllegalAccessException {

        if (object == null) {
             throw  new NullPointerException("object is Null");
        }

     for (Field field : object.getClass().getDeclaredFields()) {
         if (Modifier.isPrivate(field.getModifiers())) {
             field.setAccessible(true);

             if (field.getType().equals(int.class)) {
                 field.set(object, 0);
             } else if (field.getType().equals(String.class)) {
                 field.set(object, null);
             } else if (field.getType().equals(boolean.class)) {
                 field.set(object, false);
             } else if (field.getType().equals(double.class)) {
                 field.set(object, 0.0);
             }
           }
        }
    }
}
