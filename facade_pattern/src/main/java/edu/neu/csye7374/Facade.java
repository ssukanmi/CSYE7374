package edu.neu.csye7374;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Facade {
    private interface ProgramDataFacadeAPI {
        void save(List<String> programData);
        List<String> programDataLoad();
    }

    private static class Student {
        private String name;
        private Double gpa;
        private Integer id;

        public String getCSV() {
            return id + ", " + name + ", " + gpa;
        }

        public Student(String name, Double gpa, Integer id) {
            this.name = name;
            this.gpa = gpa;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getGpa() {
            return gpa;
        }

        public void setGpa(Double gpa) {
            this.gpa = gpa;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    private static class CSVProgramDataSaver implements ProgramDataFacadeAPI {
        private String outputPath;

        public CSVProgramDataSaver(String outputPath) {
            this.outputPath = outputPath;
        }

        public String getOutputPath() {
            return outputPath;
        }

        public void setOutputPath(String outputPath) {
            this.outputPath = outputPath;
        }

        @Override
        public void save(List<String> programData) {
            try {
                FileWriter fw = new FileWriter(outputPath);
                BufferedWriter out = new BufferedWriter(fw);
                for (String s: programData) {
                    out.write(s);
                    out.newLine();
                }
                out.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public List<String> programDataLoad() {
            List<String> result = new ArrayList<>();
            try {
                FileReader fr = new FileReader(outputPath);
                BufferedReader in = new BufferedReader(fr);
                String line;
                while((line = in.readLine()) != null) {
                    result.add(line);
                }
                in.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    public static void demo() {
        String filePath = Paths.get(System.getProperty("user.dir"),"src", "main", "students.csv").toString();
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tanay", 4.0, 1));
        students.add(new Student("Nimish", 3.8, 2));
        students.add(new Student("Ola", 3.9, 3));

        ProgramDataFacadeAPI programDataFacade = new CSVProgramDataSaver(filePath);
        List<String> studentStringList = students.stream().map(student -> student.getCSV()).collect(Collectors.toList());
        // write
        programDataFacade.save(studentStringList);

        // read
        List<String> loadedData = programDataFacade.programDataLoad();
        loadedData.stream().forEach(s -> System.out.println(s));
    }
}
