DROP TABLE IF EXISTS User_Profile;

CREATE TABLE IF NOT EXISTS User_Profile (
  id           BIGSERIAL PRIMARY KEY,
  username     VARCHAR(255) NOT NULL,
  password     VARCHAR(255) NOT NULL,
  goodAnswers  INTEGER,
  badAnswers   INTEGER
);

INSERT INTO User_Profile (username, password, goodAnswers,badAnswers) VALUES ('Mully','12345', 45, 69);

DROP TABLE IF EXISTS Geographic_Info;
CREATE TABLE IF NOT EXISTS Geographic_Info (
  id           BIGSERIAL PRIMARY KEY,
  country      VARCHAR(255) NOT NULL,
  capital      VARCHAR(255) NOT NULL,
  language     VARCHAR(255) NOT NULL,
  continent    VARCHAR(255) NOT NULL,
  famousPerson VARCHAR(255) NOT NULL,
  landmark     VARCHAR(255) NOT NULL,
  flag         VARCHAR(255) NOT NULL
);
INSERT INTO Geographic_Info (country, capital, language, continent, famousPerson, landmark, flag) VALUES
  ('Iran', 'Tehran', 'Persian/Farsi','Asia','Razi: Alcohol inventor!','Freedom Square', 'IR.jpg'),
  ('Hungary', 'Budapest', 'hungarian', 'Europe','George Soros: EU inventor!', 'Hero Square','HU.jpg');

