use consultant;

create table consultation_request (
	id bigint auto_increment,
	name varchar(255) not null,
	email varchar(255) not null,
	message text not null,
	created_at DATETIME default CURRENT_TIMESTAMP,
  modified_at DATETIME default CURRENT_TIMESTAMP,

	primary key(id)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8