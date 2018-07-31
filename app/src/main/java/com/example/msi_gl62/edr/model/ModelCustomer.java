package com.example.msi_gl62.edr.model;

public class ModelCustomer {

    String id, college_code, college_code_prefix, school_code,
            school_name_thai,
            getSchool_name_eng,
            school_address,
            school_phone_number,
            period_number,
            term_number,
            register_limit_day,
            absent_time,
            document_number,
            _app_edr_ipaddress,
            app_edr_ipaddress,
            app_edr_domain,
            app_edr_port,
            app_edr_name,
            app_edr_android_ipaddress,
            app_edr_android_name,
            app_edr_android_port,
            grandats_staff_contact_phone,
            android_version,
            production_version,
            android_teacher_version,
            production_teacher_version,
            android_student_version,
            production_student_version,
            ios_teacher_version;

    public ModelCustomer(String id, String college_code, String college_code_prefix, String school_code,
                         String school_name_thai, String getSchool_name_eng, String school_address,
                         String school_phone_number, String period_number, String term_number,
                         String register_limit_day, String absent_time, String document_number,
                         String _app_edr_ipaddress, String app_edr_ipaddress, String app_edr_domain,
                         String app_edr_port, String app_edr_name, String app_edr_android_ipaddress,
                         String app_edr_android_name, String app_edr_android_port,
                         String grandats_staff_contact_phone, String android_version,
                         String production_version, String android_teacher_version,
                         String production_teacher_version, String android_student_version,
                         String production_student_version, String ios_teacher_version) {
        this.id = id;
        this.college_code = college_code;
        this.college_code_prefix = college_code_prefix;
        this.school_code = school_code;
        this.school_name_thai = school_name_thai;
        this.getSchool_name_eng = getSchool_name_eng;
        this.school_address = school_address;
        this.school_phone_number = school_phone_number;
        this.period_number = period_number;
        this.term_number = term_number;
        this.register_limit_day = register_limit_day;
        this.absent_time = absent_time;
        this.document_number = document_number;
        this._app_edr_ipaddress = _app_edr_ipaddress;
        this.app_edr_ipaddress = app_edr_ipaddress;
        this.app_edr_domain = app_edr_domain;
        this.app_edr_port = app_edr_port;
        this.app_edr_name = app_edr_name;
        this.app_edr_android_ipaddress = app_edr_android_ipaddress;
        this.app_edr_android_name = app_edr_android_name;
        this.app_edr_android_port = app_edr_android_port;
        this.grandats_staff_contact_phone = grandats_staff_contact_phone;
        this.android_version = android_version;
        this.production_version = production_version;
        this.android_teacher_version = android_teacher_version;
        this.production_teacher_version = production_teacher_version;
        this.android_student_version = android_student_version;
        this.production_student_version = production_student_version;
        this.ios_teacher_version = ios_teacher_version;
    }

    public String getId() {
        return id;
    }

    public String getCollege_code() {
        return college_code;
    }

    public String getCollege_code_prefix() {
        return college_code_prefix;
    }

    public String getSchool_code() {
        return school_code;
    }

    public String getSchool_name_thai() {
        return school_name_thai;
    }

    public String getGetSchool_name_eng() {
        return getSchool_name_eng;
    }

    public String getSchool_address() {
        return school_address;
    }

    public String getSchool_phone_number() {
        return school_phone_number;
    }

    public String getPeriod_number() {
        return period_number;
    }

    public String getTerm_number() {
        return term_number;
    }

    public String getRegister_limit_day() {
        return register_limit_day;
    }

    public String getAbsent_time() {
        return absent_time;
    }

    public String getDocument_number() {
        return document_number;
    }

    public String get_app_edr_ipaddress() {
        return _app_edr_ipaddress;
    }

    public String getApp_edr_ipaddress() {
        return app_edr_ipaddress;
    }

    public String getApp_edr_domain() {
        return app_edr_domain;
    }

    public String getApp_edr_port() {
        return app_edr_port;
    }

    public String getApp_edr_name() {
        return app_edr_name;
    }

    public String getApp_edr_android_ipaddress() {
        return app_edr_android_ipaddress;
    }

    public String getApp_edr_android_name() {
        return app_edr_android_name;
    }

    public String getApp_edr_android_port() {
        return app_edr_android_port;
    }

    public String getGrandats_staff_contact_phone() {
        return grandats_staff_contact_phone;
    }

    public String getAndroid_version() {
        return android_version;
    }

    public String getProduction_version() {
        return production_version;
    }

    public String getAndroid_teacher_version() {
        return android_teacher_version;
    }

    public String getProduction_teacher_version() {
        return production_teacher_version;
    }

    public String getAndroid_student_version() {
        return android_student_version;
    }

    public String getProduction_student_version() {
        return production_student_version;
    }

    public String getIos_teacher_version() {
        return ios_teacher_version;
    }
}
