package main.controller;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import main.model.University;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    private static final Jsonb jsonb = JsonbBuilder.create();

    public static void writeToJsonFile(University university, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            jsonb.toJson(university, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static University readFromJsonFile(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            return jsonb.fromJson(reader, University.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}