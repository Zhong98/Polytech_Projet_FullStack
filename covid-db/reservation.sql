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

 Date: 16/01/2023 00:51:57
*/


-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS "public"."reservation";
CREATE TABLE "public"."reservation" (
  "id" int4 NOT NULL DEFAULT nextval('id_seq'::regclass),
  "firstname" varchar(255) COLLATE "pg_catalog"."default",
  "lastname" varchar(255) COLLATE "pg_catalog"."default",
  "email" varchar(255) COLLATE "pg_catalog"."default",
  "centerid" varchar(255) COLLATE "pg_catalog"."default",
  "date" varchar(255) COLLATE "pg_catalog"."default",
  "status" int4,
  "hour" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."reservation"."id" IS 'Id';
COMMENT ON COLUMN "public"."reservation"."firstname" IS 'Prénom';
COMMENT ON COLUMN "public"."reservation"."lastname" IS 'Nom';
COMMENT ON COLUMN "public"."reservation"."email" IS 'Email';
COMMENT ON COLUMN "public"."reservation"."centerid" IS 'Centre';
COMMENT ON COLUMN "public"."reservation"."date" IS 'Date';
COMMENT ON COLUMN "public"."reservation"."status" IS '0 est rdv pas encore validé, 1 est validé';
COMMENT ON COLUMN "public"."reservation"."hour" IS 'Heure';
COMMENT ON TABLE "public"."reservation" IS 'Reservation table';

-- ----------------------------
-- Primary Key structure for table reservation
-- ----------------------------
ALTER TABLE "public"."reservation" ADD CONSTRAINT "reservation_pkey" PRIMARY KEY ("id");
