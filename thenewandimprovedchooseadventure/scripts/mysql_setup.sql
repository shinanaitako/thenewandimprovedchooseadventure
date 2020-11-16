CREATE SCHEMA `chooseadventure` DEFAULT CHARACTER SET utf8 ;

CREATE USER 'flyway'@'%' IDENTIFIED BY 'q1w2e3r4';
GRANT ALL PRIVILEGES ON chooseadventure.* TO 'flyway'@'%';

CREATE USER 'chooseadventure'@'%' IDENTIFIED BY 'q1w2e3r4';
GRANT SELECT, UPDATE, INSERT, DELETE ON chooseadventure.* TO 'chooseadventure'@'%';

-- DROP SCHEMA `chooseadventure`;