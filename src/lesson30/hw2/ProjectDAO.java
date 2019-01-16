package lesson30.hw2;

import java.util.HashSet;

public class ProjectDAO {
    static HashSet<Project> projects = new HashSet<>();

    public static Project add(Project project){
        projects.add(project);
        return project;
    }

    public static Project update(Project project) throws IllegalArgumentException{
        if (projects.contains(project)){
        projects.remove(project);
        projects.add(project);
        return project;}
        else{
            throw new IllegalArgumentException("Project not found. Update fail. Project id: " + project.getId());
        }
    }

    public static Project delete (Project project){
        projects.remove(project);
        return project;
    }

public static HashSet<Project> getProjects(){
        return projects;
}

}
