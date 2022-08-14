package com.ll.commu.Ut;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ut {
    public static class str{
        private static final ObjectMapper om=new ObjectMapper();
        public static String toJson(Object obj,String  defaultValue){
            try {
                return om.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }
        public static <T>T toObj(String json, TypeReference<T> type,T defaultValue){
            try {
                return om.readValue(json,type);
            } catch (JsonProcessingException e) {
               return defaultValue;
            }
        }

    }
}
