INSERT INTO accounts(user_name,password,enabled)
VALUES ('anmi','198327', TRUE);
INSERT INTO accounts(user_name,password,enabled)
VALUES ('alex','198327', TRUE);

INSERT INTO accounts(user_name,password,enabled)
VALUES ('vlpa','198327', FALSE);

INSERT INTO accounts(user_name,password,enabled)
VALUES ('anko','198327', FALSE);

INSERT INTO roles (role)
VALUES ('ROLE_ADMIN');
INSERT INTO roles (role)
VALUES ('ROLE_USER');


insert into mail_client_dev.accounts_roles values (1,1);
insert into mail_client_dev.accounts_roles values (2,2);
insert into mail_client_dev.accounts_roles values (3,2);
insert into mail_client_dev.accounts_roles values (4,2);