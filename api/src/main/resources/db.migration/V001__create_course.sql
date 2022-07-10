CREATE SCHEMA bootstrap;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;
COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';

CREATE TABLE bootstrap.course (
  id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(1024) NOT NULL,
  stage VARCHAR(64) NOT NULL,
  tuition_fee DECIMAL(21,2) NOT NULL,
  CONSTRAINT course_pk PRIMARY KEY (id)
);
