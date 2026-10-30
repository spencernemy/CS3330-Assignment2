package assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelpDesk {
    
    private Map<Integer, SupportRequest> requestsById = new HashMap<>();
    private Map<Technician, List<SupportRequest>> assignments = new HashMap<>();
    
    public void addRequest(SupportRequest request){
        if(request == null ){
            throw new IllegalArgumentException("Request cannot be null");
        }
        if (requestsById.containsKey(request.getId())) {
            throw new IllegalArgumentException("ID cannot be duplicate");

        }
        requestsById.put(request.getId(), request);
    }

   public SupportRequest findRequest(int id){
    
    return requestsById.get(id);
   }

    public void assignRequest(Technician technician, int requestId){
        if (technician == null) {
            throw new IllegalArgumentException(" technician cannot be null");
        }
        
        List<SupportRequest> list = assignments.get(technician);
        if (list == null) {
            list = new ArrayList<>();
            assignments.put(technician, list);
        }
        if (list.contains(requestsById.get(requestId))) {
            throw new IllegalArgumentException("Technicican already has request");
            
        }
        list.add(requestsById.get(requestId));
    }

    public int resolveRequest(Technician technician, int requestId){
        if (technician == null) {
            throw new IllegalArgumentException(" technician cannot be null");
        }
       List<SupportRequest> list = assignments.get(technician);
       if (list == null){
        throw new IllegalStateException("No supportrequests found for technician");
       }
       
       SupportRequest target = null;
       for(int i = 0; i<list.size();i++){
        if (list.get(i).getId()== requestId) {
            target = list.get(i); 
            break;
        }
       }
       if(target == null){
        throw new IllegalArgumentException("for" + technician + "no requrest exists for " + requestId);
       }
       int pts = target.resolveFor(technician);
        return pts;
    }

    public void printAllRequests(){
        for(SupportRequest request : requestsById.values()){
            System.out.println(request);
        }
    
    }
    public void printAssignmentsFor(Technician technician){
        if (technician == null) {
            throw new IllegalArgumentException("null technicican");
            
        }
        List<SupportRequest> list = assignments.get(technician);
        if (list ==null) {
            System.out.println("No Assignments for: " + technician);
        }
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
