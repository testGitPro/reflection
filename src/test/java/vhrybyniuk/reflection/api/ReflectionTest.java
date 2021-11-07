package vhrybyniuk.reflection.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReflectionTest {
    Reflection reflection = new Reflection();

    @Test
    public void generateObjectFromClassTest() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Object current = reflection.generateObjectFromClass(Employee.class);
        assertEquals(Employee.class, current.getClass());
    }

    @Test
    public void changeAllFieldsValuesOnNullObjectTest() throws IllegalAccessException {
        try {
            reflection.changeAllFieldsValues(null);
        } catch (NullPointerException exception) {
            assertEquals("object is Null", exception.getMessage());

        }
    }

    @Test
    public void changeAllFieldsValuesTest() throws IllegalAccessException {
        Employee meEmployee = new Employee(1, "Volodimir", 27, 1000, Employee.Gen.Mr);

        assertEquals(1000, meEmployee.getSalary());
        assertEquals("Volodimir", meEmployee.getName());

        reflection.changeAllFieldsValues(meEmployee);

        assertEquals(0.0, meEmployee.getSalary());
        assertEquals(null, meEmployee.getName());


    }

}

