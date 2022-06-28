--------------------ADMIN
create table amministratore(
cod_admin int primary key,
nomeadmin varchar2(30) not null,
cognomeadmin varchar2(30) not null,
password varchar2(1000) not null);

create table docente(
cod_docente int,
nomedocente varchar2(30) not null,
cognomedocente varchar2(30) not null,
cvdocente varchar2(50) not null,
constraint p_coddocente primary key(cod_docente));

-------------------DATI CORSI/CORSISTI
create table corso(
cod_corso int,
cod_docente int,
nomecorso varchar2(30) not null,
datainizio date not null,
datafine date not null,
costocorso number(9,2) default 0,
commenticorso varchar2(200),
aulacorso varchar2(30) not null,
constraint p_codcorso primary key(cod_corso),
constraint f_coddocente foreign key(cod_docente) references docente(cod_docente) on delete cascade);

create table corsista(
cod_corsista int,
nomecorsista varchar2(30) not null,
cognomecorsista varchar2(30) not null,
precedentiformativi number(1) not null,
constraint p_codcorsista primary key(cod_corsista));

create table corsista_corso(
cod_corsista int,
cod_corso int,
constraint p_corsistacorso primary key(cod_corsista, cod_corso),
constraint f_codcorsista foreign key(cod_corsista) references corsista(cod_corsista) on delete cascade,
constraint f_codcorso foreign key(cod_corso) references corso(cod_corso) on delete cascade);


-----------------SEQUENZE
create sequence corso_seq;

create sequence corsista_seq;




