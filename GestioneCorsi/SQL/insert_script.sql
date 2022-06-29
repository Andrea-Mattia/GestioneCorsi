insert into amministratore values(666, 'Betacom', 'Roma', 'Pass$01');

insert into docente values(1, 'Massimo', 'Ghianda', 'Ho fatto un sacco di cose belle e interessanti');
insert into docente values(2, 'Curzio', 'Pratillo', 'Trenitalia me deve ancora pagà');
insert into docente values(3, 'Franco', 'Franchi', 'I film sono belli, ma preferisco insegnare');


insert into corso values(1, 1, 'Java', TO_DATE('17/12/2023', 'DD/MM/YYYY'), TO_DATE('20/12/2023', 'DD/MM/YYYY'), 1200, 'Potrebbe essere leggermente complesso ma soddisfacente', 'AX12');
insert into corso values(2, 2, 'PHP', TO_DATE('19/02/2017', 'DD/MM/YYYY'), TO_DATE('30/12/2017', 'DD/MM/YYYY'), 3000, 'Corso di PHP della durata complessivamente giusta', 'JS22');
insert into corso values(3, 2, 'XML', TO_DATE('17/05/2022', 'DD/MM/YYYY'), TO_DATE('20/12/2022', 'DD/MM/YYYY'), 2200, '', 'AL88');
insert into corso values(4, 2, 'SQL', TO_DATE('01/06/2023', 'DD/MM/YYYY'), TO_DATE('01/10/2023', 'DD/MM/YYYY'), 3500, 'Questo lo seguirei volentieri', 'FS15');
insert into corso values(5, 3, 'HTML5', TO_DATE('06/03/2022', 'DD/MM/YYYY'), TO_DATE('20/10/2022', 'DD/MM/YYYY'), 6000, 'Acido desossiribonucleico', 'AJ81');
insert into corso values(6, 1, 'Python', TO_DATE('06/03/2023', 'DD/MM/YYYY'), TO_DATE('20/10/2023', 'DD/MM/YYYY'), 6000, 'Corso Python 300h', 'D4R7'); 

insert into corsista values(1, 'Max', 'Ghianda', 1);
insert into corsista values(2, 'Franco', 'Neri', 0);
insert into corsista values(3, 'Carcarlo', 'Pravettoni', 0);
insert into corsista values(4, 'Marco', 'Columbro', 1);
insert into corsista values(5, 'Giangiacomo', 'Verdi', 1);
insert into corsista values(6, 'Max', 'Duetregiorni', 1);
insert into corsista values(7, 'Franco', 'Fortissimo', 0);
insert into corsista values(8, 'Marco', 'Danubio', 1);
insert into corsista values(9, 'Paolo', 'Viola', 1);
insert into corsista values(10, 'Mario', 'Maria', 0);
insert into corsista values(11, 'Giovanni', 'Giostra', 1);
insert into corsista values(12, 'Daniele', 'Lanno', 1);

insert into corsista_corso values(1, 1);
insert into corsista_corso values(2, 2);
insert into corsista_corso values(3, 3);
insert into corsista_corso values(4, 4);
insert into corsista_corso values(5, 5);
insert into corsista_corso values(1, 3);
insert into corsista_corso values(5, 3);

insert into corsista_corso values(1, 6);
insert into corsista_corso values(2, 6);
insert into corsista_corso values(3, 6);
insert into corsista_corso values(4, 6);
insert into corsista_corso values(5, 6);
insert into corsista_corso values(6, 6);
insert into corsista_corso values(7, 6);
insert into corsista_corso values(8, 6);
insert into corsista_corso values(9, 6);
insert into corsista_corso values(10, 6);
insert into corsista_corso values(11, 6);
insert into corsista_corso values(12, 6);
 

commit