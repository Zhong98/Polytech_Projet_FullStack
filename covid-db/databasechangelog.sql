/*
 Navicat Premium Data Transfer

 Source Server         : localhost_5432
 Source Server Type    : PostgreSQL
 Source Server Version : 140006
 Source Host           : localhost:5432
 Source Catalog        : covid-db
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 140006
 File Encoding         : 65001

 Date: 16/01/2023 00:51:07
*/


-- ----------------------------
-- Table structure for databasechangelog
-- ----------------------------
DROP TABLE IF EXISTS "public"."databasechangelog";
CREATE TABLE "public"."databasechangelog" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "author" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "filename" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "dateexecuted" timestamp(6) NOT NULL,
  "orderexecuted" int4 NOT NULL,
  "exectype" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "md5sum" varchar(35) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "comments" varchar(255) COLLATE "pg_catalog"."default",
  "tag" varchar(255) COLLATE "pg_catalog"."default",
  "liquibase" varchar(20) COLLATE "pg_catalog"."default",
  "contexts" varchar(255) COLLATE "pg_catalog"."default",
  "labels" varchar(255) COLLATE "pg_catalog"."default",
  "deployment_id" varchar(10) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of databasechangelog
-- ----------------------------
INSERT INTO "public"."databasechangelog" VALUES ('2023-person', 'zixiao', 'liquibase/changelog/init-schema.xml', '2023-01-13 00:10:59.239304', 1, 'EXECUTED', '8:7985a131ba62516719609d999d18d177', 'createTable tableName=person', '', NULL, '4.9.1', NULL, NULL, '3565059160');
INSERT INTO "public"."databasechangelog" VALUES ('2023-reservation', 'zixiao', 'liquibase/changelog/init-schema.xml', '2023-01-13 00:10:59.256993', 2, 'EXECUTED', '8:8f589d6a9b9aa7c7cb32ceee409fa3ab', 'createTable tableName=reservation', '', NULL, '4.9.1', NULL, NULL, '3565059160');
INSERT INTO "public"."databasechangelog" VALUES ('2023-addColumn', 'zixiao', 'liquibase/changelog/addColumn.xml', '2023-01-13 01:26:03.112484', 3, 'EXECUTED', '8:475cfd28b0f5fda9c74d950ef9889d0f', 'addColumn tableName=reservation', '', NULL, '4.9.1', NULL, NULL, '3569563058');
INSERT INTO "public"."databasechangelog" VALUES ('2023-addColumn', 'zixiao', 'liquibase/changelog/addHourColumn.xml', '2023-01-14 00:25:38.075824', 4, 'EXECUTED', '8:b5cd5e779ed569829f9c95989fa526e3', 'addColumn tableName=reservation', '', NULL, '4.9.1', NULL, NULL, '3652338048');
