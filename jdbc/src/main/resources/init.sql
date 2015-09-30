CREATE TABLE person (
  id INTEGER AUTO_INCREMENT,
  name VARCHAR(10) NOT NULL,
  surname VARCHAR(20) NOT NULL,
  email VARCHAR(35) NOT NULL,

  PRIMARY KEY (id)
);

CREATE TABLE personal_daily_kopr_index(
  person_id INTEGER AUTO_INCREMENT,
  date DATE NOT NULL,
  value VARCHAR(20) NOT NULL,

  PRIMARY KEY (person_id, date),
  FOREIGN KEY (person_id) REFERENCES person(id)
);

