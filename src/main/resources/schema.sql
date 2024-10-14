drop table if exists MUSIC_STYLE;
drop table if exists USER_MUSIC_PREFERENCE;

create table USER_MUSIC_PREFERENCE(
  EMAIL varchar(250) not null,
  STYLE_ID int not null,
PRIMARY KEY ( EMAIL , STYLE_ID )
);

create table MUSIC_STYLE(
  STYLE_ID int not null AUTO_INCREMENT,
  NAME varchar(200) not null,
  PRIMARY KEY ( STYLE_ID )
);
