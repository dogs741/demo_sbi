# SBI Demo Project
For Demo
----
## Version
1.0

## Requirement
- Java 1.8 +
- docker
- maven

## Introduction
REST API base on Spring Boot

Provide the following functions:

- Basic CRUD APIs for Company and Client data.
- Platform users must login first to access the system.
- An additional API to add multiple clients in one single request.
- Authentication/authorization with 3 roles
    - super user: access to all functions.
    - manager: modify/delete/view company/client data.
    - operator: create/view company/client data.
- Exception Mapping (Error Handle, include HTTP Status 400、500)
- Request object validated by Java Bean Validate ( JSR303 )
- Integrate all response into same output with the structure of success, fail & error
- Swagger UI 
## Framework
- Spring Boot
- Spring Data 
- AssertJ + Junit

## 專案結構
- Controller : Request 進入點
- Service : 業務邏輯處理區
- Repository : DB存取介面
- config : 設定檔configuration
- exception : 自訂義exception類別
- handler : 錯誤處理
- model : PO ( persistent object ) / VO ( value object )/ Request / Response Java Bean
- util : 工具類別
- resource : spring boot 設定檔 .property
- test : AsertJ + Junit 測試

## 專案目錄下 build image
- 啟動 docker
- command line 執行 `mvn compile jib:dockerBuild`
- `docker run demo-sbi`
可以開 postman 測試或 上 swager-ui

http://localhost:8080/swagger-ui.html#/

> 專案預設 port 8080
