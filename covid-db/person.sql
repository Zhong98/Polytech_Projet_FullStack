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

 Date: 16/01/2023 00:51:46
*/


-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS "public"."person";
CREATE TABLE "public"."person" (
  "id" int4 NOT NULL DEFAULT nextval('person_id_seq'::regclass),
  "firstname" varchar(255) COLLATE "pg_catalog"."default",
  "lastname" varchar(255) COLLATE "pg_catalog"."default",
  "email" varchar(255) COLLATE "pg_catalog"."default",
  "password" varchar(255) COLLATE "pg_catalog"."default",
  "role" int4,
  "centerid" varchar(32) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."person"."id" IS 'Id';
COMMENT ON COLUMN "public"."person"."firstname" IS 'Prénom';
COMMENT ON COLUMN "public"."person"."lastname" IS 'Nom';
COMMENT ON COLUMN "public"."person"."email" IS 'Email';
COMMENT ON COLUMN "public"."person"."password" IS 'Mot de passe';
COMMENT ON COLUMN "public"."person"."role" IS '0 est super admin; 1 est administrateur; 2 est médecin';
COMMENT ON COLUMN "public"."person"."centerid" IS 'Pour administrateur et médecin';
COMMENT ON TABLE "public"."person" IS 'Person table(Médecin,administrateur,super admin)';

-- ----------------------------
-- Primary Key structure for table person
-- ----------------------------
ALTER TABLE "public"."person" ADD CONSTRAINT "person_pkey" PRIMARY KEY ("id");
