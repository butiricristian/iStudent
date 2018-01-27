package ro.ubb.dto.converter;

import ro.ubb.model.annotations.MyObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterReflection<E extends Object,D extends  Object> {

    public Object mapToDTO(Object object) {
        Class<?> clazz = object.getClass();
        Class<?> clazzDTO = null;
        Object objectDTO = null;

        try {
            clazzDTO = Class.forName("ro.ubb.dto."+clazz.getSimpleName() + "DTO");
            objectDTO = clazzDTO.getConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e.getMessage());
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Field[] fields = clazzDTO.getFields();
        System.out.println(fields.length);
        setFields(object, clazz, objectDTO, fields);
        return objectDTO;
    }


    public Object mapToEntity(Object objectDTO) {
        Class<?> clazzDTO = objectDTO.getClass();
        Class<?> clazz = null;
        Object object = null;

        try {
            clazz = Class.forName(clazzDTO.getName().replace("DTO", ""));
            object = clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e.getMessage());
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Field[] fields = clazz.getFields();
        setFields(objectDTO, clazzDTO, object, fields);
        return object;
    }


    private void setFields(Object from, Class<?> clazzFrom, Object to, Field[] fields) {
        for (Field field : fields) {
            try {
                Field fieldReference = clazzFrom.getField(field.getName());
                Object value = fieldReference.get(from);
                if (value instanceof Collection) {
                    value = mapCollection(value);
                }

                MyObject myObject = fieldReference.getType().getAnnotation(MyObject.class);
                if (myObject != null) {
                    if (clazzFrom.getName().contains("DTO")) value = mapToEntity(value);
                    else value = mapToDTO(value);
                }

                field.set(to, value);
            } catch (NoSuchFieldException e) {
                System.out.println("Field not found " + e.getMessage());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private Object mapCollection(Object objInput) {
        Object objResult;
        List<Object> inputList = (ArrayList) objInput;
        List<Object> resList = null;
        if (objInput.getClass().equals(ArrayList.class)) {
            try {
                objResult = objInput.getClass().getConstructor().newInstance();
                resList = (ArrayList) objResult;

                Object objFromList = inputList.get(0);
                if (objFromList != null) {
                    MyObject myObject = objFromList.getClass().getAnnotation(MyObject.class);
                    if (myObject != null) {
                        for (Object o : inputList) {
                            if (o.getClass().getName().contains("DTO")) {
                                resList.add(mapToEntity(o));
                            } else {
                                resList.add(mapToDTO(o));
                            }
                        }
                    }
                }
                System.out.println(objResult);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return resList;
    }

    public List<Object> mapToDTOs(List<Object> entities){
        if (entities != null) {
            return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<Object> mapToEntities(List<Object> dtos) {
        if (dtos != null) {
            return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }


}