package com.example.msi_gl62.edr.model;

public class ModelTimeTableDashboard {

    String education_table_id,education_table_detail_id,day,period,period_id,start_time,end_time,room,
            teacher_subject,subject_id,subject_code,subject_name,group_name,theory_period,student_group_name_sgs,
            study_group,student_group_subject_id,period_str,start_time_str,end_time_str,teaching_sub_subject,
            teaching_level_year,entry_type,count_period_type;

    public ModelTimeTableDashboard(String education_table_id, String education_table_detail_id, String day, String period, String period_id, String start_time, String end_time, String room, String teacher_subject, String subject_id, String subject_code, String subject_name, String group_name, String theory_period,
                                   String student_group_name_sgs, String study_group, String student_group_subject_id,
                                   String period_str, String start_time_str, String end_time_str, String teaching_sub_subject,
                                   String teaching_level_year, String entry_type, String count_period_type) {
        this.education_table_id = education_table_id;
        this.education_table_detail_id = education_table_detail_id;
        this.day = day;
        this.period = period;
        this.period_id = period_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.room = room;
        this.teacher_subject = teacher_subject;
        this.subject_id = subject_id;
        this.subject_code = subject_code;
        this.subject_name = subject_name;
        this.group_name = group_name;
        this.theory_period = theory_period;
        this.student_group_name_sgs = student_group_name_sgs;
        this.study_group = study_group;
        this.student_group_subject_id = student_group_subject_id;
        this.period_str = period_str;
        this.start_time_str = start_time_str;
        this.end_time_str = end_time_str;
        this.teaching_sub_subject = teaching_sub_subject;
        this.teaching_level_year = teaching_level_year;
        this.entry_type = entry_type;
        this.count_period_type = count_period_type;
    }

    public String getEducation_table_id() {
        return education_table_id;
    }

    public String getEducation_table_detail_id() {
        return education_table_detail_id;
    }

    public String getDay() {
        return day;
    }

    public String getPeriod() {
        return period;
    }

    public String getPeriod_id() {
        return period_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getRoom() {
        return room;
    }

    public String getTeacher_subject() {
        return teacher_subject;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public String getTheory_period() {
        return theory_period;
    }

    public String getStudent_group_name_sgs() {
        return student_group_name_sgs;
    }

    public String getStudy_group() {
        return study_group;
    }

    public String getStudent_group_subject_id() {
        return student_group_subject_id;
    }

    public String getPeriod_str() {
        return period_str;
    }

    public String getStart_time_str() {
        return start_time_str;
    }

    public String getEnd_time_str() {
        return end_time_str;
    }

    public String getTeaching_sub_subject() {
        return teaching_sub_subject;
    }

    public String getTeaching_level_year() {
        return teaching_level_year;
    }

    public String getEntry_type() {
        return entry_type;
    }

    public String getCount_period_type() {
        return count_period_type;
    }
}
