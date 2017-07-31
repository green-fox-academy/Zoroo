DROP TABLE IF EXISTS User_Profile;

CREATE TABLE IF NOT EXISTS User_Profile (
  id           BIGSERIAL PRIMARY KEY,
  username     VARCHAR(255) NOT NULL,
  password     VARCHAR(255) NOT NULL,
  good_answers  INTEGER,
  bad_answers   INTEGER
);

INSERT INTO User_Profile (username, password, good_answers,bad_answers) VALUES ('Mully','12345', 45, 69);
INSERT INTO User_Profile (username, password, good_answers,bad_answers) VALUES ('Norbert','norbert', 111, 12);
INSERT INTO User_Profile (username, password, good_answers,bad_answers) VALUES ('Marci','marci', 141, 2);

DROP TABLE IF EXISTS Geographic_Info;
CREATE TABLE IF NOT EXISTS Geographic_Info (
  id           BIGSERIAL PRIMARY KEY,
  country      VARCHAR(255) NOT NULL,
  capital      VARCHAR(255) NOT NULL,
  language     VARCHAR(255) NOT NULL,
  continent    VARCHAR(255) NOT NULL,
  famous_person VARCHAR(255) NOT NULL,
  landmark     VARCHAR(255) NOT NULL,
  flag         VARCHAR(255) NOT NULL
);
INSERT INTO Geographic_Info (country, capital, language, continent, famous_person, landmark, flag) VALUES
  ('Iran', 'Tehran', 'Persian/Farsi','Asia','Razi: Alcohol inventor!','Freedom Square', 'IR.jpg'),
  ('Germany', 'Berlin', 'German','Europe','Angela Merkel: Chancellor','Berlin Tower', 'DE.jpg'),
  ('France', 'Paris', 'French','Europe','Coco Chanel: Parfum inventor! ','Eiffel Tower', 'FR.jpg'),
  ('Spain', 'Madrid', 'Spanish','Europe','Enrique Iglesias: Salsa inventor! ','Ibiza Beach', 'ES.jpg'),
  ('Italy', 'Rome', 'Italian','Europe','Sophia Loren: Beauty inventor! ','Vatican', 'IT.jpg'),
  ('England', 'London', 'English','Europe','Queen: Palace inventor! ','Greenwich', 'UK.jpg'),
  ('USA', 'Washington', 'English','America','Trump: "covfefe" inventor! ','Greenwich', 'US.jpg'),
  ('Japan', 'Tokyo', 'Japanese','Asia','Kotaro Honda: Honda inventor! ','Fuji', 'JP.jpg'),
  ('Russia', 'Moscow', 'Russian','Asia','Putin: KGB inventor! ','Kremlin', 'RU.jpg'),
  ('Hungary', 'Budapest', 'hungarian', 'Europe','George Soros: EU inventor!', 'Hero Square','HU.jpg');

