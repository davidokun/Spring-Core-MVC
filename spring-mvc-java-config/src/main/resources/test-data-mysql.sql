INSERT INTO test.user (username, password, enabled) VALUES ('user','password',TRUE);
INSERT INTO test.user (username, password, enabled) VALUES ('admin','password',TRUE);
INSERT INTO test.user (username, password, enabled) VALUES ('test1@outlook.com','12345',TRUE);
INSERT INTO test.user (username, password, enabled) VALUES ('test2@outlook.com','12345',TRUE);


INSERT INTO test.authorities (username,authority) VALUES ('user','ROLE_USER');
INSERT INTO test.authorities (username,authority) VALUES ('admin','ROLE_ADMIN');
INSERT INTO test.authorities (username,authority) VALUES ('test1@outlook.com','ROLE_USER');
INSERT INTO test.authorities (username,authority) VALUES ('test2@outlook.com','ROLE_USER');

INSERT INTO test.blog_post  (content, draft, publishdate, title, user_id)
VALUES ('Test Content Spring MVC',false,NOW(),'test',1);
