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

 Date: 16/01/2023 00:51:15
*/


-- ----------------------------
-- Table structure for databasechangeloglock
-- ----------------------------
DROP TABLE IF EXISTS "public"."databasechangeloglock";
CREATE TABLE "public"."databasechangeloglock" (
  "id" int4 NOT NULL,
  "locked" bool NOT NULL,
  "lockgranted" timestamp(6),
  "lockedby" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of databasechangeloglock
-- ----------------------------
INSERT INTO "public"."databasechangeloglock" VALUES (1, 'f', NULL, NULL);

-- ----------------------------
-- Primary Key structure for table databasechangeloglock
-- ----------------------------
ALTER TABLE "public"."databasechangeloglock" ADD CONSTRAINT "databasechangeloglock_pkey" PRIMARY KEY ("id");
