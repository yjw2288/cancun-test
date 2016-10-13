use mysql;
create database consultant;

create user 'consultant'@'localhost' identified by 'consultant';
create user 'consultant-admin'@'localhost' identified by 'consultant';


INSERT INTO db (HOST,Db,USER,Select_priv,Insert_priv,Update_priv,Delete_priv,Create_priv,Drop_priv,Index_priv, Alter_priv) VALUES('localhost','consultant','consultant','Y','Y','Y','Y','N','N','N','N');

INSERT INTO db (HOST,Db,USER,Select_priv,Insert_priv,Update_priv,Delete_priv,Create_priv,Drop_priv,Index_priv, Alter_priv) VALUES('localhost','consultant','consultant-admin','Y','Y','Y','Y','Y','Y','Y','Y');

flush privileges;

use consultant;
