CREATE SCHEMA bootstrap;

CREATE TABLE bootstrap.course (
  id BIGSERIAL NOT NULL,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(1024) NOT NULL,
  stage VARCHAR(64) NOT NULL,
  tuitionFee DECIMAL(21,2) NOT NULL,
  CONSTRAINT course_pk PRIMARY KEY (id)
);
