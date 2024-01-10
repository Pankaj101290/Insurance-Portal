SELECT * FROM ip.admin;
desc ip.admin;
ALTER TABLE ip.admin MODIFY COLUMN admin_photo BLOB;

SELECT * FROM ip.user;
desc ip.user;
ALTER TABLE ip.user MODIFY COLUMN user_photo BLOB;