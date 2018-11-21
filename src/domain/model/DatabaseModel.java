package domain.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class DatabaseModel {

    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(Integer id) {
        if(id == null){
            throw new IllegalArgumentException("No userid given");
        }
        this.id = id;
    }

    public void setAttribute(String fieldName, String fieldValue)  {
        try {
            String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method method = this.getClass().getDeclaredMethod(methodName, String.class);
            method.invoke(this, fieldValue);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            System.out.println(e.toString() + " " + e.getMessage());
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof IllegalArgumentException) {
                throw (IllegalArgumentException) e.getCause();
            }
        }

    }

}
