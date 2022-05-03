DROP TABLE IF EXISTS user_story CASCADE;
DROP SEQUENCE IF EXISTS user_story_id_seq;

CREATE TABLE user_story
(
    id                  long identity NOT NULL PRIMARY KEY,
    story_title         varchar(100) NOT NULL CHECK (CHAR_LENGTH(story_title) >= 5 ),
    user_story          varchar(400) NOT NULL,
    acceptance_criteria varchar(400) NOT NULL,
    business_value      double,
    status              varchar(20)
);