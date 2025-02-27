create table TB_BOARD (BOARD_ID uuid not null, DEL_YN char(1) check (DEL_YN in ('N','Y')), ORD integer, primary key (BOARD_ID));
create table TB_BOARD_TITLE (TITLE_ID uuid not null, DEFAULT_YN char(1) check (DEFAULT_YN in ('N','Y')), LANG_CD varchar(255), TITLE_NAME varchar(255), BOARD_ID uuid, primary key (TITLE_ID));
create table TB_POST (ID varchar(255) not null, primary key (ID));