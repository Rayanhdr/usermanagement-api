ALTER TABLE users
    ADD CONSTRAINT uk_user_email UNIQUE (email);