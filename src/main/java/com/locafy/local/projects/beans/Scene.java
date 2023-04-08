package com.locafy.local.projects.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Scene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String inOrOut;
    private String location;
    private String timeOfDay;
    private String sceneNumbers;
    private int occurrences;
    private String streetNum;
    private String streetName;
    private String postalCode;
    private String city;
    private String province;
    private String country;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "project_scene", joinColumns = @JoinColumn(name = "scene_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    @NonNull
    private Project project;


}
