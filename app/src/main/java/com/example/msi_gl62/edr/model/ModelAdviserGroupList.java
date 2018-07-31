package com.example.msi_gl62.edr.model;

public class ModelAdviserGroupList {
    String teacher_adviser_id;
    String teaching_sub_subject;
    String entry_type;
    String teaching_level_year;
    String descriptions;
    String teaching_level_name;
    String study_group;
    String entry_type_name;
    String count_student;


    public ModelAdviserGroupList(String teacher_adviser_id, String teaching_sub_subject, String entry_type, String teaching_level_year, String descriptions, String teaching_level_name, String study_group, String entry_type_name, String count_student) {
        this.teacher_adviser_id = teacher_adviser_id;
        this.teaching_sub_subject = teaching_sub_subject;
        this.entry_type = entry_type;
        this.teaching_level_year = teaching_level_year;
        this.descriptions = descriptions;
        this.teaching_level_name = teaching_level_name;
        this.study_group = study_group;
        this.entry_type_name = entry_type_name;
        this.count_student = count_student;
    }

    public String getTeacher_adviser_id() {
        return teacher_adviser_id;
    }

    public String getTeaching_sub_subject() {
        return teaching_sub_subject;
    }

    public String getEntry_type() {
        return entry_type;
    }

    public String getTeaching_level_year() {
        return teaching_level_year;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public String getTeaching_level_name() {
        return teaching_level_name;
    }

    public String getStudy_group() {
        return study_group;
    }

    public String getEntry_type_name() {
        return entry_type_name;
    }

    public String getCount_student() {
        return count_student;
    }
}
