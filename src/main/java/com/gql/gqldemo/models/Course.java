package com.gql.gqldemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "courses")
@Data
public class Course {
    @Id
    private String id;
    @JsonIgnore
    private String title;
    @JsonIgnore
    private String description;
    @JsonIgnore
    private String thumbnail;
    @JsonIgnore
    private String clips;
    @JsonIgnore
    private int clipCount;


//    private List<String> learningObjective;
//    private String targetLearner;
//    private double duration;
//    private boolean deletedStatus;
//    private boolean publishedStatus;
//    private boolean draftStatus;
//    private double version;
//    private String status;
//    private String createdBy;
//    private Date createdAt;
//    private String updatedBy;
//    private Date updatedAt;
//    private Date publishedAt;
//    private String vrModuleId;
//    private List<String> assigneeIds;

}
