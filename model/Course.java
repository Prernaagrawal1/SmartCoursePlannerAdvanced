package model;

import java.util.ArrayList;

public class Course {
    private String name;
    private String code;
    private ArrayList<Module> modules = new ArrayList<>();

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public void markModuleComplete(String moduleName) {
        for (Module m : modules) {
            if (m.getName().equalsIgnoreCase(moduleName)) {
                m.markCompleted();
                return;
            }
        }
        System.out.println("Module not found.");
    }

    public int getCompletedCount() {
        return (int) modules.stream().filter(Module::isCompleted).count();
    }

    public void showProgress() {
        int total = modules.size();
        int done = getCompletedCount();
        int percent = (int) ((done / (double) total) * 100);
        System.out.println("Progress: " + percent + "% (" + done + "/" + total + " completed)");
    }

    public void display() {
        System.out.println("Course: " + name + " (" + code + ")");
        for (Module m : modules) {
            System.out.println("  - " + m);
        }
        showProgress();
    }

    public String toFileFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(",").append(code).append("\n");
        for (Module m : modules) {
            sb.append(m.getName()).append(",").append(m.getDeadline()).append(",").append(m.isCompleted()).append("\n");
        }
        return sb.toString();
    }

public String getCode() {
    return code;
}

public String getName() {
    return name;
}


}
