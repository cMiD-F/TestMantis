package com.javaseleniumtemplate.flow;

import com.javaseleniumtemplate.pages.ResumePage;

import java.util.Objects;

public class StatusDesenvFlow {
    //Objects and constructor
    ResumePage resumePage;

    public StatusDesenvFlow(){
        //Page and Steps Objects
        resumePage = new ResumePage();
    }

    //Flows
    public Long getFinishedTasks(Integer tableRows, String username){
        long quantity = 0L;

        for(int i = 1; i<= tableRows; i++){
            String user = resumePage.getUsername(String.valueOf(i));
            if(Objects.equals(username, user)){
                quantity = Long.parseLong(resumePage.getFinishedQt(String.valueOf(i)));

                break;
            }
        }

        return quantity;
    }

    public Double getTotalTasks(Integer tableRows){
        double quantity = 0L;

        for(int i = 1; i <= tableRows; i++){
            quantity += Double.parseDouble(resumePage.getTotalTasks(String.valueOf(i)));
        }

        return quantity;
    }

    public Double getTotalTasksByUser(String username, Integer tableRows){
        double quantity = 0L;

        for(int i = 1; i <= tableRows; i++){
            if(resumePage.getUsername(String.valueOf(i)).equals(username)){
                quantity = Double.parseDouble(resumePage.getTotalTasks(String.valueOf(i)));
            }
        }

        return quantity;
    }

    public String getUserProportion(String username, Integer tableRows){
        String proportion = "";

        for(int i = 1; i <= tableRows; i++){
            if(resumePage.getUsername(String.valueOf(i)).equals(username)){
                proportion = resumePage.getTotalProportion(String.valueOf(i));
            }
        }

        return proportion;
    }

    public String getUserResolvedProportion(String username, Integer tableRows){
        String proportion = "";

        for(int i = 1; i <= tableRows; i++){
            if(resumePage.getUsername(String.valueOf(i)).equals(username)){
                proportion = resumePage.getResolvedProportion(String.valueOf(i));
            }
        }

        return proportion;
    }
}
