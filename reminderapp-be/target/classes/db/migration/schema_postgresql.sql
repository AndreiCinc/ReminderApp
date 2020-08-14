DROP TABLE IF EXISTS person
DROP TABLE IF EXISTS event

CREATE TABLE person (
  id UUID NOT NULL UNIQUE,
  personName VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  observations VARCHAR(300),
  role VARCHAR(10) NOT NULL
)

CREATE TABLE event (
  id UUID NOT NULL,
    eventName VARCHAR(200) NOT NULL,
    startDate timestamp  NOT NULL,
    endDate timestamp  NOT NULL,
    reminderDate timestamp NOT NULL,
    details VARCHAR(300),
    personId UUID NOT NULL PRIMARY KEY UNIQUE,
FOREIGN KEY (personId) REFERENCES person(id)
)