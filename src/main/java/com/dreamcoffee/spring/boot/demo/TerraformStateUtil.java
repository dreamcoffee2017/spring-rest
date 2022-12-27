package com.dreamcoffee.spring.boot.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.stream.StreamSupport;

public class TerraformStateUtil {
    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\frank_chen\\Downloads\\baw-tfstate.json";
        JsonNode jsonNode = new ObjectMapper().readTree(new File(filename));
        StreamSupport.stream(jsonNode.get("resources").spliterator(), false)
                .filter(r -> "managed".equals(r.get("mode").asText()))
                .map(r -> {
                    JsonNode type = r.get("type");
                    JsonNode name;
                    JsonNode tags = r.findValue("tags");
                    if (tags != null) {
                        name = tags.has("NAME") ? tags.get("NAME") : tags.get("Name");
                    } else {
                        JsonNode attributes = r.findValue("attributes");
                        name = attributes.get("name");
                    }
                    return new JsonNode[]{type, name};
                }).filter(a -> a[1] != null)
                .forEach(a -> System.out.printf("%s\t%s\n", a[0].asText(), a[1].asText()));
    }
}
